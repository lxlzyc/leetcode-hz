package lxl.JUN;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode-hz
 * @description: 1115. 交替打印FooBar
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * <p>
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-19 14:09
 **/
public class PrintFoobarAlternatelyLock {
    private int n;

    public PrintFoobarAlternatelyLock(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock(true);
    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
