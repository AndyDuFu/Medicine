package com.medicine.util;

import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatetimeUtil {
    private static final Logger logger = LoggerFactory.getLogger(DatetimeUtil.class);

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_HOUR_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_MONTH_FORMAT = "yyyy-MM";

    public static Date parseDatetime(String datetime) {
        return parseDatetime(datetime, DATE_TIME_FORMAT);
    }

    public static Date parseDate(String date) {
        return parseDatetime(date, DATE_FORMAT);
    }

    public static Date parseDatetime(String date, String dateFormat) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
            return dateFormatter.parse(MyUtil.urlDecode(date));
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDatetimeWithException(String datetime) {
        return parseDateTimeWithException(datetime, DATE_TIME_FORMAT);
    }

    public static Date parseMonthWithException(String datetime) {
        return parseDateTimeWithException(datetime, DATE_MONTH_FORMAT);
    }

    public static Date parseDateWithException(String date) {
        return parseDateTimeWithException(date, DATE_FORMAT);
    }

    public static Date parseDateHourWithException(String datetime) {
        return parseDateTimeWithException(datetime, DATE_HOUR_FORMAT);
    }

    public static Date parseDateTimeWithException(String datetime, String dateFormat) {
        try {
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(dateFormat);
            return dateTimeFormatter.parse(MyUtil.urlDecode(datetime));
        } catch (ParseException e) {
            logger.error("Value: " + datetime + " date format error. The formate should be " + dateFormat);
            throw new BusinessException(ErrorCode.DATE_FORMAT_ERROR);
        }
    }

    public static String formatDatetime(Date date) {
        return formatDatetime(date, DATE_TIME_FORMAT);
    }

    public static String formatDate(Date date) {
        if(date==null){
            return null;
        }
        return formatDatetime(date, DATE_FORMAT);
    }

    public static String formatDateHour(Date date) {
        return formatDatetime(date, DATE_HOUR_FORMAT);
    }

    public static String formatDatetime(Date date, String dateFormate) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormate);
        return dateFormatter.format(date);
    }

    public static Date getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    public static Date getStartDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date getEndDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static int calculateAge(Date birthDay) {
        return daysBetween(new Date(), birthDay) / 365;
    }

    public static int daysBetween(Date d1, Date d2) {
        return (int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static boolean isCurrentMonth(Date date) {
        if (date == null) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        Calendar current = Calendar.getInstance();
        return cal.get(Calendar.YEAR) == current.get(Calendar.YEAR)
                && cal.get(Calendar.MONTH) == current.get(Calendar.MONTH);

    }

    public static boolean isBeforeOrSameDay(Date checkDate, Date day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(format.format(checkDate)) <= Integer.parseInt(format.format(day));
    }

    public static boolean isCurrentDay(Date date) {
        if (date == null) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        Calendar current = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH) == current.get(Calendar.DAY_OF_MONTH)
                && cal.get(Calendar.MONTH) == current.get(Calendar.MONTH)
                && cal.get(Calendar.YEAR) == current.get(Calendar.YEAR);

    }

    public static Date getTomorrowDatetime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static boolean isCurrentWeek(Date date) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(date);
        int paramYear = calendar.get(Calendar.YEAR);
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return paramYear == currentYear && paramWeek == currentWeek;
    }

    public static Date getCurrentWeekBegin() {
        Calendar c = Calendar.getInstance();
        int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0) {
            dayofweek = 7;
        }
        c.add(Calendar.DATE, -dayofweek + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取月第一天
     *
     * @param date
     * @return
     */
    public static Date monthFirstDate(Date date) {
        return convertLocalDateToDate(convertDateToLocalDate(date).withDayOfMonth(1));
    }

    /**
     * 获取月最后一天
     *
     * @param date
     * @return
     */
    public static Date monthLastDate(Date date) {
        return convertLocalDateTimeToDate(convertDateToLocalDateTime(date)
                .with(TemporalAdjusters.lastDayOfMonth())
                .withHour(23)
                .withMinute(59)
                .withSecond(59));
    }

    /**
     * 获取此日期所在日程的第一个星期天
     *
     * @param date
     * @return
     */
    public static Date getCalendarFirstSunday(Date date) {
        //转换为LocalDate
        LocalDate theLocalDate = convertDateToLocalDate(date);
        //本月第一个星期天
        LocalDate theMonthFirstSunday = theLocalDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        //如果本月第一天就是星期天的话直接返回，否则返回本月第一天所在周的上一个星期天
        if (theMonthFirstSunday.isEqual(theLocalDate.with(TemporalAdjusters.firstDayOfMonth())))
            return convertLocalDateToDate(theMonthFirstSunday);
        else
            return convertLocalDateToDate(theMonthFirstSunday.minusWeeks(1));
    }

    /**
     * 基于此日期加指定天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date plusDays(Date date, long days) {
        return convertLocalDateToDate(convertDateToLocalDate(date).plusDays(days));
    }

    /**
     * 基于此日期加指定月数
     *
     * @param date
     * @param months
     * @return
     */
    public static Date plusMonths(Date date, long months) {
        return convertLocalDateToDate(convertDateToLocalDate(date).plusMonths(months));
    }

    /**
     * 基于此日期减指定月数
     *
     * @param date
     * @param months
     * @return
     */
    public static Date minusMonths(Date date, long months) {
        return convertLocalDateToDate(convertDateToLocalDate(date).minusMonths(months));
    }

    /**
     * 基于此日期加指定年数
     *
     * @param date
     * @param years
     * @return
     */
    public static Date plusYears(Date date, long years) {
        return convertLocalDateToDate(convertDateToLocalDate(date).plusYears(years));
    }

    /**
     * 返回此日期的最后一秒日期
     *
     * @param date
     * @return
     */
    public static Date lastTimeOfDate(Date date) {
        return convertLocalDateTimeToDate(convertDateToLocalDate(date).atStartOfDay().plusDays(1).minusSeconds(1));
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(ZonedDateTime.of(localDate.atStartOfDay(), ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 求两个时间相差几天
     *
     * @param a 被减数
     * @param b 减数
     * @return
     */
    public static int daySpan(Date a, Date b) {
        return (int) ((a.getTime() - b.getTime()) / 1000 / 3600 / 24);
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        System.out.println(format.format(new Date()));
    }

    public static int dayForWeek(Date pTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

//根据时间获取本周的第一天
    public static Date getFirstDayOfWeek(Date a) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if(1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String dateStr = sdf.format(cal.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return  cal.getTime();
    }

    //根据时间获取本周的周末
    public static Date getEndDayOfWeek(Date a) {
        Calendar cal = Calendar.getInstance();
        getFirstDayOfWeek(a);
        cal.add(Calendar.DATE, 6);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    //根据时间获取今天开始
    public static Date getToDayOfStar(Date a) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return  cal.getTime();
    }
    //根据时间获取今天结束
    public static Date getToDayOfEnd(Date a) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return  cal.getTime();
    }

    //由出生日期获得年龄
    public static Integer getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new BusinessException(ErrorCode.ABNORMAL_TIME);
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    /**
     * 根据身份证获取性别
     * @param idCard
     * @return
     */
    public static String getGender(String idCard)  {
        // 获取性别
        String gender;
        String id17 = idCard.substring(16, 17);
        if (Integer.parseInt(id17) % 2 != 0) {
            gender = "男";
        } else {
            gender = "女";
        }
        return gender;
    }

    /**
     * 根据身份证获取生日
     * @param idCard
     * @return
     */
    public static Date getBirthday(String idCard)  {
            try {
                String birthday = idCard.substring(6, 14);
                Date birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
                GregorianCalendar currentDay = new GregorianCalendar();
                currentDay.setTime(birthdate);
                int year = currentDay.get(Calendar.YEAR);
                int month = currentDay.get(Calendar.MONTH) + 1;
                int day = currentDay.get(Calendar.DAY_OF_MONTH);
                Date bir = parseDate(year + "-" + month + "-" + day);
                return bir;
            }
            catch (Exception e){
                return null;
            }
    }

    /**
     * 根据身份证获取年龄
     * @param idCard
     * @return
     */
    public static int getNewAge(String idCard)  {

        try {
            String birthday = idCard.substring(6, 14);
            Date birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
            GregorianCalendar currentDay = new GregorianCalendar();
            currentDay.setTime(birthdate);
            int old = currentDay.get(Calendar.YEAR);

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
            String year=simpleDateFormat.format(new Date());
            int age=Integer.parseInt(year)-old;
            return age;
        } catch (Exception e){
            return 0;
        }

    }

    /**
     * 指定日期加上天数后的日期
     * @param num 为增加的天数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static Date plusYear(int num,String newDate){
      //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // Date  currdate = format.parse(newDate);
        Date  currdate = parseDate(newDate);
        System.out.println("现在的日期是：" + currdate);
         Calendar ca = Calendar.getInstance();
        ca.add(Calendar.YEAR, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        //String enddate = format.format(currdate);
        String enddate = formatDate(currdate);
        System.out.println("增加天数以后的日期：" + enddate);
        return currdate;
    }
    
    /**
     * @param date 指定的日期
     * @return 指定日期的后一天
     */
    public static String getNextDay(String date) {
    	Date nextDay = DatetimeUtil.plusDays(parseDate(date), 1);
    	return formatDate(nextDay);
    }
}
