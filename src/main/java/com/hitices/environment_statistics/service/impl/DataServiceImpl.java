package com.hitices.environment_statistics.service.impl;

import com.hitices.environment_statistics.bean.BatchInsertBean;
import com.hitices.environment_statistics.bean.DatumBean;
import com.hitices.environment_statistics.bean.SelectBean;
import com.hitices.environment_statistics.dao.DatumRepository;
import com.hitices.environment_statistics.dao.SchemaRepository;
import com.hitices.environment_statistics.entity.Datum;
import com.hitices.environment_statistics.entity.FieldType;
import com.hitices.environment_statistics.entity.Schema;
import com.hitices.environment_statistics.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Qualifier("DataServiceImpl")
public class DataServiceImpl implements DataService
{
    @Autowired
    private DatumRepository datumRepository;
    @Autowired
    private SchemaRepository schemaRepository;

    @Override
    public String[] insert(BatchInsertBean data)
    {
        String id = data.getSchemaId();
        Optional<Schema> schemaOps = schemaRepository.findById(id);
        if (!schemaOps.isPresent()) return new String[0];
        Boolean[] fieldConvert = schemaOps.get().getFields().stream()
                .map(f -> (f.getType().equals(FieldType.ENUM) | f.getType().equals(FieldType.TEXT)))
                .toArray(Boolean[]::new);
        Base64.Encoder encoder = Base64.getEncoder();
        return datumRepository.saveAll(
                Arrays.stream(data.getData())
                        .filter(expr -> expr.length == fieldConvert.length)
                        .map((expr) ->
                        {

                            StringBuilder sb = new StringBuilder();

                            for (int i = 0; i < expr.length; i++)
                            {
                                sb.append(fieldConvert[i] ?
                                        encoder.encodeToString(expr[i].getBytes()) : expr[i]);
                                if (i + 1 != expr.length)
                                    sb.append(",");
                            }
                            Datum datum = new Datum();
                            datum.setSchemaId(id);
                            datum.setValue(sb.toString());
                            return datum;
                        }).collect(Collectors.toList())
        ).stream().map(Datum::getId).toArray(String[]::new);
    }

    @Override
    public int remove(String[] ids)
    {
        List<Datum> found = datumRepository.findAllById(Arrays.asList(ids));
        datumRepository.deleteAll(found);
        return found.size();
    }

    @Override
    public String[] select(SelectBean filter)
    {
        return datumRepository.findAllBySchemaIdAndUpdateTimeBetween(
                filter.getSchemaId(),
                filter.getStart(),
                filter.getEnd()
        ).stream().map(Datum::getId).toArray(String[]::new);
    }

    @Override
    public Optional<DatumBean> get(String id)
    {
        Optional<Datum> datumOp = datumRepository.findById(id);
        if (!datumOp.isPresent()) return Optional.empty();
        Datum datum=datumOp.get();
        Optional<Schema> schemaOp=schemaRepository.findById(datum.getSchemaId());
        if (!schemaOp.isPresent()) return Optional.empty();
        Boolean[] fieldConvert = schemaOp.get().getFields().stream()
                .map(f -> (f.getType().equals(FieldType.ENUM) | f.getType().equals(FieldType.TEXT)))
                .toArray(Boolean[]::new);
        String[] values=new String[fieldConvert.length];
        String[] origin= datum.getValue().split(",");
        Base64.Decoder decoder= Base64.getDecoder();

        for (int i=0;i<values.length;i++){
            values[i]=fieldConvert[i]? new String (decoder.decode(origin[i])):origin[i];
        }
        DatumBean r=new DatumBean();
        r.setSchemaId(datum.getSchemaId());
        r.setId(id);
        r.setValues(values);
        return Optional.of(r);
    }
}
