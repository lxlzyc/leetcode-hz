package lxl.temp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-23 20:47
 **/
public class ReentrantReadWriteLockStudy {

    private volatile Map<String, Integer> map;
    private ReentrantReadWriteLock reentrantReadWriteLock;

    public ReentrantReadWriteLockStudy() {
        map = new HashMap<>();
        map.put("1", 1);
        reentrantReadWriteLock = new ReentrantReadWriteLock();
    }

    public void get(String key) throws InterruptedException {
        System.out.println("get----" + key);
        Thread.sleep(200);
        System.out.println("get----" + key + "--end");
    }

    public void write(String key) throws InterruptedException {
        System.out.println("write----" + key);
        Thread.sleep(200);
        System.out.println("write----" + key + "--end");
    }

    public void getWithLock(String key) throws InterruptedException {
        reentrantReadWriteLock.readLock().lock();
        System.out.println("get----" + key);
        Thread.sleep(200);
        System.out.println("get----" + key + "--end");
        reentrantReadWriteLock.readLock().unlock();
    }

    public void writeWithLock(String key) throws InterruptedException {
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("write----" + key);
        Thread.sleep(200);
        System.out.println("write----" + key + "--end");
        reentrantReadWriteLock.writeLock().unlock();

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockStudy reentrantReadWriteLockStudy = new ReentrantReadWriteLockStudy();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    reentrantReadWriteLockStudy.write(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "write-" + i + "-").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    reentrantReadWriteLockStudy.get(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "get-" + i + "-").start();
        }
        Thread.sleep(10000);
        System.out.println("-------------------------------");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    reentrantReadWriteLockStudy.writeWithLock(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "write-" + i + "-").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    reentrantReadWriteLockStudy.getWithLock(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "get-" + i + "-").start();
        }
        //reentrantReadWriteLock
    }

}
