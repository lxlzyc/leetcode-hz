package lxl.y2020.JUN;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leetcode-hz
 * @description: 1114. 按序打印
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void one() { print("one"); }
 * public void two() { print("two"); }
 * public void three() { print("three"); }
 * }
 * <p>
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * <p>
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-19 10:56
 **/
public class PrintInOrder {

    private AtomicInteger first = new AtomicInteger(0);
    private AtomicInteger second = new AtomicInteger(0);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (first.get() != 0) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (second.get() != 0) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
