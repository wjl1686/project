package com.ejobim.opplat.util;

import com.alibaba.fastjson.JSON;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xibian
 */
public class DateUtils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat dateFormatNo = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dateFormatFullXG = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static SimpleDateFormat dateFormatPart = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat dateFormatDayPart = new SimpleDateFormat("dd");
    private static SimpleDateFormat dateFormatPartMinute = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static long DAY_COUNT_OF_YEAR = 365;
    private static long DAY_TIME = 24 * 3600 * 1000;
    private static long HOUR_TIME = 3600 * 1000;

    public static void main(String args[]) {
        Date date2 = DateUtils.parseDateFull("2019-12-25 04:16:19");
       // System.out.println(formateDate(getNowWeekMouthNumbers(date2)));
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date2);
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(DateUtils.dateFormatFullXG(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(date2), -1)));
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();


        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String ZUOTIAN=sp.format(d);
        System.out.println(ZUOTIAN);


        Date today = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String yesterday = simpleDateFormat.format(today);
        System.out.println(yesterday);
        String str ="aaaaabdcwdadawa";
        char[] chars = str.toCharArray();
        System.out.println(JSON.toJSON(chars));
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
       for(int i =0;i<str.length();i++){
           //System.out.println(str.charAt(i));
           char c = str.charAt(i);
           if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
           }else {
               map.put(c,1);
           }
       }
        for (Character character : map.keySet()) {
            System.out.println(character+"|||"+"value="+map.get(character));
        }
        System.out.println(JSON.toJSON(map));

    }


    public static String formateDate(String dateFormatString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        return dateFormat.format(new Date());
    }

    public static String formateDate(Date date) {
        if (date != null) {
            return dateFormat.format(date);
        } else {
            return "";
        }

    }

    public static String formateDateDayPart(Date date) {
        return dateFormatDayPart.format(date);
    }

    public static String formateDateFull(Date date) {
        return dateFormatFull.format(date);
    }

    public static String dateFormatFullXG(Date date) {
        return dateFormatFullXG.format(date);
    }

    public static String formateDatePartMinute(Date date) {
        return dateFormatPartMinute.format(date);
    }

    public static String formateDatePart(Date date) {
        return dateFormatPart.format(date);
    }

    public static String formateDatePartNo(Date date) {
        return dateFormatNo.format(date);
    }

    public static String formateMyDate(Date date, String format) {
        SimpleDateFormat myDateFormat = new SimpleDateFormat(format);
        return myDateFormat.format(date);
    }

    public static Date parseDate(String str) {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateNo(String str) {
        try {
            return dateFormatNo.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateFull(String str) {
        try {
            return dateFormatFull.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateFullPartMinute(String str) {
        try {
            return dateFormatPartMinute.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getYear(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        return cd.get(Calendar.YEAR);
    }

    public static Date getNextDate(String str) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormat.parse(str));
            cd.add(Calendar.DAY_OF_MONTH, 1);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextDate(String str, int dayCount) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormat.parse(str));
            cd.add(Calendar.DAY_OF_MONTH, dayCount);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextDateFull(String str, int dayCount) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormatFull.parse(str));
            cd.add(Calendar.DAY_OF_MONTH, dayCount);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextDateFullXG(String str, int dayCount) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormatFullXG.parse(str));
            cd.add(Calendar.DAY_OF_MONTH, dayCount);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextHourFull(String str, int hour) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormatFull.parse(str));
            cd.add(Calendar.HOUR_OF_DAY, hour);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextHour(String str, int hour) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormat.parse(str));
            cd.add(Calendar.HOUR_OF_DAY, hour);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextHourFullXG(String str, int hour) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormatFullXG.parse(str));
            cd.add(Calendar.HOUR_OF_DAY, hour);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getFullNextHour(String str, int hour) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormatFull.parse(str));
            cd.add(Calendar.HOUR_OF_DAY, hour);
            return cd.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getDateOfWeek(String str) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormat.parse(str));
            return cd.get(Calendar.DAY_OF_WEEK) - 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getDateOfMonth(String str) {
        try {
            Calendar cd = Calendar.getInstance();
            cd.setTime(dateFormat.parse(str));
            return cd.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // 获得本周一与当前日期相差的天数
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            System.out.println("11");
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    // 获得当前周- 周一的日期
    public static String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }


    // 获得当前周- 周日  的日期
    public static String getPreviousSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得当前月--开始日期
    public static String getMinMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获得当前月--结束日期
    public static String getMaxMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获取两个日期之间的日期列表
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<String> getDistDayList(Date beginDate, Date endDate) {
        List<String> list = new ArrayList<>();
        int dayCount = differentDays(beginDate, endDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        list.add(formateDate(calendar.getTime()));
        for (int i = 0; i < dayCount; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            list.add(formateDate(calendar.getTime()));
        }
        return list;
    }

    /**
     * 获取两个日期之间的日列列表(排除周六周日)
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<String> getDistWorkDayList(Date beginDate, Date endDate, boolean onlyWork) {
        List<String> list = new ArrayList<>();
        int dayCount = differentDays(beginDate, endDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        list.add(formateDate(calendar.getTime()));
        for (int i = 0; i < dayCount; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            //如果是周日或者周六
            if (onlyWork) {
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                    continue;
                }
            }

            list.add(formateDate(calendar.getTime()));
        }
        return list;
    }

    /**
     * 获取两个日期之间的时间差
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static String getMonthFirstDay() {
        //规定返回日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        //设置为第一天
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = sf.format(gcLast.getTime());
        //打印本月第一天
        System.out.println(day_first);
        return day_first;
    }

    public static Date getMonthFirstDay(int year, int month) {

        //year="2018" month="2"
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        format.format(calendar.getTime());
        try {
            return format.parse(format.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取制定年,月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthLastDay(int year, int month) {

        //year="2018" month="2"
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        // DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        return calendar.getTime();
    }

    /**
     * 获取当前月的最后一天
     *
     * @return
     */
    public static String getMonthLastDay() {
        //规定返回日期格式
        //获取Calendar
        Calendar calendar = Calendar.getInstance();
        //设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
        //设置日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String day_first = sf.format(calendar.getTime());
        System.out.println(day_first);
        return day_first;
    }

    public static Date addMonth(Date date, int addMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, addMonth);
        return calendar.getTime();
    }

    /**
     * 获取时间差后的数据
     *
     * @param date
     * @param timeType
     * @param addTime
     * @return
     */
    public static Date getNextTime(Date date, int timeType, int addTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(timeType, addTime);
        return calendar.getTime();
    }

    public static long getZeroDay() {
        Long time = System.currentTimeMillis();  //当前时间的时间戳
        long zero = time / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        return zero;
    }

    public static long get23Day() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        long tt = calendar.getTime().getTime();
        return tt;
    }

    /**
     * 根据上次的日期和周期获取下一次的日期
     *
     * @param lastDate
     * @param cycle
     * @return
     */
    public static Date getNextDate(Date lastDate, int cycle) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, cycle);
        return calendar.getTime();

    }

    public static Date getNextDateTime(Date lastDate, int cycle) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDate);
        calendar.add(Calendar.DAY_OF_MONTH, cycle);
        return calendar.getTime();

    }

    /**
     * 判断是时间间隔
     *
     * @param date1
     * @param date2
     * @return boolean
     * @throws Exception
     */

    public static double judgmentDate(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date start = null;
        try {
            start = sdf.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date end = null;
        try {
            end = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long cha = end.getTime() - start.getTime();
        return cha * 1.0 / (1000 * 60 * 60);

    }

    public static String isWeekend(String bDate) throws ParseException {
        DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        Date bdate = format1.parse(bDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return "OK";
        } else {
            return "NO";
        }
    }

    /**
     * 获取某段时间内的周一（二等等）的日期
     *
     * @param dataBegin 开始日期
     * @param dataEnd   结束日期
     * @param weekDays  获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<String> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        String[] dateInterval = {dataBegin, dataEnd};
        Date[] dates = new Date[dateInterval.length];
        for (int i = 0; i < dateInterval.length; i++) {
            String[] ymd = dateInterval[i].split("[^\\d]+");
            cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
            dates[i] = cal.getTime();
        }
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
            cal.setTime(date);
            if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
                String format = sdf.format(date);
                dateResult.add(format);
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }
        return dateResult;
    }

    /**
     * 根据日期获取当天是周几
     *
     * @param datetime 日期
     * @return 周几
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = sdf.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

    /**
     * 当前时间所在一周的周一
     *
     * @param
     * @return
     */
    public static String getMonWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        return weekBegin;
    }

    /**
     * 当前时间所在周日时间
     *
     * @param
     * @return
     */
    public static String getSunWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);
        System.out.println("所在周星期日的日期：" + weekEnd);
        return weekEnd;
    }

    /**
     * 获取当前日期所在周的周日
     */
    public static String getSunDayOfWeek() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        // 如果是周日直接返回
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return sf.format(c.getTime());
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        c.add(Calendar.DATE, 7 - c.get(Calendar.DAY_OF_WEEK) + 1);
        String sunDay = sf.format(c.getTime());
        return sunDay;
    }

    /**
     * 当前时间所在一周的周一和周日时间
     *
     * @param
     * @return
     **/
    public static Map<String, String> getWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        System.out.println("所在周星期一的日期：" + weekBegin);


        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);
        System.out.println("所在周星期日的日期：" + weekEnd);

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }

    /**
     * 将时长转换为年月日时分秒
     *
     * @param time
     * @return
     */
    public static String getTimeString(long time) {

        StringBuffer timeString = new StringBuffer();
        long year = time / DAY_COUNT_OF_YEAR / DAY_TIME;
        if (year > 0) {
            timeString.append(year);
            timeString.append("年");
        }
        long current = time - (DAY_COUNT_OF_YEAR * DAY_TIME * year);
        long day = current / DAY_TIME;

        timeString.append(day);
        timeString.append("天");
        current = current % DAY_TIME;
        long hour = current / HOUR_TIME;
        if (hour > 0) {
            timeString.append(hour);
            timeString.append("小时");
        }
        return timeString.toString();

    }

    public static boolean isWeekEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断时间交叉(跨天需要拆分)如 23:00-08:00  23:00-24:00  00:00-08:00
     */
    public boolean checkTime2(String startFrom, String endFrom, String startDb, String endDb) {
        boolean flag = true;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date leftStartDate = null;
        Date leftEndDate = null;
        Date rightStartDate = null;
        Date rightEndDate = null;
        try {
            leftStartDate = format.parse(startFrom);
            leftEndDate = format.parse(endFrom);
            rightStartDate = format.parse(startDb);
            rightEndDate = format.parse(endDb);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean result = ((leftStartDate.getTime() >= rightStartDate.getTime())
                && leftStartDate.getTime() < rightEndDate.getTime())
                ||
                ((leftStartDate.getTime() > rightStartDate.getTime())
                        && leftStartDate.getTime() <= rightEndDate.getTime())
                ||
                ((rightStartDate.getTime() >= leftStartDate.getTime())
                        && rightStartDate.getTime() < leftEndDate.getTime())
                ||
                ((rightStartDate.getTime() > leftStartDate.getTime())
                        && rightStartDate.getTime() <= leftEndDate.getTime());
        if (result) {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断时间间隔多少小时
     */
    public static long dateDiff(String startTime, String endTime) throws Exception {
        //按照传入的格式生成一个simpledateformate对象
        //SimpleDateFormat sd = new SimpleDateFormat(dateFormatFull);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
        long nh = 1000 * 60 * 60;//一小时的毫秒数
        long nm = 1000 * 60;//一分钟的毫秒数
        long ns = 1000;//一秒钟的毫秒数
        long diff;
        //获得两个时间的毫秒时间差异
        diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
        long day = diff / nd;//计算差多少天
        long hour = diff / nh;//计算差多少小时
        long min = diff / nm;//计算差多少分钟
        long sec = diff / ns;//计算差多少秒//输出结果
        // System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
        return hour;
    }

    /**
     * 获取当前本年年号和月份和月份日期所在的周数)
     *
     * @return 201917
     */
    public static String getNowWeekMouthNumbers(Date date) {
        String weekNumbers = "0";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setTime(date);
            int weekCount = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
            int weekIndex = calendar.get(Calendar.WEEK_OF_MONTH);

            if (weekIndex == 1) {
                Date firstDate = getFirstDay(date, 1);
                Calendar newCalendar = Calendar.getInstance();
                newCalendar.setTime(firstDate);
                newCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                //超过周三 则计入上一个月

                if (newCalendar.get(Calendar.DAY_OF_WEEK) > 5 || newCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                    //计入上一个月
                    newCalendar.add(Calendar.DAY_OF_MONTH, -1);
                    weekNumbers = sdf.format(newCalendar.getTime()) + "0" + getMonthWeekCount(newCalendar.getTime());
                } else {
                    weekNumbers = sdf.format(date) + "01";
                }
            } else if (weekIndex == weekCount) {
                //如果是最后一周
                Date firstDate = getFirstDay(date, 1);
                Calendar firstCalendar = Calendar.getInstance();
                firstCalendar.setTime(firstDate);
                firstCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                Date lastDate = getMonthLastDay(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1);
                Calendar newCalendar = Calendar.getInstance();
                newCalendar.setTime(lastDate);
                newCalendar.setFirstDayOfWeek(Calendar.MONDAY);

                if (newCalendar.get(Calendar.DAY_OF_WEEK) < 5 && newCalendar.get(Calendar.DAY_OF_WEEK) > 1) {
                    newCalendar.add(Calendar.DAY_OF_MONTH, 1);
                    weekNumbers = sdf.format(newCalendar.getTime()) + "01";
                } else {
                    if (firstCalendar.get(Calendar.DAY_OF_WEEK) > 5 || firstCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                        //如果本月的第一周计入上一月
                        weekNumbers = sdf.format(date) + "0" + (weekIndex - 1);
                    }else {
                        weekNumbers = sdf.format(date) + "0" + (weekIndex);
                    }
                }

            }else{
                Date firstDate = getFirstDay(date, 1);
                Calendar firstCalendar = Calendar.getInstance();
                firstCalendar.setTime(firstDate);
                firstCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                if (firstCalendar.get(Calendar.DAY_OF_WEEK) > 5 || firstCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                    //如果本月的第一周计入上一月
                    weekNumbers = sdf.format(date) + "0" + (weekIndex - 1);
                }else {
                    weekNumbers = sdf.format(date) + "0" + (weekIndex);
                }
            }
            //weekNumbers = sdf.format(date) + (calendar.get(Calendar.MONTH) + 1) + "0" + calendar.get(Calendar.WEEK_OF_MONTH) + "";
        } catch (Exception e) {
            System.out.println(e);
        }
        return weekNumbers;
    }

    private static int getMonthWeekCount(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        if (calendar.get(Calendar.DAY_OF_WEEK) > 5 || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH) -1;
        }else{
            return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        }
    }

    /**
     * 获取当月的最后一周
     *
     * @param date
     * @return
     */
    private static int getLastWeedIndex(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当前为全年第几周(附加本年年号)
     *
     * @return 201917
     */
    public static String getNowWeekNumbers() {
        String weekNumbers = "0";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            calendar.setTime(date);
            weekNumbers = sdf.format(date) + calendar.get(Calendar.WEEK_OF_YEAR) + "";
        } catch (Exception e) {
            System.out.println(e);
        }
        return weekNumbers;
    }

    /**
     * 获取当前本年年号和月份和月份日期所在的周数)
     *
     * @return 201917
     */
    public static String getNowWeekMouthNumbers() {
        String weekNumbers = "0";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            calendar.setTime(date);
            weekNumbers = sdf.format(date) + (calendar.get(Calendar.MONTH) + 1) + "0" + calendar.get(Calendar.WEEK_OF_MONTH) + "";
        } catch (Exception e) {
            System.out.println(e);
        }
        return weekNumbers;
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }


    /**
     * 获取当前日期的 本周一 本月第一天 本季度第一天 及本年度第一天
     *
     * @param date
     * @param type
     * @return
     */
    public static Date getFirstDay(Date date, int type) {
        //规定返回日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(date);
        //设置为第一天
        if (type == 1) {
            gcLast.set(Calendar.DAY_OF_MONTH, 1);
        }
        if (type == 2) {
            gcLast.set(Calendar.DAY_OF_YEAR, 1);
        }
        if (type == 3) {
            int month = gcLast.get(Calendar.MONTH);
            if (month >= 0 && month < 3) {
                gcLast.set(Calendar.MONTH, 0);
            } else if (month >= 3 && month < 6) {
                gcLast.set(Calendar.MONTH, 3);
            } else if (month >= 6 && month < 9) {
                gcLast.set(Calendar.MONTH, 6);
            } else if (month >= 9) {
                gcLast.set(Calendar.MONTH, 9);
            }
            gcLast.set(Calendar.DAY_OF_MONTH, 1);
        }
        if (type == 4) {
            gcLast.set(Calendar.DAY_OF_WEEK, 1);
        }
        return gcLast.getTime();

    }

}
