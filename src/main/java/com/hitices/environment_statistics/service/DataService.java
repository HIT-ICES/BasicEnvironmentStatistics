package com.hitices.environment_statistics.service;

import com.hitices.environment_statistics.bean.BatchInsertBean;
import com.hitices.environment_statistics.bean.DatumBean;
import com.hitices.environment_statistics.bean.SelectBean;

import java.util.Optional;

public interface DataService
{
    String[] insert(BatchInsertBean data);
    int remove(String[] ids);
    String[] select(SelectBean filter);
    Optional< DatumBean> get(String id);
}
