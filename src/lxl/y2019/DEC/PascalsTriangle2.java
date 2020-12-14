package lxl.y2019.DEC;

import lxl.util.JSONUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 119. 杨辉三角2
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 15:34
 **/
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        List<Integer> parent = list;
        for (int i = 1; i < rowIndex + 1; i++) {
            list = new LinkedList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(parent.get(j - 1) + parent.get(j));
            }
            list.add(1);
            parent = list;
        }
        return parent;
    }


    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle = new PascalsTriangle2();
        List<Integer> list = pascalsTriangle.getRow(3);
        System.out.println(JSONUtil.toJson(list));

    }

}
