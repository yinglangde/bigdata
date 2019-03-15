package com.zhangbin.common;

import java.util.HashMap;
import java.util.Map;

public class ResponseFactory {

    public static Object instance(Boolean b , Object data, String msg){
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("success",b);
        map.put("data",data);
        map.put("msg",msg);
        return map;
    }

}
