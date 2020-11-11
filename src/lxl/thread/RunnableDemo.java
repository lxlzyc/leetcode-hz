package lxl.thread;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 14:48
 **/
public class RunnableDemo implements Runnable {


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
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread index = Thread.currentThread();
        System.out.println("主线程" + index.getName());

        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo, "第一个").start();
        new Thread(runnableDemo, "第二个").start();
        Thread th2 = new Thread(runnableDemo);
        th2.start();
    }
}
