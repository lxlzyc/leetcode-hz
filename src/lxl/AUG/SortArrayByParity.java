package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-03 17:47
 **/
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int a : A) {
            if (a % 2 == 0) {
                ans[left] = a;
                left++;
            } else {
                ans[right] = a;
                right--;
            }
        }
        return ans;
    }
}
