package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 11:12
 **/
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = this.maxPartProfit(prices, 0, length, length);
        for (int i = 2; i < length - 1; i++) {
            if (prices[i] < prices[i - 1]) {
                max = Math.max(
                        max,
                        this.maxPartProfit(prices, 0, i, length)
                                + this.maxPartProfit(prices, i, length, length)
                );
            }
        }
        return max;
    }

    public int maxPartProfit(int[] prices, int begin, int end, int length) {
        if (begin >= end || begin >= length) {
            return 0;
        }
        int max = 0;
        int buy = prices[begin];
        for (int i = begin + 1, l = end; i < l; i++) {
            if (prices[i] > buy) {
                max = Math.max(prices[i] - buy, max);
            } else {
                buy = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock3();
        int[] nums = {2, 1, 2, 0, 1};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(nums));
    }
}
