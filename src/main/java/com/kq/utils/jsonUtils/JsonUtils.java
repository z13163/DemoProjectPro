package com.kq.utils.jsonUtils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtils {

    /**
     * 前端时间戳转   yyyy-MM-dd
     * @param birthday
     * @return
     * @throws ParseException
     */
    public static Date TimestampToDate(Date birthday) throws ParseException {
        System.err.println(birthday);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(birthday);
        Date parse = simpleDateFormat.parse(format);
        return parse;
    }
}
