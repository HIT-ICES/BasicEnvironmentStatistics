package com.hitices.environment_statistics.controller;

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
    public ActionResult<SchemaBean> get(@RequestBody IdBean id)
    {
        Optional<SchemaBean> schema= schemaService.get(id.getId());
        if(schema.isPresent()){
            return Ok(schema.get());
        }
        return Failed();
    }

    @PostMapping(value = "/remove")
    public ActionResult<SchemaBean> remove(@RequestBody IdBean id)
    {
        Optional<SchemaBean> schema= schemaService.remove(id.getId());
        if(schema.isPresent()){
            return Ok(schema.get());
        }
        return Failed();
    }

    @PostMapping(value = "/add")
    public ActionResult<String> add(@RequestBody SchemaBean schema)
    {
        return Ok(schemaService.create(schema));
    }
}
