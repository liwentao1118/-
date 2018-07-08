package com.itheima.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getId(){
       String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        return uuid;
    }
    public static String getCode(){
        return getId();
    }
}
