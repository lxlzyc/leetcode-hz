package lxl.y2020.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 908. 最小差值 I
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 * <p>
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * <p>
 * 示例 3：
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-05 13:56
 **/
public class SmallestRangei {

    public int smallestRangeI(int[] A, int K) {
        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();
        int re = max - min - 2 * K;
        return re < 0 ? 0 : re;
    }

    public static void main(String[] args) {
        SmallestRangei smallestRangei = new SmallestRangei();
        int[] A = {0, 10};
        System.out.println(smallestRangei.smallestRangeI(A, 3));
    }
}
