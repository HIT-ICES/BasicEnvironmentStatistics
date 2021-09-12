package com.hitices.environment_statistics.controller;

import com.hitices.common.MResponse;
import com.hitices.environment_statistics.bean.IdBean;
import com.hitices.environment_statistics.bean.SchemaBean;
import com.hitices.environment_statistics.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/statistic/schema")
public class StatisticSchemaController extends ControllerBase
{
    @Autowired
    @Qualifier("SchemaServiceImpl")
    private SchemaService schemaService;

    @PostMapping(value = "/get")
    public MResponse get(@RequestBody IdBean id)
    {
        Optional<SchemaBean> schema= schemaService.get(id.getId());
        return schema.map(ControllerBase::Ok).orElseGet(ControllerBase::Failed);
    }

    @PostMapping(value = "/remove")
    public MResponse remove(@RequestBody IdBean id)
    {
        Optional<SchemaBean> schema= schemaService.remove(id.getId());
        return schema.map(ControllerBase::Ok).orElseGet(ControllerBase::Failed);
    }

    @PostMapping(value = "/add")
    public MResponse add(@RequestBody SchemaBean schema)
    {
        return Ok(schemaService.create(schema));
    }
}
