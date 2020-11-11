package lxl.temp;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 15:21
 **/
public class SetStudy {


    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        //使用hashmap实现 value=new Object()
        set.add("a");

        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        //使用CopyOnWriteArrayList实现
        copyOnWriteArraySet.add("a");

    }
}
