package lxl.temp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 23:26
 **/
public class ProdConsumerBlockQueueDemo {

    //默认开启 进行生产+消费
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public ProdConsumerBlockQueueDemo(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = "" + atomicInteger.incrementAndGet();
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列成功" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列失败" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "-线程停止 flag false生产结束");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费队列超时退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列成功" + result);
        }
        System.out.println(Thread.currentThread().getName() + "-线程停止 flag fals消费结束");
    }

    public void stop() {
        this.FLAG = false;
    }

    public static void main(String[] args) {

        ProdConsumerBlockQueueDemo prodConsumerBlockQueueDemo = new ProdConsumerBlockQueueDemo(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生成启动");
            try {
                prodConsumerBlockQueueDemo.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "prod").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费启动");
            try {
                prodConsumerBlockQueueDemo.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费停止");
            prodConsumerBlockQueueDemo.stop();
        }, "stop").start();

    }
}
