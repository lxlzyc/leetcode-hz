package lxl.y2020.NOV;

/**
 * @program: leetcode-hz
 * @description: 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
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
 * @create: 2019-11-20 14:29
 **/
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;//不持有股票时的最大利润
        int hold = -prices[0];//持有股票时的最大利润
        System.out.println(cash + "|" + hold);
        for (int i = 1; i < prices.length; i++) {
            if (hold + prices[i] - fee > cash) {//不持有股票时的最大利润
                cash = hold + prices[i] - fee;
            }
            if (cash - prices[i] > hold) {//持有股票时的最大利润
                hold = cash - prices[i];
            }
            //cash = Math.max(cash, hold + prices[i] - fee);
            //hold = Math.max(hold, cash - prices[i]);
            System.out.println(cash + "|" + hold);
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        MaxProfit maxProfit = new MaxProfit();
        System.out.print(maxProfit.maxProfit(prices, 3));
    }

}
