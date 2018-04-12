package com.yxt.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author luoxiaozhu
 * @date 2018-2-1-0001 15:39
 */
public class ApiUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String now() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(new Date());
    }

    public static String dataFormat(String time){
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM");
        if(StringUtils.isBlank(time)){
            return f1.format(new Date());
        }
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = f2.parse(time);
            return f1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
