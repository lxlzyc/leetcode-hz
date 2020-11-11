package lxl.temp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 21:52
 **/
public class SynchronousQueueStudy {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println("put---1");
                blockingQueue.put("1");
                System.out.println("put---2");
                blockingQueue.put("2");
                System.out.println("put---3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("get---" + blockingQueue.take());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
