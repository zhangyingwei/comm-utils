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
            while(line!=null){
                result.append(line);
                line = reader.readLine();
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
    public static String read(String path,String encoding){
        StringBuffer result = new StringBuffer();
        File file = new File(path);
        InputStream input = null;
        InputStreamReader in = null;
        BufferedReader reader = null;
        try {
            input = new FileInputStream(file);
            in = new InputStreamReader(input,encoding);
            reader = new BufferedReader(in);
            String line = reader.readLine();
            while(line!=null){
                result.append(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
    public static boolean isFile(String path){
        return new File(path).isFile();
    }
    public static boolean isFile(String path,String fileName){
        return isFile(path+"/"+fileName);
    }
    public static boolean isDirectory(String path){
        return new File(path).isDirectory();
    }
    public static boolean isDirectory(String path,String fileName){
        return isDirectory(path+"/"+fileName);
    }
    public static void main(String[] args) {
        System.out.println(FileUtil.read("./src/test/resources/test.txt","gbk"));
    }
}
