package lxl.temp;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 17:16
 **/
public class VolatileStudy {

    private volatile int i;

    public static void main(String[] args) {
        //保证内存可见性
        //禁止指令重排
        //不保证原子性
    }
}
