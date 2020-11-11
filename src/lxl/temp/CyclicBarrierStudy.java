package lxl.temp;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 14:05
 **/
public class CyclicBarrierStudy {

    public static void main(String[] args) {
        //循环栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("end");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "===");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
