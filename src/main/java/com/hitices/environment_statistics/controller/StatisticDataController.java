package com.hitices.environment_statistics.controller;

import com.hitices.environment_statistics.bean.*;
import com.hitices.environment_statistics.entity.Schema;
import com.hitices.environment_statistics.service.DataService;
import com.hitices.environment_statistics.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/statistic/data")
public class StatisticDataController extends ControllerBase
{
    @Autowired
    @Qualifier("DataServiceImpl")
    private DataService dataService;

    @PostMapping(value = "/get")
    public ActionResult<DatumBean> get(@RequestBody IdBean id)
    {
        Optional<DatumBean> datum = dataService.get(id.getId());
        if (datum.isPresent())
        {
            return Ok(datum.get());
        }
        return Failed();
    }

    @PostMapping(value = "/remove")
    public ActionResult<Integer> remove(@RequestBody BatchRemoveBean ids)
    {
        return Ok(dataService.remove(ids.getId()));
    }

    @PostMapping(value = "/insert")
    public ActionResult<String[]> insert(@RequestBody BatchInsertBean data)
    {
        return Ok(dataService.insert(data));
    }

    @PostMapping(value = "/select")
    public ActionResult<String[]> select(@RequestBody SelectBean filter)
    {
        return Ok(dataService.select(filter));
    }
}
