package com.platform.admin.common.result;

import java.util.HashMap;

/**
 * Created by yankun on 2015/6/17 0017.
 */
public class JsonResult extends HashMap<String,Object> {
    private static final String SUCCESS = "success";
    private static final String DATA = "data";
    private static final String MESSAGE = "message";

    public void setSuccess (boolean success){
        put(SUCCESS,success);
    }
    public void setMessage(String message){
        put(MESSAGE,message);
    }
    public void setData(Object data){
        put(DATA,data);
    }

    public boolean isSuccess (){
        return (Boolean)get(SUCCESS);
    }
    public String getMessage(){
        return (String)get(MESSAGE);
    }
    public Object getData(){
        return get(DATA);
    }


}
