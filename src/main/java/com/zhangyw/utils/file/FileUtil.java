package com.zhangyw.utils.file;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashSet;
import java.util.Set;

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
    public static String readText(String path){
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
    public static String readText(String path,String encoding){
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
    public static Set<String> readArr(String path){
        File file = null;
        FileReader fileReader = null;
        BufferedReader reader = null;
        Set<String> endset = new HashSet<String>();
        try {
            file = new File(path);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while(line!=null){
                endset.add(line);
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
        return endset;
    }
    public static Set<String> readArr(String path,String encoding){
        Set<String> endset = new HashSet<String>();
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
                endset.add(line);
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
        return endset;
    }
    public static void write(String path,String content){
        if(!isExists(path)){
            try {
                createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	File file = new File(path);
        OutputStream outputStream = null;
        BufferedOutputStream out = null;
        try {
            outputStream = new FileOutputStream(file);
            out = new BufferedOutputStream(outputStream);
            out.write(content.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void createFile(String path) throws IOException{
    	File file = new File(path);
    	if(file.exists()){
    		throw new FileAlreadyExistsException("file is already exist");
    	}else{
    		mkDirs(file.getParent());
    		file.createNewFile();
    	}
    }
    public static void mkDirs(String path){
    	File file = new File(path);
    	file.mkdirs();
    }
    public static boolean isExists(String path){
        return new File(path).exists();
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
    public static InputStream open(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }
}
