package lxl.temp;

import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 09:51
 **/
public class CountDownLantchStudy {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "---deal");
                countDownLatch.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("end--------");

    }

}
