package lxl.OCT;

/**
 * @program: leetcode-hz
 * @description: 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-23 10:02
 **/
public class MaxConsecutiveOnesiii {

    //滑动窗口，窗口内最多有k个0；
    public int longestOnes(int[] A, int K) {
        int l = A.length;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int ans = 0;
        while (right < l) {
            if (A[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > K) {
                while (left <= right) {
                    if (A[left] == 0) {
                        zeroCount--;
                        left++;
                        break;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesiii maxConsecutiveOnesiii = new MaxConsecutiveOnesiii();
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnesiii.longestOnes(A, 1));
    }
}
