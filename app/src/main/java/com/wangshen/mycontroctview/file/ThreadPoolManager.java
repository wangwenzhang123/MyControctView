package com.wangshen.mycontroctview.file;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @name slZizhu
 * @class describe
 * @anthor 王文章
 * @time 2019/4/29 9:44
 * @change
 */
public class ThreadPoolManager {
    private LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();
    private ExecutorService executorService;
    private static ThreadPoolManager threadPoolManager;
    private Thread thread;
    private ThreadPoolManager (){
        newFixedThreadPool();
        init();
    }
    public static ThreadPoolManager getInstance(){
        synchronized (ThreadPoolManager.class){
            if (threadPoolManager == null){
                synchronized (ThreadPoolManager.class){
                    threadPoolManager=new ThreadPoolManager();
                }
            }
        }
        return threadPoolManager;
    }
    private void  newFixedThreadPool() {
       executorService= new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, queue);
    }
    public void writer(String result){
        LogCallback logCallback=new LogCallback(result, new RunCallback() {
            @Override
            public void onSuccess(Runnable runnable) {
                queue.remove(runnable);
            }

            @Override
            public void onFailed(Runnable runnable) {
                queue.add(runnable);
            }
        });
        queue.add(logCallback);
    }
    private void init(){
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        queue.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    public void onDestroy(){
        if (thread != null){
            thread.stop();
        }
        if (queue != null){
            queue.clear();
        }
        if (executorService != null){
            executorService=null;
        }
    }
}
