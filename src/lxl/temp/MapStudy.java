package lxl.temp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 15:39
 **/
public class MapStudy {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        //初始16，扩容因子0.75 每次倍增
        //使用数组加链表-红黑树构建
        //>=8转成红黑树 <8恢复成链表
        hashMap.put("a", "a");
        Hashtable<String, String> hashtable = new Hashtable<>();
        //初始化11，以后1.5倍+1
        //synchronized修饰
        hashtable.put("a", "a");

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        //synchronized锁住node节点
        //value域用volatile修饰
        //key用final修饰
        //如果节点位置不变，直接获取，如果变了，get线程会帮助一起扩容
        //put remove会被锁住
        //Iteritor 和size，弱一致性，并不一定准确
        concurrentHashMap.put("a", "a");


    }

}
