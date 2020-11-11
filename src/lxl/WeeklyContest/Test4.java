package lxl.WeeklyContest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-10-18 10:28
 **/
public class Test4 {

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int l = queries.length;
        List<Boolean> ans = new ArrayList<>();
        if (threshold == 0) {
            for (int i = 0; i < l; i++) {
                ans.add(true);
            }
            return ans;
        }
        UnionFind unionFind = new UnionFind(n + 1);

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (this.getGCD1(i, j) > threshold) {
                    unionFind.unionElements(i, j);
                }
            }
        }
        for (int i = 0; i < l; i++) {
            ans.add(unionFind.isConnected(queries[i][0], queries[i][1]));
        }
        return ans;
    }

    class UnionFind {
        /**
         * 数组，表示并查集所有元素
         */
        private int[] id;

        /**
         * 并查集的元素个数
         */
        private int size;

        /**
         * 构造一个新的并查集
         *
         * @param size 初始大小
         */
        public UnionFind(int size) {
            //初始化个数
            this.size = size;
            //初始化数组，每个并查集都指向自己
            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        /**
         * 查看元素所属于哪个集合
         *
         * @param element 要查看的元素
         * @return element元素所在的集合
         */
        private int find(int element) {
            return id[element];
        }

        /**
         * 判断两个元素是否同属于一个集合
         *
         * @param firstElement  第一个元素
         * @param secondElement 第二个元素
         * @return <code>boolean</code> 如果是则返回true。
         */
        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        /**
         * 合并两个元素所在的集合，也就是连接两个元素
         *
         * @param firstElement  第一个元素
         * @param secondElement 第二个元素
         */
        public void unionElements(int firstElement, int secondElement) {
            //找出firstElement所在的集合
            int firstUnion = find(firstElement);
            //找出secondElement所在的集合
            int secondUnion = find(secondElement);

            //如果这两个不是同一个集合，那么合并。
            if (firstUnion != secondUnion) {
                //遍历数组，使原来的firstUnion、secondUnion合并为secondUnion
                for (int i = 0; i < this.size; i++) {
                    if (id[i] == firstUnion) {
                        id[i] = secondUnion;
                    }
                }
            }
        }
        //
        ///**
        // * 本并查集使用数组实现，为了更直观地看清内部数据，采用打印数组
        // */
        //private void printArr() {
        //    for (int id : this.id) {
        //        System.out.print(id + "\t");
        //    }
        //    System.out.println();
        //}

    }

    public int getGCD1(int num1, int num2) {
        // 先获得绝对值，保证负数也可以求
        // 假定第一个数较大；如果第二个较大，在第二轮会颠倒过来
        // 如果第二个数为 0，则第一个数就是最大公约数
        while (num2 != 0) {
            // 求余
            int remainder = num1 % num2;
            // 交换数，等同递归调用
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        boolean[] help = {false, false, false, false, true, false, false, false, true, true, true, false, false, false, false, false, true, false, false, false, true, false, true, false, false, true, true, false, true, false, false, false, false, false, true, true, false, true, false, true, true, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, true, true, true, false, false, false, true, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, true, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, true, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, true, true, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true, true, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, false, true, false, false, false, false, true, true, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, true, false, false, false, false, true, false, false, false, true, true, true, true, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false};

        int[][] un = {{16, 12}, {16, 9}, {24, 9}, {16, 6}, {9, 25}, {5, 16}, {6, 9}, {9, 5}, {16, 24},
                {16, 10}, {9, 8}, {16, 20}, {9, 20}, {16, 18}, {9, 10}, {15, 16}, {4, 9}, {25, 16}, {12, 9}, {8, 16}, {15, 9}};

        Set<Integer> set = new HashSet<>();
        set.add(16);
        set.add(9);
        for (int i = 0, l = un.length; i < l; i++) {
            if (set.contains(un[i][0]) || set.contains(un[i][1])) {
                System.out.print("{" + un[i][0] + "," + un[i][1] + "},");
            }
        }
        System.out.println("");
        System.out.println(test4.areConnected(26, 3, un));
        //int[][] uu = {}
        //}   System.out.println(test4.areConnected(26,3,un));
    }
}
