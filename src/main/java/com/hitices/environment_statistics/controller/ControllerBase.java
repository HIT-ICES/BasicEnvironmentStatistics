package com.hitices.environment_statistics.controller;

import com.hitices.common.MResponse;

public class ControllerBase
{

    protected static <T> MResponse Ok(T object)
    {
        MResponse response = MResponse.successMResponse();
        response.set("data", object);
        return response;
    }

    protected static MResponse Failed()
    {
        return MResponse.failedMResponse();
    }
}
