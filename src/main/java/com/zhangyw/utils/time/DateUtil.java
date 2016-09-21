package com.zhangyw.utils.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.zhangyw.utils.exception.TimeStringFormateException;

public class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
<<<<<<< HEAD
	
=======
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	/**
	 * get date from string
	 * @param dateStr
	 * @return Date
	 * @throws TimeStringFormateException
	 */
	public static Date getDate(String dateStr) throws TimeStringFormateException{
		return TimeUtil.fromString(dateStr).getTime();
	}
<<<<<<< HEAD
	
=======
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	/**
	 * get date from long<br/>the start time is Thu Jan 01 08:00:00 CST 1970
	 * @param datetime
	 * @return Date
	 */
	public static Date getDate(long datetime){
		return new Date(datetime);
	}
<<<<<<< HEAD
	
=======
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	/**
	 * get date from string and formate with pattern
	 * @param dateStr
	 * @param pattern
	 * @return Date
	 */
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
<<<<<<< HEAD
	
=======
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	/**
	 * get current timestamp
	 * @return
	 */
	public static long getCurrentTimeStamp(){
		return new Date().getTime()/1000;
	}
<<<<<<< HEAD
	
	public static String getCurrentTime(){
		return getCurrentTime("yyyy-MM-dd HH:mm:ss");
	}
	
=======
	public static String getCurrentTime(){
		return getCurrentTime("yyyy-MM-dd HH:mm:ss");
	}
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	public static String getCurrentTime(String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
<<<<<<< HEAD
	
	public static String getCurrentTime(DateFormat format){
		return format.format(new Date());
	}
	
=======
	public static String getCurrentTime(DateFormat format){
		return format.format(new Date());
	}
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	public static long getTimeStamp(int dayAmount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, dayAmount);
		return calendar.getTimeInMillis()/1000;
	}
	public static long getBeginOfDayTimeStamp(int dayAmount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.add(Calendar.DATE, dayAmount);
		return calendar.getTimeInMillis()/1000;
	}
<<<<<<< HEAD

	
=======
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	public static boolean isYesterDay(Date date){
		if(date!=null){
			return date.getDate()+1 == new Date().getDate();
		}
		return false;
	}
<<<<<<< HEAD
	
	public static boolean isYesterDay(String dateStr) throws TimeStringFormateException{
		return isYesterDay(getDate(dateStr));
	}
	
	public static boolean isYesterDay(String dateStr,String pattern){
		return isYesterDay(getDate(dateStr,pattern));
	}
	
=======
	public static boolean isYesterDay(String dateStr) throws TimeStringFormateException{
		return isYesterDay(getDate(dateStr));
	}
	public static boolean isYesterDay(String dateStr,String pattern){
		return isYesterDay(getDate(dateStr,pattern));
	}
>>>>>>> 8cde905e9021f3aab37910949a6e6cd1832027b8
	public static boolean isYesterDay(long timestatmp){
		return isYesterDay(getDate(timestatmp));
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.getDate(0l));
	}
}
