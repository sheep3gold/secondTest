package com.itcast.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadReadAndWriteDemo {
    public static void main(String[] args) {
        ThreadReadAndWrite t1 = new ThreadReadAndWrite("/Users/yangxin/Downloads/运维基础班/20180321_运维基础/视频/03.四大部门.wmv", "四大部门.wmv");
        ThreadReadAndWrite t2 = new ThreadReadAndWrite("/Users/yangxin/Downloads/运维基础班/20180321_运维基础/视频/05.服务器的特点.wmv", "服务器的特点.wmv");

        /*new Thread(t1).start();
        new Thread(t2).start();*/
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.shutdown();
    }
}
