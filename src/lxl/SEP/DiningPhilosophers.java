package lxl.SEP;

import java.util.concurrent.Semaphore;

/**
 * @program: leetcode-hz
 * @description: 1226. 哲学家进餐
 * 5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子）
 * <p>
 * 所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。
 * 每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。
 * <p>
 * 假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。
 * <p>
 * 设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。
 * <p>
 * 问题描述和图片来自维基百科 wikipedia.org
 * <p>
 * <p>
 * <p>
 * 哲学家从 0 到 4 按 顺时针 编号。请实现函数 void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)：
 * <p>
 * philosopher 哲学家的编号。
 * pickLeftFork 和 pickRightFork 表示拿起左边或右边的叉子。
 * eat 表示吃面。
 * putLeftFork 和 putRightFork 表示放下左边或右边的叉子。
 * 由于哲学家不是在吃面就是在想着啥时候吃面，所以思考这个方法没有对应的回调。
 * <p>
 * 给你 5 个线程，每个都代表一个哲学家，请你使用类的同一个对象来模拟这个过程。在最后一次调用结束之前，可能会为同一个哲学家多次调用该函数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 1
 * 输出：[[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],[3,1,1],
 * [0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]
 * 解释:
 * n 表示每个哲学家需要进餐的次数。
 * 输出数组描述了叉子的控制和进餐的调用，它的格式如下：
 * output[i] = [a, b, c] (3个整数)
 * - a 哲学家编号。
 * - b 指定叉子：{1 : 左边, 2 : 右边}.
 * - c 指定行为：{1 : 拿起, 2 : 放下, 3 : 吃面}。
 * 如 [4,2,1] 表示 4 号哲学家拿起了右边的叉子。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 60
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-dining-philosophers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-08 13:42
 **/
public class DiningPhilosophers {

    //一个互斥信号量用于临界资源的互斥访问
    private Semaphore mutex;
    //5个同步信号量用于哲学家之间的同步访问
    private Semaphore[] sema;

    public DiningPhilosophers() {
        mutex = new Semaphore(1);
        sema = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)
        };
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //一个哲学家如果要拿起叉子就同时拿两个，因此这里是一个原子操作，需要用mutex信号量包起来，表示互斥
        mutex.acquire();
        //尝试获取左手边的叉子
        sema[philosopher].acquire();
        //尝试获取右手边的叉子
        sema[(philosopher + 1) % 5].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        //拿到叉子开始吃饭
        eat.run();

        //吃完饭放下叉子
        putLeftFork.run();
        sema[philosopher].release();
        putRightFork.run();
        sema[(philosopher + 1) % 5].release();
        mutex.release();
    }

    public static void main(String[] args) throws InterruptedException {
        DiningPhilosophers theDiningPhilosophers = new DiningPhilosophers();
        Runnable pickLeftFork = new Runnable() {
            @Override
            public void run() {
                System.out.print("-拿起左手叉子");
            }
        };
        Runnable pickRightFork = new Runnable() {
            @Override
            public void run() {
                System.out.print("-拿起右手叉子");
            }
        };
        Runnable eat = new Runnable() {
            @Override
            public void run() {
                System.out.print("-吃饭");
            }
        };
        Runnable putLeftFork = new Runnable() {
            @Override
            public void run() {
                System.out.print("-放下左边叉子");
            }
        };
        Runnable putRightFork = new Runnable() {
            @Override
            public void run() {
                System.out.print("-放下右边叉子");
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 300; i++) {
                        theDiningPhilosophers.wantsToEat(0, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                        Thread.sleep(10);
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
                    for (int i = 0; i < 300; i++) {
                        theDiningPhilosophers.wantsToEat(1, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 300; i++) {
                        theDiningPhilosophers.wantsToEat(2, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 300; i++) {
                        theDiningPhilosophers.wantsToEat(3, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable5 = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 300; i++) {
                        theDiningPhilosophers.wantsToEat(4, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);
        Thread thread5 = new Thread(runnable5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println("time = " + (System.currentTimeMillis() - start));

    }
}
