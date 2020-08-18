package lxl.AUG;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-18 14:13
 **/
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        char[] nums = String.valueOf(K).toCharArray();
        //int[] ans = new int[Math.max(A.length, value.length()) + 1];
        LinkedList<Integer> ans = new LinkedList<>();
        int i = 0;
        int l1 = A.length - 1;
        int l2 = nums.length - 1;
        int one = 0;
        int num1;
        int num2;
        int count;
        while (i <= l1 || i <= l2) {
            num1 = i <= l1 ? A[l1 - i] : 0;
            num2 = i <= l2 ? nums[l2 - i] - '0' : 0;
            count = num1 + num2 + one;
            if (count >= 10) {
                count = count - 10;
                one = 1;
            } else {
                one = 0;
            }
            ans.addFirst(count);
            i++;
        }
        if (one > 0) {
            ans.addFirst(one);
        }
        return ans;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
        int[] A = {2, 1, 5};
        int K = 3211;
        System.out.println((addToArrayFormOfInteger.addToArrayForm(A, K)));
    }

}
