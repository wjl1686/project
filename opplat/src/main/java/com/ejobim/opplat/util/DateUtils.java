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

    // ?????????????????????????????????????????????
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

    // ???????????????- ???????????????
    public static String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }


    // ???????????????- ??????  ?????????
    public static String getPreviousSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // ???????????????--????????????
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

    // ???????????????--????????????
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
     * ???????????????????????????????????????
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
     * ???????????????????????????????????????(??????????????????)
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
            //???????????????????????????
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
     * ????????????????????????????????????
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
        if (year1 != year2)   //?????????
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //??????
                {
                    timeDistance += 366;
                } else    //????????????
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else    //?????????
        {
            System.out.println("??????day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * ???????????????????????????
     *
     * @return
     */
    public static String getMonthFirstDay() {
        //????????????????????????
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        //??????????????????
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = sf.format(gcLast.getTime());
        //?????????????????????
        System.out.println(day_first);
        return day_first;
    }

    public static Date getMonthFirstDay(int year, int month) {

        //year="2018" month="2"
        Calendar calendar = Calendar.getInstance();
        // ????????????,????????????????????????
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
     * ???????????????,??????????????????
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthLastDay(int year, int month) {

        //year="2018" month="2"
        Calendar calendar = Calendar.getInstance();
        // ????????????,????????????????????????
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
     * ??????????????????????????????
     *
     * @return
     */
    public static String getMonthLastDay() {
        //????????????????????????
        //??????Calendar
        Calendar calendar = Calendar.getInstance();
        //?????????????????????????????????
        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
        //??????????????????
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
     * ???????????????????????????
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
        Long time = System.currentTimeMillis();  //????????????????????????
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
     * ??????????????????????????????????????????????????????
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
     * ?????????????????????
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
     * ??????????????????????????????????????????????????????
     *
     * @param dataBegin ????????????
     * @param dataEnd   ????????????
     * @param weekDays  ???????????????1???6????????????????????????0????????????
     * @return ????????????List
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
     * ?????????????????????????????????
     *
     * @param datetime ??????
     * @return ??????
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????"};
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
     * ?????????????????????????????????
     *
     * @param
     * @return
     */
    public static String getMonWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// ???????????????????????????????????????????????????????????????????????????????????????
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// ?????????????????????????????????????????????
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("??????????????????:" + sdf.format(cal.getTime())); // ?????????????????????
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// ???????????????????????????????????????????????????????????????????????????????????????
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        return weekBegin;
    }

    /**
     * ??????????????????????????????
     *
     * @param
     * @return
     */
    public static String getSunWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// ???????????????????????????????????????????????????????????????????????????????????????
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// ?????????????????????????????????????????????
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("??????????????????:" + sdf.format(cal.getTime())); // ?????????????????????
        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);
        System.out.println("??????????????????????????????" + weekEnd);
        return weekEnd;
    }

    /**
     * ????????????????????????????????????
     */
    public static String getSunDayOfWeek() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        // ???????????????????????????
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return sf.format(c.getTime());
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        c.add(Calendar.DATE, 7 - c.get(Calendar.DAY_OF_WEEK) + 1);
        String sunDay = sf.format(c.getTime());
        return sunDay;
    }

    /**
     * ????????????????????????????????????????????????
     *
     * @param
     * @return
     **/
    public static Map<String, String> getWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// ???????????????????????????????????????????????????????????????????????????????????????
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// ?????????????????????????????????????????????
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        System.out.println("??????????????????:" + sdf.format(cal.getTime())); // ?????????????????????

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// ???????????????????????????????????????????????????????????????????????????????????????
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        System.out.println("??????????????????????????????" + weekBegin);


        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);
        System.out.println("??????????????????????????????" + weekEnd);

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }

    /**
     * ????????????????????????????????????
     *
     * @param time
     * @return
     */
    public static String getTimeString(long time) {

        StringBuffer timeString = new StringBuffer();
        long year = time / DAY_COUNT_OF_YEAR / DAY_TIME;
        if (year > 0) {
            timeString.append(year);
            timeString.append("???");
        }
        long current = time - (DAY_COUNT_OF_YEAR * DAY_TIME * year);
        long day = current / DAY_TIME;

        timeString.append(day);
        timeString.append("???");
        current = current % DAY_TIME;
        long hour = current / HOUR_TIME;
        if (hour > 0) {
            timeString.append(hour);
            timeString.append("??????");
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
     * ??????????????????(??????????????????)??? 23:00-08:00  23:00-24:00  00:00-08:00
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
     * ??????????????????????????????
     */
    public static long dateDiff(String startTime, String endTime) throws Exception {
        //?????????????????????????????????simpledateformate??????
        //SimpleDateFormat sd = new SimpleDateFormat(dateFormatFull);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;//??????????????????
        long nh = 1000 * 60 * 60;//?????????????????????
        long nm = 1000 * 60;//?????????????????????
        long ns = 1000;//?????????????????????
        long diff;
        //???????????????????????????????????????
        diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
        long day = diff / nd;//??????????????????
        long hour = diff / nh;//?????????????????????
        long min = diff / nm;//?????????????????????
        long sec = diff / ns;//??????????????????//????????????
        // System.out.println("???????????????"+day+"???"+hour+"??????"+min+"??????"+sec+"??????");
        return hour;
    }

    /**
     * ???????????????????????????????????????????????????????????????)
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
                //???????????? ?????????????????????

                if (newCalendar.get(Calendar.DAY_OF_WEEK) > 5 || newCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                    //??????????????????
                    newCalendar.add(Calendar.DAY_OF_MONTH, -1);
                    weekNumbers = sdf.format(newCalendar.getTime()) + "0" + getMonthWeekCount(newCalendar.getTime());
                } else {
                    weekNumbers = sdf.format(date) + "01";
                }
            } else if (weekIndex == weekCount) {
                //?????????????????????
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
                        //???????????????????????????????????????
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
                    //???????????????????????????????????????
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
     * ???????????????????????????
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
     * ??????????????????????????????(??????????????????)
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
     * ???????????????????????????????????????????????????????????????)
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
     * ??????????????????????????????
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {//?????????new Date().toLocalString()????????????
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
     * ????????????????????? ????????? ??????????????? ?????????????????? ?????????????????????
     *
     * @param date
     * @param type
     * @return
     */
    public static Date getFirstDay(Date date, int type) {
        //????????????????????????
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(date);
        //??????????????????
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
