package juc.cas;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Juc_Cas {
    private volatile int state  = 0;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private static Juc_Cas cas = new Juc_Cas();

    public static void main(String[] args) {

    }

    static class worker implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "准备开始抢state");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
