package util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private static final Logger logger = Logger.getLogger(DateUtil.class);

    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String longToDate(Long time, String pattern) {
        if (time != null)
            return getDateParser(pattern).format(new Date(time));
        else
            return "";
    }

    public static String longToDate(Long time) {
        return getDateParser("yyyy-MM-dd").format(new Date(time));
    }

    public static String longToDate2(Long time) {
        return getDateParser("MM-dd HH:mm").format(new Date(time));
    }

    public static String longToDateAll(Long time) {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    public static String longToDateAllNew(Long time) {
        return getDateParser("yyyyMMddHHmmss").format(new Date(time));
    }

    public static String getCurrentDateString() {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentDateString(String format) {
        return getDateParser(format).format(new Date(System.currentTimeMillis()));
    }

    /**
     * String型日期转为long型
     *
     * @param source String型日期
     * @return long 日期
     * @throws ParseException
     */
    public static long dateToLong(String source) {
        try {
            return getDateParser("yyyy/MM/dd").parse(source).getTime();
        } catch (ParseException e) {
        	logger.error(e);
            try {
                return getDateParser("yyyy-MM-dd").parse(source).getTime();
            } catch (ParseException e1) {
            	logger.error(e1);
                return -1;
            }
        }
    }
    
    /**
     * String型日期转为long型
     *
     * @param source String型日期
     * @return long 日期
     * @throws ParseException
     */
    public static long dateTimeToLong(String source) {
    	long time = -1;
        	try {
				time = getDateParser("yyyy-MM-dd HH:mm:ss").parse(source).getTime();
			} catch (ParseException e) {
				logger.error(e);
			}
        	return time;
    }

    public static long dateAddOneDayAndToLong(String source) {
        try {
            Date date = getDateParser("yyyy/MM/dd").parse(source);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            cd.add(Calendar.DAY_OF_MONTH, 1);
            return cd.getTime().getTime();
        } catch (ParseException e) {
        	logger.error(e);
            try {
                Date date = getDateParser("yyyy-MM-dd").parse(source);
                Calendar cd = Calendar.getInstance();
                cd.setTime(date);
                cd.add(Calendar.DAY_OF_MONTH, 1);
                return cd.getTime().getTime();
            } catch (ParseException e1) {
            	logger.error(e1);
                return -1;
            }
        }
    }

    public static Date nextNDay(Date date, int n) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.DAY_OF_MONTH, n);
        return cd.getTime();
    }

    public static String nextNDay(int n) {
        Date date = new Date();
        return getDate(nextNDay(date, n), "yyyy-MM-dd");
    }

    public static long nextDate(String source) {
        try {
            return getDateParser("yyyy/MM/dd").parse(source).getTime() + 24 * 60 * 60 * 1000;
        } catch (ParseException e) {
        	logger.error(e);
            try {
                return getDateParser("yyyy-MM-dd").parse(source).getTime() + 24 * 60 * 60 * 1000;
            } catch (ParseException e1) {
            	logger.error(e1);
                return -1;
            }
        }

    }

    public static String longToFrontDate(Long time) {
        return getDateParser("yyyy-MM-dd").format(new Date(time - 24 * 60 * 60 * 1000));
    }


    /**
     * String型日期转为long型
     *
     * @param source String型日期
     * @return long 日期
     * @throws ParseException
     */
    public static long dateAllToLong(String source) {
        try {
            return getDateParser("yyyy/MM/dd HH:mm:ss").parse(source).getTime();
        } catch (ParseException e) {
        	logger.error(e);
            try {
                return getDateParser("yyyy-MM-dd HH:mm:ss").parse(source).getTime();
            } catch (ParseException e1) {
            	logger.error(e1);
                return -1;
            }
        }

    }

    /**
     * 生成流水号
     *
     * @return 类似"20090507095515693"的字符串(15位)
     */
    public static long genSerialNumber() {
        return Long.valueOf(getDateParser("yyyyMMddHHmmsss").format(new Date()));
    }

    public static long genYMD() {
        return Long.valueOf(getDateParser("yyyyMMdd").format(new Date()));
    }

    /**
     * 获得日期
     */
    public static Date getDate(String birthday) {
        return new Date(dateToLong(birthday));
    }

    /**
     * 获取日期字符
     *
     * @param date   日期
     * @param format 格式 如:yyy-MM-dd
     * @return
     */
    public static String getDate(Date date, String format) {
        return getDateParser(format).format(date);
    }

    public static Date toDate(String dataString, String format) throws ParseException {
        return getDateParser(format).parse(dataString);
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static long getNowDate() {
        return DateUtil.dateToLong(getDateParser("yyyy-MM-dd").format(new Date()));
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static long getNowDate(Date curDate) {
        return DateUtil.dateToLong(getDateParser("yyyy-MM-dd").format(curDate));
    }

    /**
     * 获取当前时间加上任意天数后的日期
     *
     * @param dayNum 天数
     * @return
     */
    public static String getNewDateByAdd(int dayNum) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
    }


    /**
     * 获取指定时间加上任意天数后的日期
     *
     * @param dayNum 天数
     * @param date   日期
     * @return
     */
    public static String getNewDateByAdd(Date date, int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
    }

    /**
     * 获取当前时间加上任意月数后的日期
     *
     * @param monthNum 月数
     * @return
     */
    public static String getNewDateByAddMonth(int monthNum) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
    }

    /**
     * 获取当前时间加上任意月数后的日期(带时间)
     *
     * @param monthNum 月数
     * @return
     */
    public static String getNewDateTimeByAddMonth(int monthNum) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
    }

    /**
     * 获取指定时间加上任意月数后的日期
     *
     * @param monthNum 月数
     * @param date     日期
     * @return
     */
    public static String getNewDateByAddMonth(Date date, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
    }

    /**
     * 获取指定时间加上任意月数后的日期
     *
     * @param monthNum 月数
     * @param date     日期
     * @return
     */
    public static String getNewDateTimeByAddMonth(Date date, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
    }

    public static String getNewDateTimeByAddMonth(String dateStr, int monthNum) {
        Date time = null;
        try {
            time = getDateParser("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        } catch (ParseException e) {
        	logger.error(e);
            try {
                time = getDateParser("yyyy-MM-dd").parse(dateStr);
            } catch (ParseException e1) {
            	logger.error(e1);
                time = new Date();
            }
        }
        return getNewDateTimeByAddMonth(time, monthNum);
    }

    public static String getNewDateByAdd(int dayNum, String format) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);
        return (new SimpleDateFormat(format)).format(cal.getTime());
    }

    public static Date getDateByAdd(Date date, int num, int timeType) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(timeType, num);
        return cal.getTime();
    }

    public static Date getEndOfToday() {
        final String dateStr = getNewDateByAdd(0);
        try {
            return getDateParser("yyyy-MM-dd HH:mm:ss").parse(dateStr + " 23:59:59");
        } catch (ParseException e) {
        	logger.error(e);
            return new Date();
        }
    }

    /**
     * 获取指定时间加上任意小时后的日期
     *
     * @param hour 小时数
     * @return
     */
    public static String getNewDateByAddHour(int hour) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
    }

    /**
     * @return 当前月份最大天数
     * @获取当前月份最大天数
     */
    public static int lastDayOfMonth() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return value;
    }

    /**
     * @return 当前年份及往前5年的年份集合
     * @获取当前年份及往前5年的年份集合
     */
    public static List<Object> getYearList() {
        List<Object> yearList = new ArrayList<Object>();
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        for (int i = 0; i < 5; i++) {
            Map<String, Object> yearMap = new HashMap<String, Object>();
            yearMap.put("id", currentYear);
            //yearMap.put("text", currentYear + "年");
            if (i == 0) {
                yearMap.put("selected", true);
            }
            yearList.add(yearMap);
            currentYear = currentYear - 1;
        }
        return yearList;
    }
    
    /**
     * @return 获取昨日日期
     * @获取当前月份最大天数
     */
    public static String getYesterday() {
    	Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String yesterday = sp.format(d);
        return yesterday;
    }
    
    /**
     * @return 获取当月第一天
     * @获取当前月份最大天数
     */
    public static String getFirstDayToMonth() {
    	Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String firstDay = sp.format(d);
        return firstDay;
    }

    /**
     * @return 获取当月第一天
     * @获取当前月份最大天数
     */
    public static String getFirstDayToPreMonth() {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        cal.set(Calendar.DAY_OF_MONTH,1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String firstDay = sp.format(d);
        return firstDay;
    }
    
    /**
     * @return 获取当月最后一天
     * @获取当前月份最大天数
     */
    public static String getLastDayToMonth() {
    	Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = sp.format(d);
        return lastDay;
    }
    /**
     * @return 获取前月最后一天
     * @获取当前月份最大天数
     */
    public static String getLastDayToPreMonth() {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = sp.format(d);
        return lastDay;
    }
    
    /**
     * @return 获取本周第一天
     * @获取当前月份最大天数
     */
    public static String getFirstDayToWeek() {
    	Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String firstDay = sp.format(d);
        return firstDay;
    }

    /**
     * @return 获取本周第一天
     * @获取当前月份最大天数
     */
    public static String getFirstDayToPreWeek() {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR,-1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String firstDay = sp.format(d);
        return firstDay;
    }
    
    /**
     * @return 获取本周最后一天
     * @获取当前月份最大天数
     */
    public static String getLastDayToWeek() {
    	Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); 
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = sp.format(d);
        return lastDay;
    }
    /**
     * @return 获取本周最后一天
     * @获取当前月份最大天数
     */
    public static String getLastDayToPreWeek() {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = sp.format(d);
        return lastDay;
    }

}
