package lxl.y2021.JAN;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lxl
 * @program: leetcode-hz
 * @description: 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2021-01-07 10:37
 **/
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] co = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(co));
    }

    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        //构建并查集
        UnionFind unionFind = new UnionFind(l);
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.unionElements(i, j);
                }
            }
        }
        int[] unions = unionFind.id;
        Set<Integer> set = new HashSet<>();
        for (int i : unions) {
            set.add(i);
        }
        return set.size();
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
        public void unionElements(int secondElement, int firstElement) {
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
    }

}