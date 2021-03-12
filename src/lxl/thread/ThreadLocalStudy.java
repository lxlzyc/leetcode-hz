package lxl.thread;

import java.text.DecimalFormat;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: threadlocal原理及学习
 * https://www.zhihu.com/question/341005993
 * @date 2021/3/12 13:58
 * @Version 1.0
 */
public class ThreadLocalStudy {

    private static ThreadLocal<DecimalFormat> df = ThreadLocal.withInitial(() -> new DecimalFormat("0.00"));

    //ThreadLocal的作用主要是做数据隔离，填充的数据只属于当前线程，变量的数据对别的线程而言是相对隔离的，
    // 在多线程环境下，如何防止自己的变量被其它线程篡改。
    //    ThreadLocal数据隔离的真相了，每个线程Thread都维护了自己的threadLocals变量，
    //    所以在每个线程创建ThreadLocal的时候，实际上数据是存在自己线程Thread的threadLocals变量里面的，
    //    别人没办法拿到，从而实现了隔离。
    public static String formatAsPerson(Long num) {
        if (num == null) {
            return null;
        }
        return df.get().format(num);
    }

//    Spring采用Threadlocal的方式，来保证单个线程中的数据库操作使用的是同一个数据库连接，
//    同时，采用这种方式可以使业务层使用事务时不需要感知并管理connection对象，通过传播级别，
//    巧妙地管理多个事务配置之间的切换，挂起和恢复。Spring框架里面就是用的ThreadLocal来实现这种隔离，
//    主要是在TransactionSynchronizationManager这个类里面

//    发现部分用户的日期居然不对了，排查下来是SimpleDataFormat的锅，当时我们使用SimpleDataFormat的parse()方法，
//    内部有一个Calendar对象，调用SimpleDataFormat的parse()方法会先调用Calendar.clear（），
//            然后调用Calendar.add()，如果一个线程先调用了add()然后另一个线程又调用了clear()，
//    这时候parse()方法解析的时间就不对了。其实要解决这个问题很简单，让每个线程都new 一个自己的 SimpleDataFormat就好了，
//    但是1000个线程难道new1000个SimpleDataFormat？所以当时我们使用了线程池加上ThreadLocal包装SimpleDataFormat，
//    再调用initialValue让每个线程有一个SimpleDataFormat的副本，从而解决了线程安全的问题，也提高了性能。
//    作者：敖丙
//    链接：https://www.zhihu.com/question/341005993/answer/1367225682
//    来源：知乎
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    如果我想共享线程的ThreadLocal数据怎么办？
//    使用InheritableThreadLocal可以实现多个线程访问ThreadLocal的值，
//    我们在主线程中创建一个InheritableThreadLocal的实例，
//    然后在子线程中得到这个InheritableThreadLocal实例设置的值

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("addassa");
        System.out.println(threadLocal.get());
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("addassa2");
        System.out.println(threadLocal2.get());

    }
}