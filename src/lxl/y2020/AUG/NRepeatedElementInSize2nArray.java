package lxl.y2020.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-18 09:48
 **/
public class NRepeatedElementInSize2nArray {

    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        if (A[A.length / 2] == A[A.length / 2 + 1]) {
            return A[A.length / 2];
        }
        return A[A.length / 2 - 1];
    }
}
