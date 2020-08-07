package lxl.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-07 13:37
 **/
public class SortArrayByParityii {

    public int[] sortArrayByParityII(int[] A) {
        int right = 1;
        for (int i = 0, l = A.length; i < l; i += 2) {
            if (A[i] % 2 == 0) {
                continue;
            }
            while (A[right] % 2 != 0) {
                right += 2;
            }
            int temp = A[i];
            A[i] = A[right];
            A[right] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityii sortArrayByParityii = new SortArrayByParityii();
        int[] A = {4, 2, 5, 7, 6, 6, 7, 7};
        System.out.println(Arrays.toString(sortArrayByParityii.sortArrayByParityII(A)));
    }
}
