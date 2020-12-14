package lxl.y2019.DEC;

import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 16:01
 **/
public class TriangleMiniMumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        List<Integer> list;
        List<Integer> parent;
        for (int i = 1; i < length; i++) {
            list = triangle.get(i);
            parent = triangle.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    list.set(j, parent.get(0) + list.get(j));
                } else {
                    if (j == i) {
                        list.set(j, parent.get(j - 1) + list.get(j));
                    } else {
                        list.set(j, Math.min(parent.get(j - 1), parent.get(j)) + list.get(j));
                    }
                }
            }
        }
        list = triangle.get(length - 1);
        int min = list.get(0);
        for (int j = 1; j < length; j++) {
            min = Math.min(min, list.get(j));
        }
        return min;
    }


    public static void main(String[] args) {

    }
}
