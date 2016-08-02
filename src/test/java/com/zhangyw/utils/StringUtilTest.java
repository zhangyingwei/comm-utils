package com.zhangyw.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.zhangyw.utils.String.StringUtil;

public class StringUtilTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s1 = "啊";
		String s2 = "我";
		String s3 = "我在杭州,你在哪里";
		System.out.println(StringUtil.getAllBeginCharacter(s3));
		System.out.println(new String("\u554A"));
		System.out.println(Arrays.toString(s1.getBytes()));
		System.out.println(Arrays.toString(s2.getBytes()));
	}
}
