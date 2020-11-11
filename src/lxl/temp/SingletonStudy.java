package lxl.temp;

/**
 * @program: leetcode-hz
 * @description: 单例-双端检查锁
 * @author: lxl
 * @create: 2020-09-22 17:18
 **/
public class SingletonStudy {

    private static volatile SingletonStudy single = null;

    private SingletonStudy() {

    }

    //双重检查锁+volatile关键字，构建单例模式
    public static SingletonStudy getInstanse() {
        if (single == null) {
            synchronized (SingletonStudy.class) {
                if (single == null) {
                    single = new SingletonStudy();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        SingletonStudy singletonStudy = SingletonStudy.getInstanse();
        SingletonStudy singletonStudy2 = SingletonStudy.getInstanse();
        System.out.println(singletonStudy.equals(singletonStudy2));

    }
}
