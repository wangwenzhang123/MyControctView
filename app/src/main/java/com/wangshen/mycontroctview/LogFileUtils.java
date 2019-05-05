package com.wangshen.mycontroctview;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name bizcentCheckoutApp
 * @class describe
 * @anthor 王文章
 * @time 2019/4/26 17:26
 * @change
 */
public class LogFileUtils {
    String filePath = Environment.getExternalStorageDirectory()
            + "/Zizhu/";
    String fileName = "log.txt";
    private static LogFileUtils logFileUtils = new LogFileUtils();

    private LogFileUtils() {

    }

    public static LogFileUtils getInstance() {
        return logFileUtils;
    }

    public void writeTxtToFile(String strcontent) throws Exception {
        //生成文件夹之后，再生成文件，不然会出错
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        fileName = simpleDateFormat.format(date) + "_log.txt";
        makeFilePath(filePath, fileName);
        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        File file = new File(strFilePath);
        if (!file.exists()) {
            Log.d("TestFile", "Create the file:" + strFilePath);
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rwd");
        raf.seek(file.length());
        raf.write(strContent.getBytes());
        raf.close();
    }

    // 生成文件
    public File makeFilePath(String filePath, String fileName) throws Exception {
        File file = null;
        makeRootDirectory(filePath);
        Log.i("error:===", "makeFilePath==" + filePath);
        file = new File(filePath + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    // 生成文件夹
    public static void makeRootDirectory(String filePath) throws Exception {
        File file = null;
        file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] files = file.listFiles();
        Log.i("error:===", "makeRootDirectory==" + files.length);
    }
}
