package lxl.thread;

/**
 * @program: leetcode-hz
 * @description: 多线程并不是启动之后会维持一种状态，它也有自己的生命周期，
 * 而对线程的调度就是在线程生命周期内可以做得一些动作，如
 * 新建、就绪、运行、睡眠、等待、挂起、恢复、阻塞和死亡，
 * 在线程生命周期内修改线程的状态称作线程调度。
 * @author: lxl
 * @create: 2020-07-15 14:56
 **/
public class ThreadDispatchDemo extends Thread {

    private Thread th = null;

    public ThreadDispatchDemo() {
        th = new Thread(this);
        System.out.println("线程状态-新建");
        System.out.println("线程状态-就绪");
        th.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("线程状态 运行");
            Thread.sleep(5000);
            System.out.println("线程th状态是在睡眠5秒之后，重新运行");
        } catch (Exception e) {
            System.out.println("线程th状态是被终端：" + e.toString());
        }
    }

    public static void main(String[] args) {
        ThreadDispatchDemo threadDispatchDemo = new ThreadDispatchDemo();

    }

}
