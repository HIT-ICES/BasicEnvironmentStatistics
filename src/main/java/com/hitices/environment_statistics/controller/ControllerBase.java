package com.hitices.environment_statistics.controller;

import lombok.Getter;
import lombok.Setter;

public class ControllerBase
{
    @Getter
    @Setter
    public static class ActionResult<T> {
        T data;
        String status;
        int code;
        public ActionResult<T> data(T data){
            this.data = data;
            return this;
        }
        public ActionResult<T> code(int code){
            this.code = code;
            return this;
        }
        public ActionResult<T> status(String status){
            this.status = status;
            return this;
        }
    }
    protected static<T> ActionResult<T> Ok(T object)
    {
        return new ActionResult<T>().code(1).status("success").data(object);
    }
    protected static<T> ActionResult<T> Failed()
    {
        return new ActionResult<T>().code(0).status("failed");
    }
}
