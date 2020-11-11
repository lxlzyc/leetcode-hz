package lxl.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 17:39
 **/
public class GCStudy {
    //请写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，请给出代码以及启动参数。 找到了阿里中间件团队博客里面的两篇文章：

    //总结上面分析的策略，可以看到采用Parallel GC的情况下，当YGC触发时，会有两个检查：
    //1、在YGC执行前，min(目前新生代已使用的大小,之前平均晋升到old的大小中的较小值) > 旧生代剩余空间大小 ? 不执行YGC，直接执行Full GC : 执行YGC；
    //2、在YGC执行后，平均晋升到old的大小 > 旧生代剩余空间大小 ? 触发Full GC ： 什么都不做。
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("0.---");
        //https://blog.csdn.net/lxlmycsdnfree/article/details/78356704
        List caches = new ArrayList();
        //-Xms41m 初始内存
        //-Xmx41m 最大内存
        //-Xmn10m 年轻代大小
        //-XX:+UseParallelGC 选择垃圾收集器为并行收集器。此配置仅对年轻代有效。可以同时并行多个垃圾收集线程，但此时用户线程必须停止。
        //-XX:+PrintGCDetails 日志
        //-XX:+PrintGCTimeStamps 时间
        for (int i = 0; i < 11; i++) {
            //年轻代10mb，老年代31mb
            caches.add(new byte[3 * _1MB]);
        }

        System.out.println("1.---");

        caches.add(new byte[3 * _1MB]);

        caches.remove(0);
        caches.add(new byte[3 * _1MB]);


        for (int i = 0; i < 8; i++) {
            caches.remove(0);
        }
        caches.add(new byte[3 * _1MB]);

        System.out.println("2.---");

        for (int i = 0; i < 7; i++) {
            caches.add(new byte[3 * _1MB]);
        }

        //       -XX:+PrintGCTimeStamps输出格式：
        //
        //       293.271: [GC [PSYoungGen: 300865K->6577K(310720K)] 392829K->108873K(417472K), 0.0176464 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
        //
        //       详解：
        //
        //       293.271是从jvm启动直到垃圾收集发生所经历的时间，GC表示这是一次Minor GC（新生代垃圾收集）；[PSYoungGen: 300865K->6577K(310720K)] 提供了新生代空间的信息，PSYoungGen，表示新生代使用的是多线程垃圾收集器Parallel Scavenge。300865K表示垃圾收集之前新生代占用空间，6577K表示垃圾收集之后新生代的空间。新生代又细分为一个Eden区和两个Survivor区,Minor GC之后Eden区为空，6577K就是Survivor占用的空间。
        //
        //       括号里的310720K表示整个年轻代的大小。
        //
        //       392829K->108873K(417472K),表示垃圾收集之前（392829K）与之后（108873K）Java堆的大小（总堆417472K，堆大小包括新生代和年老代）
        //
        //       由新生代和Java堆占用大小可以算出年老代占用空间，如，Java堆大小417472K，新生代大小310720K那么年老代占用空间是417472K-310720K=106752k；垃圾收集之前老年代占用的空间为392829K-300865K=91964k 垃圾收集之后老年代占用空间108873K-6577K=102296k.
        //
        //       0.0176464 secs表示垃圾收集过程所消耗的时间。
        //
        //[Times: user=0.06 sys=0.00, real=0.01 secs] 提供cpu使用及时间消耗，user是用户模式垃圾收集消耗的cpu时间，实例中垃圾收集器消耗了0.06秒用户态cpu时间，sys是消耗系统态cpu时间,real是指垃圾收集器消耗的实际时间。


//        -XX:+PrintGCDetails输出格式：
//
//        293.289: [Full GC [PSYoungGen: 6577K->0K(310720K)]
//
//[PSOldGen: 102295K->102198K(134208K)] 108873K->102198K(444928K)
//
//                [PSPermGen: 59082K->58479K(104192K)], 0.3332354 secs]
//
//[Times: user=0.33 sys=0.00, real=0.33 secs]
//
//        说明：
//
//        Full GC表示执行全局垃圾回收
//
//[PSYoungGen: 6577K->0K(310720K)] 提供新生代空间信息，解释同上
//
//                [PSOldGen: 102295K->102198K(134208K)]提供了年老代空间信息；
//
//        108873K->102198K(444928K)整个堆空间信息；
//
//[PSPermGen: 59082K->58479K(104192K)]提供了持久代空间信息。
    }
}
