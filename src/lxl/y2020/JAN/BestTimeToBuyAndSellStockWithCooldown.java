package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @author: lxl
 * @create: 2020-01-17 10:54
 **/
public class BestTimeToBuyAndSellStockWithCooldown {
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //max(   选择 rest  ,           选择 sell      )
    //
    //解释：今天我没有持有股票，有两种可能：
    //要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
    //要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
    //
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //max(   选择 rest  ,           选择 buy         )
    //
    //解释：今天我持有着股票，有两种可能：
    //要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
    //要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
    //
    //作者：labuladong
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
    //
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    //解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
    //
    //作者：labuladong
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < length; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }
}
