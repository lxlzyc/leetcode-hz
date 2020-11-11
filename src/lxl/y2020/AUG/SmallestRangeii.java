package lxl.y2020.AUG;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 910. 最小差值 II
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
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
 * 输入：A = [1,5,6], K = 6
 * 输出：3
 * 解释：B = [7,0,0]
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
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-06 14:09
 **/
public class SmallestRangeii {
    //首先对数组排序，然后最重要的一个思想是，排序后的数组中，一定有一个位置 i，i
    //本身及左测全部加 K,i 右侧全部减 K。 即A[0]..A[i]全部加上K，A[i+1]..A[n-1]全部减去 K，
    //此时整个数组的最大值是 A[n-1]-K 或 A[i]+K，最小值是 A[0]+K 或 A[i+1]-K。
    //有了这个前提后，就可以线性扫描 i从0到 n-2(i 等于 n-1相当于全部加 K，也就是原始的最大值-最小值)，求出最小的可能值。
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N - 1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i + 1];
            int high = Math.max(A[N - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6};
        int k = 3;
        SmallestRangeii smallestRangeii = new SmallestRangeii();
        System.out.println(smallestRangeii.smallestRangeII(A, k));
    }
}
