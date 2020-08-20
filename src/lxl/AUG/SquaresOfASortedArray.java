package lxl.AUG;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-20 14:41
 **/
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        Stack<Integer> values = new Stack<>();
        int[] ans = new int[A.length];
        int begin = 0;
        for (int i = 0, l = A.length; i < l; i++) {
            if (A[i] < 0) {
                values.add(A[i] * A[i]);
            } else {
                int index = A[i] * A[i];
                while (!values.isEmpty() && values.peek() <= index) {
                    ans[begin] = values.pop();
                    begin++;
                }
                ans[begin] = index;
                begin++;
            }
        }
        while (!values.isEmpty()) {
            ans[begin] = values.pop();
            begin++;
        }
        return ans;
    }

}
