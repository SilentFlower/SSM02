package xyz.silentflower.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/3/20 02:52:07
 * @description
 */
public class DateUtils {
    //日期转换转字符串
    public static String data2String(Date date,String pat){
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        String format = sdf.format(date);
        return format;
    }

    public static Date string2Date(String str,String pat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        Date parse = sdf.parse(str);
        return parse;
    }

}
