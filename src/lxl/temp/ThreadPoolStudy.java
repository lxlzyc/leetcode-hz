package lxl.temp;

import java.util.concurrent.*;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-24 22:26
 **/
public class ThreadPoolStudy {

    public static ExecutorService getMyExcutorService() {
        ThreadFactory namedThreadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        return executorService;
    }


    public static void main(String[] args) {
        //一池五个线程
        ExecutorService fixExecutor = Executors.newFixedThreadPool(6);
        //内部实现
        ExecutorService fixExecutor2 = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        //一池一个线程
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        //内部实现
        ExecutorService singleExecutor2 = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        //可扩容的线程池
        ExecutorService cacheExecutor = Executors.newCachedThreadPool();

        ExecutorService cacheExecutor2 = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        //可扩容的线程池
        //ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1,1);

        try {
            for (int i = 0; i < 10; i++) {
                //启动是个线程 交由线程池处理。
                fixExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " doing");
                });
            }
        } catch (Exception e) {

        } finally {
            fixExecutor.shutdown();
        }
    }
}
