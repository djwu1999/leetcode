package juc;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Juc_Main {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            lock.lock();    //外置锁，手动添加
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            int i = 0;
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i > 10){
                    break;
                }
                i ++;
            }
            lock.unlock();
        }, "t-A");
        A.start();

        Thread B = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            lock.unlock();
        }, "t-B");

        B.start();
    }
}
