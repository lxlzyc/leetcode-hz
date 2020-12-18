package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-17 09:41
 **/
public class BestTimeToBuyAndSellStockWithTransactionFee {
    //卖出时扣减
    //考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
    //定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len + 1][2];
        dp[1][1] = 0 - prices[0];
        for (int i = 1; i < len; i++) {
            //表示第 i 天交易完后手里没有股票的最大利润
            dp[i + 1][0] = Math.max(dp[i][0], prices[i] + dp[i][1] - fee);
            //表示第 i 天交易完后手里持有一支股票的最大利润
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + 0 - prices[i]);
            ;
        }
        return dp[len][0];
    }

    public static void main(String[] args) {
        int[] pr = {1, 3, 2, 8, 4, 9};
        BestTimeToBuyAndSellStockWithTransactionFee best = new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(best.maxProfit(pr, 2));
    }
}
