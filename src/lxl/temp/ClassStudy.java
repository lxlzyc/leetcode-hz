package lxl.temp;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 16:24
 **/
public class ClassStudy {

    static {
        System.out.println("static");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String path = "lxl.temp.ClassStudy";
        Class temp = Class.forName(path);
        System.out.println("----------------------");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //不初始化static 只有在new Instance（）方法的时候才会对static进行解析。
        classLoader.loadClass(path);
        //在我们熟悉的Spring框架中的IOC的实现就是使用的ClassLoader。
        //
        //而在我们使用JDBC时通常是使用Class.forName()方法来加载数据库连接驱动。这是因为在JDBC规范中明确要求Driver(数据库驱动)类必须向DriverManager注册自己。

    }
}
