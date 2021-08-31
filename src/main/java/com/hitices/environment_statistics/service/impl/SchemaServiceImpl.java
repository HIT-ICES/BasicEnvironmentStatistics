package com.hitices.environment_statistics.service.impl;

import com.hitices.environment_statistics.bean.SchemaBean;
import com.hitices.environment_statistics.dao.SchemaRepository;
import com.hitices.environment_statistics.entity.Schema;
import com.hitices.environment_statistics.entity.SchemaField;
import com.hitices.environment_statistics.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@Qualifier("SchemaServiceImpl")
public class SchemaServiceImpl implements SchemaService
{
    @Autowired
    private SchemaRepository schemaRepository;

    @Override
    public String create(SchemaBean schema)
    {
        Schema schemaDao = new Schema();
        schemaDao.setName(schema.getName());
        schemaDao.setDescription(schema.getDescription());
        AtomicInteger i = new AtomicInteger();
        schemaDao.setFields(schema.getFields().stream()
                .map(f ->
                {
                    SchemaField field = new SchemaField();
                    field.setType(f.getType());
                    field.setDescription(f.getDescription());
                    field.setName(f.getName());
                    field.setValue(f.getValue());
                    field.setSchemaId(schema.getId());
                    field.setIndex(i.getAndIncrement());
                    return field;
                }).collect(Collectors.toList()));
        return schemaRepository.save(schemaDao).getId();
    }

    @Override
    public Optional<SchemaBean> get(String id)
    {
        Optional<Schema> schemaOp = schemaRepository.findById(id);
        if (!schemaOp.isPresent()) return Optional.empty();
        Schema schema = schemaOp.get();
        SchemaBean schemaDao = new SchemaBean();
        schemaDao.setName(schema.getName());
        schemaDao.setDescription(schema.getDescription());
        schemaDao.setFields(schema.getFields().stream()
                .map(f ->
                {
                    SchemaBean.SchemaFieldBean field = new SchemaBean.SchemaFieldBean();
                    field.setType(f.getType());
                    field.setDescription(f.getDescription());
                    field.setName(f.getName());
                    field.setValue(f.getValue());
                    return field;
                }).collect(Collectors.toList()));
        return Optional.of(schemaDao);

    }

    @Override
    public Optional<SchemaBean> remove(String id)
    {
        Optional<SchemaBean> schema = get(id);
        if (schema.isPresent()) schemaRepository.deleteById(id);
        return schema;
    }
}
