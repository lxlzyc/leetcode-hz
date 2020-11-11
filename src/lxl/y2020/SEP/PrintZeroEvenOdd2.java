package lxl.y2020.SEP;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @program: leetcode-hz
 * @description: 1116. 打印零与奇偶数
 * 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * <p>
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * <p>
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-09 10:51
 **/
public class PrintZeroEvenOdd2 {

    private int n;

    private volatile int status;

    private int nOffset;

    private Lock lock;

    public PrintZeroEvenOdd2(int n) {
        this.n = n;
        this.status = 0;
        this.nOffset = 0;
        lock = new ReentrantLock();
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (; ; ) {
            if (status == 0 && lock.tryLock()) {
                if (nOffset < n) {
                    printNumber.accept(0);
                    nOffset++;
                    status = nOffset % 2 == 0 ? 1 : 2;
                } else {
                    status = -1;
                    lock.unlock();
                    break;
                }
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (status >= 0) {
            if (status == 1 && lock.tryLock()) {
                printNumber.accept(nOffset);
                status = 0;
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (status >= 0) {
            if (status == 2 && lock.tryLock()) {
                printNumber.accept(nOffset);
                status = 0;
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd2 printZeroEvenOdd = new PrintZeroEvenOdd2(100);
        Runnable zeroRunable = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                };
                try {
                    printZeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable evenRunable = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                };
                try {
                    printZeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable oddRunable = new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                };
                try {
                    printZeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(zeroRunable).start();
        new Thread(evenRunable).start();
        new Thread(oddRunable).start();
    }
}
