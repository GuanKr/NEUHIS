package neu.his.converter;



import org.springframework.core.convert.converter.Converter;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关处理
 * @author lsy
 * @since 1.8
 * @version 1.0
 */
public class DateConverter implements Converter<String, Date> {

    /**
     * 返回date类型日期
     * @param s 日期字符串
     * @return date日期
     */
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获得日期的星期数
     * @param date 日期
     * @return 星期数
     */
    public String getWeek(Date date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 获得某天的第二天的日期
     * @param today 某天
     * @return 第二天
     */
    public Date tomorrow(Date today) {
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = c.getTime();
        return tomorrow;
    }

    /**
     * 获得当天日期的字符串类型
     * @return 当天日期的字符串
     */
    public String nowDate(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);
        return temp_str;
    }

    /**
     * 获得当天的午别
     * @return 午别
     */
    public String nowNoon(Date date){
        String temp_str="";
//        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("aa");
        temp_str=sdf.format(date);
        return temp_str;
    }

    /**
     * 获得当天的年份
     * @return 年份
     */
    public String nowYear(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        temp_str=sdf.format(dt);
        return temp_str;
    }

    /**
     * 获得流水号需要的yyyyMMdd类型日期
     * @return 日期
     */
    public String serNumber(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        temp_str=sdf.format(dt);
        return temp_str;
    }



}

