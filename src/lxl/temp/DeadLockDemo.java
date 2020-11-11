package lxl.temp;

/**
 * @program: leetcode-hz
 * @description: 死锁。
 * @author: lxl
 * @create: 2020-09-25 21:12
 **/
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();

        // linux ps -ef|gref xxxx .  ls -l 查看进程

        // windows下的java运行程序，
        //jps java ps; jps -l 查看java

        //jstack java stack；查看栈jstack;;   jstack 进程id
    }
}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 自己持有" + lockA + "锁尝试获取" + lockB + "锁");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 自己持有" + lockB + "锁");
            }
        }
    }
}
