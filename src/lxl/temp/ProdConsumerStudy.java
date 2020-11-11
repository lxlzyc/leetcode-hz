package lxl.temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode-hz
 * @description: 一个初始值为0的变量，两个线程对其交替操作 一个加1 一个减1 。
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒机制
 * @author: lxl
 * @create: 2020-09-23 22:12
 **/
public class ProdConsumerStudy {

    class ShareData {
        private int number = 0;
        private Lock lock = new ReentrantLock();

        private Condition condition = lock.newCondition();


        public void increment() throws Exception {
            lock.lock();
            try {
                //1 判断
                while (number != 0) {
                    // 等待 不能生产
                    condition.await();
                }
                //工作
                number++;
                condition.signalAll();
            } catch (Exception e) {
                lock.unlock();
            }
        }

        public void decrement() throws Exception {
            lock.lock();
            try {
                //1 判断
                while (number == 0) {
                    // 等待 不能生产
                    condition.await();
                }
                //工作
                number--;
                condition.signalAll();
            } catch (Exception e) {
                lock.unlock();
            }
        }

    }
}
