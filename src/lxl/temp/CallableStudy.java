package lxl.temp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-24 21:29
 **/
public class CallableStudy {

    static class MyCallable implements Callable<Integer> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            System.out.println("-----" + Thread.currentThread().getName());
            Thread.sleep(2000);
            return 1;
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();
        //System.out.println("result = ----"+futureTask.get());
        while (!futureTask.isDone()) {

        }
        System.out.println("end");
    }

}
