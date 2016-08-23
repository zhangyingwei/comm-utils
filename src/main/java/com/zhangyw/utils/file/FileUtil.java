package com.zhangyw.utils.file;

import java.io.*;
import java.util.Arrays;

/**
 * Created by zhangyw on 2016/8/23.
 */
public class FileUtil {
    public static String[] listFiles(String path){
        return new File(path).list();
    }
    public static String[] listDirs(String path){
        return new File(path).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir.getPath()+"/"+name).isDirectory();
            }
        });
    }
    public static String read(String path){
        File file = null;
        FileReader fileReader = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            file = new File(path);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            if(line!=null){
                line = reader.readLine();
                result.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {

    }
}