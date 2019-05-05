package com.wangshen.mycontroctview.file;

/**
 * @name slZizhu
 * @class describe
 * @anthor 王文章
 * @time 2019/4/29 9:57
 * @change
 */
public interface RunCallback {
    void onSuccess(Runnable runnable);
    void onFailed(Runnable runnable);
}
