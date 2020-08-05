package com.example.demo;

/**
 * @author liuhe
 * @date 2020/08/05
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        waitAndNotify();
    }

    /**
     * wait会让出CPU而notify不会，notify重在于通知使用object的对象“我用完了！”，wait重在通知其它同用一个object的线程“我暂时不用了”并且让出CPU。
     */
    private static void waitAndNotify() {
        Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("t1 start~~");

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println("thread--1---运行，i = " + i);
                    }
                    System.out.println("t1 finished~~");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("t2 start~~");
                    obj.notify();

                    for (int i = 0; i < 10; i++) {
                        System.out.println("thread--2---运行，i = " + i);
                    }
                    System.out.println("t2 end~~");
                }
            }
        });
        t1.start();
//        t1.join();
        t2.start();
    }
}
