package com.hitices.environment_statistics.service;

import com.hitices.environment_statistics.bean.SchemaBean;

import java.util.Optional;

public interface SchemaService
{
    String create(SchemaBean schema);

    Optional<SchemaBean> get(String id);

    Optional<SchemaBean> remove(String id);
}
