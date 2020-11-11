package lxl.thread;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 14:45
 **/
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("子线程" + this.getName());
    }

    public static void main(String[] args) {
        Thread index = Thread.currentThread();
        System.out.println("主线程" + index.getName());
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

}
