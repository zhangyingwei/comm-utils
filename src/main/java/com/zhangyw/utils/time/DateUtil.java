package com.zhangyw.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.zhangyw.utils.exception.TimeStringFormateException;

public class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
	
	public static Date getDate(String dateStr) throws TimeStringFormateException{
		return TimeUtil.fromString(dateStr).getTime();
	}
	
	public static Date getDate(long datetime){
		return new Date(datetime);
	}
	
	public static Date getDate(String dateStr,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date result = null;
		try {
			result = format.parse(dateStr);
		} catch (ParseException e) {
			logger.error(e);
		}
		return result;
	}
	
	public static long getCurrentTimeStamp(){
		return new Date().getTime()/1000;
	}
	
	public static String getCurrentTime(){
		return getCurrentTime("yyyy-MM-dd HH:mm:ss");
	}
	
	public static String getCurrentTime(String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
	
	public static long getTimeStamp(int dayAmount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, dayAmount);
		return calendar.getTimeInMillis()/1000;
	}
	
	public static boolean isYesterDay(Date date){
		if(date!=null){
			return date.getDate()+1 == new Date().getDate();
		}
		return false;
	}
	
	public static boolean isYesterDay(String dateStr) throws TimeStringFormateException{
		return isYesterDay(getDate(dateStr));
	}
	
	public static boolean isYesterDay(String dateStr,String pattern){
		return isYesterDay(getDate(dateStr,pattern));
	}
	
	public static boolean isYesterDay(long timestatmp){
		return isYesterDay(getDate(timestatmp));
	}
	
}
