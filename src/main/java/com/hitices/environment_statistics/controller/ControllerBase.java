package com.hitices.environment_statistics.controller;

import com.hitices.common.MResponse;
import lombok.Getter;
import lombok.Setter;

public class ControllerBase
{

    protected static<T> MResponse Ok(T object)
    {
        MResponse response= MResponse.successMResponse();
        response.setData(object);
        return response;
    }
    protected static MResponse Failed()
    {
        return MResponse.failedMResponse();
    }
}
