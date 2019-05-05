package com.wangshen.mycontroctview.file;


import android.util.Log;

import com.wangshen.mycontroctview.LogFileUtils;

/**
 * @name slZizhu
 * @class describe
 * @anthor 王文章
 * @time 2019/4/29 9:41
 * @change
 */
public class LogCallback implements Runnable {
    private String result;
    private RunCallback callback;
    public LogCallback(String result, RunCallback callback) {
        this.result = result;
        this.callback=callback;
    }

    @Override
    public void run() {
        try {
            LogFileUtils.getInstance().writeTxtToFile(result);
            callback.onSuccess(this);
        } catch (Exception e) {
            e.printStackTrace();
            callback.onFailed(this);
        }
    }
}
