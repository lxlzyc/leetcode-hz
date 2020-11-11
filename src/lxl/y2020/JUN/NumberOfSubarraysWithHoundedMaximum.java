package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 795. 区间子数组个数
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * <p>
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * <p>
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * <p>
 * 注意:
 * <p>
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-28 10:36
 **/
public class NumberOfSubarraysWithHoundedMaximum {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0;
        int pre = -1;
        for (int i = 0, l = A.length; i < l; i++) {
            if (A[i] < L || A[i] > R) {
                if (pre >= 0) {
                    count += getSubCount(i - pre + 1);
                    pre = -1;
                }
            } else {
                if (pre < 0) {
                    pre = i;
                }
            }
        }
        if (pre >= 0) {
            count += getSubCount(A.length - pre);
        }
        return count;
    }

    public int getSubCount(int length) {
        if (length < 1) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        return length + this.getSubCount(length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        NumberOfSubarraysWithHoundedMaximum numberOfSubarraysWithHoundedMaximum = new NumberOfSubarraysWithHoundedMaximum();
        System.out.println(numberOfSubarraysWithHoundedMaximum.numSubarrayBoundedMax(nums, 2, 3));
    }

}
