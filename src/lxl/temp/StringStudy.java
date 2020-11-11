package lxl.temp;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 14:08
 **/
public class StringStudy {

    //string final
    // 1.保证线程安全
    // 2.保证hash一致--hash不用重新计算
    // 3.实现字符串池
    public static void main(String[] args) {
        String a = "a";
        //生成在常量池中
        String b = "a";
        //生成在堆内存中
        String c = new String("a");

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a.equals(c));

//        String：适用于少量的字符串操作的情况
//
//　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
//
//　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
    }
}
