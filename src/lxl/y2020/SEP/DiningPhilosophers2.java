package lxl.y2020.SEP;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

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
public class DiningPhilosophers2 {

    //这道题本质上其实是想考察如何避免死锁。
    //易知：当 5 个哲学家都拿着其左边(或右边)的叉子时，会进入死锁。
    //
    //PS：死锁的 4 个必要条件：
    //
    //互斥条件：一个资源每次只能被一个进程使用，即在一段时间内某 资源仅为一个进程所占有。此时若有其他进程请求该资源，则请求进程只能等待。
    //请求与保持条件：进程已经保持了至少一个资源，但又提出了新的资源请求，而该资源 已被其他进程占有，此时请求进程被阻塞，但对自己已获得的资源保持不放。
    //不可剥夺条件:进程所获得的资源在未使用完毕之前，不能被其他进程强行夺走，即只能 由获得该资源的进程自己来释放（只能是主动释放)。
    //循环等待条件: 若干进程间形成首尾相接循环等待资源的关系。
    //
    //故最多只允许 4 个哲学家去持有叉子，可保证至少有 1 个哲学家能吃上意大利面（即获得到 2 个叉子）。
    //因为最差情况下是：4 个哲学家都各自持有1个叉子，此时还 剩余 1 个叉子 可供使用，这 4 个哲学家中必然有1人能获取到这个 剩余的 1 个叉子，从而手持 2 个叉子，可以吃意大利面。
    //即：4 个人中，1 个人有 2 个叉子，3 个人各持 1 个叉子，共计 5 个叉子。
    //
    //既然最多只允许4个哲学家去持有叉子，那么如果只允许3个哲学家去持有叉子是否可行呢？
    //
    //当然可行，3个哲学家可以先都各自持有1把叉子，此时还剩余2把叉子；
    //
    //当这3个哲学家刚好都相邻(比如：编号为图中的0, 1, 2)，可能会造成只有1个哲学家能吃到意面的情况，具体而言即0号哲学家拿到了其左侧的叉子(编号为1)，1号哲学家也拿到了其左侧的叉子(编号为2)，2号哲学家也拿到了其左侧的叉子(编号为3)，此时只有0号哲学家能拿到其右侧的叉子(编号为0)，因此只有0号哲学家能吃到意面。
    //而其余情况下，3个哲学家中都能有2人吃到意面。
    //即：3 个人中，2 个人各自持有 2 个叉子，1 个人持有 1 个叉子，共计 5 个叉子。
    //
    //并且仔细想想，叉子的数目是固定的(个数为5)，直觉上来讲3个人去抢5个叉子 比 4个人去抢5个叉子效率高。
    //
    //用Semaphore去实现上述的限制：Semaphore eatLimit = new Semaphore(4);
    //一共有5个叉子，视为5个ReentrantLock，并将它们全放入1个数组中。
    //
    //给叉子编号 0,1,2,3,4 （对应数组下标）
    //
    //作者：gfu
    //链接：https://leetcode-cn.com/problems/the-dining-philosophers/solution/1ge-semaphore-1ge-reentrantlockshu-zu-by-gfu/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    private final ReentrantLock[] lockList = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};

    //限制 最多只有4个哲学家去持有叉子
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers2() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = (philosopher + 1) % 5;    //左边的叉子 的编号
        int rightFork = philosopher;    //右边的叉子 的编号

        eatLimit.acquire();    //限制的人数 -1

        lockList[leftFork].lock();    //拿起左边的叉子
        lockList[rightFork].lock();    //拿起右边的叉子

        pickLeftFork.run();    //拿起左边的叉子 的具体执行
        pickRightFork.run();    //拿起右边的叉子 的具体执行

        eat.run();    //吃意大利面 的具体执行

        putLeftFork.run();    //放下左边的叉子 的具体执行
        putRightFork.run();    //放下右边的叉子 的具体执行

        lockList[leftFork].unlock();    //放下左边的叉子
        lockList[rightFork].unlock();    //放下右边的叉子
        eatLimit.release();//限制的人数 +1
    }

    public static void main(String[] args) throws InterruptedException {
        DiningPhilosophers2 theDiningPhilosophers = new DiningPhilosophers2();
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
