package com.zhangyw.utils.json;

import com.zhangyw.utils.String.StringUtil;

import net.sf.json.JSONObject;

public class JSONUtil {
	public static boolean isJson(String str){
		if(StringUtil.isEmpty(str)){
			return false;
		}
		if((!str.startsWith("{"))&&(!str.endsWith("}"))){
			return false;
		}
		try {
			JSONObject.fromObject(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
