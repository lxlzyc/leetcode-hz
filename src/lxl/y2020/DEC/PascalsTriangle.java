package lxl.y2020.DEC;

import lxl.util.JSONUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 15:34
 **/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        if(numRows <= 0){
            return lists;
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        lists.add(list);
        List<Integer> parent = list;
        for (int i = 1; i < numRows; i++) {
            list = new LinkedList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(parent.get(j-1)+ parent.get(j));
            }
            list.add(1);
            lists.add(list);
            parent = list;
        }
        return lists;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> lists = pascalsTriangle.generate(5);
        for (List<Integer> list : lists){
            System.out.println(JSONUtil.toJson(list));
        }
    }

}
