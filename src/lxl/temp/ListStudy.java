package lxl.temp;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 15:21
 **/
public class ListStudy {


    public static void main(String[] args) {
        //transient Object[] elementData; 底层使用 不可序列化的数组。
        //只序列化有数据的，不序列化冗余
        List<String> list = new ArrayList<>();
        //初始化10，以后扩容1.5倍+1。 第一次判空，初始化为10
        list.add("a");
        //Node 双向链表
        List<String> list2 = new LinkedList<>();
        list2.add("a");

        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();
        //底层使用 ReentrantLock
        //写入时复制一个数组，不影响读取。写入完再复制过去。
        //数组使用 volatile修饰，保证可见性
        //保证最终一致性，不保证时时一致性。
        copy.add("a");

        Vector<String> vector = new Vector();
        //底层使用 synchronized
        vector.add("a");
        PriorityQueue<String> queue = new PriorityQueue<>();

    }
}
