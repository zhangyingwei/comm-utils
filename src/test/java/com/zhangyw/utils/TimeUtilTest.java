package com.zhangyw.utils;

import java.util.Date;

import com.zhangyw.utils.exception.TimeStringFormateException;
import com.zhangyw.utils.time.TimeUtil;

public class TimeUtilTest {
	public static void main(String[] args) throws TimeStringFormateException {
		String time = "2015-08-09T09:23:29.000Z";
		System.out.println(TimeUtil.fromString(time).getTime());
		System.out.println(new Date().toString());
	}
}
