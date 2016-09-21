package com.zhangyw.utils.common;

import java.util.Objects;

/**
 * Created by zhangyw on 2016/9/14.
 */
public class CommonUtil {
    public static boolean equalsOr(Object base,Object... compars){
        for(Object obj:compars){
            if(base.equals(obj)){
                return true;
            }
        }
        return false;
    }
    public static boolean equalsAnd(Object base,Object... compars){
        for(Object obj:compars){
            if(!base.equals(obj)){
                return false;
            }
        }
        return true;
    }
}
