package com.hitices.environment_statistics.controller;

import com.hitices.common.MResponse;
import com.hitices.environment_statistics.bean.*;
import com.hitices.environment_statistics.service.DataService;
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
    public MResponse get(@RequestBody IdBean id)
    {
        Optional<DatumBean> datum = dataService.get(id.getId());
        return datum.map(ControllerBase::Ok).orElseGet(ControllerBase::Failed);
    }

    @PostMapping(value = "/remove")
    public MResponse remove(@RequestBody BatchRemoveBean ids)
    {
        return Ok(dataService.remove(ids.getId()));
    }

    @PostMapping(value = "/insert")
    public MResponse insert(@RequestBody BatchInsertBean data)
    {
        return Ok(dataService.insert(data));
    }

    @PostMapping(value = "/select")
    public MResponse select(@RequestBody SelectBean filter)
    {
        return Ok(dataService.select(filter));
    }
}
