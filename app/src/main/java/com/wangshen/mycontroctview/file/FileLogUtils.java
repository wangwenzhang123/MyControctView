package com.wangshen.mycontroctview.file;

/**
 * @name slZizhu
 * @class describe
 * @anthor 王文章
 * @time 2019/4/29 9:38
 * @change
 */
public class FileLogUtils {
    private static FileLogUtils fileUtils;
    private FileLogUtils(){

    }
    public static FileLogUtils getInstance(){
        synchronized (FileLogUtils.class){
            if (fileUtils == null){
                synchronized (FileLogUtils.class){
                    fileUtils=new FileLogUtils();
                }
            }
        }
        return fileUtils;
    }
    public void write(String result){
        ThreadPoolManager.getInstance().writer(result);
    }
    public void onDestroy(){
        ThreadPoolManager.getInstance().onDestroy();
    }
}
