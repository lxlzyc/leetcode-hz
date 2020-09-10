package lxl.SEP;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode-hz
 * @description: 1117. H2O 生成
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * <p>
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-10 15:27
 **/
public class BuildingH2O2 {

    private Lock reentrantLock;
    private Condition condition;
    private volatile int oCount;
    private volatile int hCount;

    public BuildingH2O2() {
        oCount = 0;
        hCount = 0;
        reentrantLock = new ReentrantLock(true);
        condition = reentrantLock.newCondition();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        reentrantLock.lock();
        while (oCount != 1) {
            condition.await();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (hCount == 1) {
            oCount = 0;
            hCount = 0;
        } else {
            hCount = 1;
        }
        condition.signal();
        reentrantLock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        reentrantLock.lock();
        while (oCount != 0) {
            condition.await();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oCount = 1;
        condition.signal();
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        Runnable releaseHydrogen = new Runnable() {
            @Override
            public void run() {
                System.out.print('H');
            }
        };
        Runnable releaseOxygen = new Runnable() {
            @Override
            public void run() {
                System.out.print('O');
            }
        };
        BuildingH2O2 buildingH2O = new BuildingH2O2();
        int n = 20;
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < n; i++) {
                        buildingH2O.hydrogen(releaseHydrogen);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < n; i++) {
                        buildingH2O.oxygen(releaseOxygen);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

}
