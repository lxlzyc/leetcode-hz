package lxl.y2021.MAR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 967. 连续差相同的数字
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 * <p>
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 2, k = 0
 * 输出：[11,22,33,44,55,66,77,88,99]
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 2
 * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 9
 * 0 <= k <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/24 9:59
 * @Version 1.0
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        int min = (int) Math.pow(10, n) / 10;
        List<Integer> all = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<Integer> ans = this.getNumsSameConsecDiff(i, n - 1, k);
            if (ans != null) {
                for (Integer item : ans) {
                    if (item >= min) {
                        all.add(item);
                    }
                }
            }
        }
        int[] ans = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            ans[i] = all.get(i);
        }
        return ans;
    }

    private List<Integer> getNumsSameConsecDiff(int pre, int n, int k) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(pre);
            return ans;
        }
        int last = pre % 10;
        if (last - k >= 0) {
            int nextPre = pre * 10 + (last - k);
            List<Integer> next = this.getNumsSameConsecDiff(nextPre, n - 1, k);
            if (next != null) {
                ans.addAll(next);
            }
        }
        if (last + k <= 9 && k != 0) {
            int nextPre = pre * 10 + (last + k);
            List<Integer> next = this.getNumsSameConsecDiff(nextPre, n - 1, k);
            if (next != null) {
                ans.addAll(next);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences num = new NumbersWithSameConsecutiveDifferences();
        System.out.println(num.numsSameConsecDiff(2, 2));
    }
}