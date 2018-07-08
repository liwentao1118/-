package com.itheima;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.utils.BALLUtils;
import com.itheima.utils.SmsUtil;
import com.itheima.utils.UUIDUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestSms {
    @Test
    public void test() throws ClientException {
        String code = SmsUtil.sendSms("15957315663");
        System.out.println(code);
    }
    @Test
    public void test1(){
        System.out.println(UUIDUtils.getId());
    }
    @Test
    public void test2(){
        System.out.println(BALLUtils.getRed());
        System.out.println(BALLUtils.getBlue());
    }
    @Test
    public void test3(){
        String s = new Date().toLocaleString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        Date date = new Date();
        System.out.println(format.format(date));
        String format1 = format.format(date);
        System.out.println(s);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date()));
    }
    @Test
    public void test4(){
        Map<String ,Integer> map = new HashMap<>();
        map.put("ss",4);
        map.put("sd",1);
        map.put("ffg",5);
        map.put("jhg",3);
        System.out.println(map.size());

    }

}
