package com.zhangyw.utils.time;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.zhangyw.utils.arrays.ArrayUtil;
import com.zhangyw.utils.exception.TimeStringFormateException;

public class TimeUtil {
	private static Logger logger = Logger.getLogger(TimeUtil.class);
	/**
	 * 2015-08-09T09:23:29.000Z
	 * @return
	 * @throws TimeStringFormateException 
	 */
	public static Calendar fromString(String timeStr) throws TimeStringFormateException{
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(new Date(timeStr));
		} catch (Exception e) {
			int[] times = time2int(timeStr);
			calendar.set(Calendar.YEAR, times[0]);
			calendar.set(Calendar.MONTH, times[1]);
			calendar.set(Calendar.DATE, times[2]);
			calendar.set(Calendar.HOUR_OF_DAY, times[3]);
			calendar.set(Calendar.MINUTE, times[4]);
			calendar.set(Calendar.SECOND, times[5]);
		}
		return calendar;
	}
	private static int[] time2int(String timeStr) throws TimeStringFormateException{
		int[] result = ArrayUtil.intArray(6);
		if(timeStr.contains("T")){
			String[] timeArr = timeStr.split("T");
			String[] dateArr = timeArr[0].split("-");
			String[] dateTimeArr = timeArr[1].substring(0, timeArr[1].indexOf(".")).split(":");
			result[0] = Integer.parseInt(dateArr[0]);
			result[1] = Integer.parseInt(dateArr[1]);
			result[2] = Integer.parseInt(dateArr[2]);
			result[3] = Integer.parseInt(dateTimeArr[0]);
			result[4] = Integer.parseInt(dateTimeArr[1]);
			result[5] = Integer.parseInt(dateTimeArr[2]);
		}else{
			throw new TimeStringFormateException();
		}
		return result;
	}
}
