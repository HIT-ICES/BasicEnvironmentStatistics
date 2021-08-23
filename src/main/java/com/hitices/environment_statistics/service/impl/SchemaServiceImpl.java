package com.hitices.environment_statistics.service.impl;

import com.hitices.environment_statistics.bean.SchemaBean;
import com.hitices.environment_statistics.service.SchemaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("SchemaServiceImpl")
public class SchemaServiceImpl implements SchemaService
{
    @Override
    public String create(SchemaBean schema)
    {
        return null;
    }

    @Override
    public Optional<SchemaBean> get(String id)
    {
        return Optional.empty();
    }

    @Override
    public Optional<SchemaBean> remove(String id)
    {
        return Optional.empty();
    }
}
