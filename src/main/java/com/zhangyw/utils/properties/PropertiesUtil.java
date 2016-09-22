package com.zhangyw.utils.properties;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhangyw on 2016/9/22.
 */
public class PropertiesUtil {
    private static Properties properties = new Properties();
    private static Logger logger = Logger.getLogger(PropertiesUtil.class);
    public static void load(String path){
        if(properties.isEmpty()){
            File conf = new File(path);
            FileInputStream stream = null;
            try {
                stream = new FileInputStream(conf);
                properties.load(stream);
                logger.info("config load from:"+path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(stream!=null){
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static String get(String path,String key){
        load(path);
        return properties.getProperty(key);
    }

    public static Map<String,String> getByPrefix(String path, String prefix){
        load(path);
        Map<String,String> resultMap = new HashMap<String,String>();
        for(Object key:properties.keySet()){
            if(key.toString().startsWith(prefix)){
                resultMap.put(key.toString(),properties.getProperty(key.toString()));
            }
        }
        return resultMap;
    }
}
