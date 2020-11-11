package lxl.temp;

import java.util.concurrent.Semaphore;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 14:25
 **/
public class SemaphoreStudy {

    public static void main(String[] args) {
        //信号量
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "--- running");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                semaphore.release();
            }).start();
        }
    }

}
