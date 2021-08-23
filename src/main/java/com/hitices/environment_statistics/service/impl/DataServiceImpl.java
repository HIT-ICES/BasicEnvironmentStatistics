package com.hitices.environment_statistics.service.impl;

import com.hitices.environment_statistics.bean.BatchInsertBean;
import com.hitices.environment_statistics.bean.DatumBean;
import com.hitices.environment_statistics.bean.SelectBean;
import com.hitices.environment_statistics.service.DataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("DataServiceImpl")
public class DataServiceImpl implements DataService
{
    @Override
    public String[] insert(BatchInsertBean data)
    {
        return new String[0];
    }

    @Override
    public int remove(String[] ids)
    {
        return 0;
    }

    @Override
    public String[] select(SelectBean filter)
    {
        return new String[0];
    }

    @Override
    public Optional<DatumBean> get(String id)
    {
        return Optional.empty();
    }
}
