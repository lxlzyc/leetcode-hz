package lxl.y2020.DEC;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-10 09:58
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        int maxLen = coins.length;
        for (int i = 0; i < maxLen; i++) {
            if (coins[i] > amount) {
                maxLen = i;
                break;
            }
            dp[coins[i]] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int val = -1;
            for (int j = 0; j < maxLen; j++) {
                if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    if (val > 0) {
                        val = Math.min(val, dp[i - coins[j]] + 1);
                    } else {
                        val = dp[i - coins[j]] + 1;
                    }
                } else if (i - coins[j] <= 0) {
                    break;
                }
            }
            dp[i] = val;
        }
        return dp[amount] <= 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 11));
    }


}
