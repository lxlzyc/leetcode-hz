package lxl.y2020.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-23 09:52
 **/
public class CoinLcci {
    //5有2种方式组成
    //10有4种方式组成
    //25有13种方式组成
    public int waysToChange(int n) {

        int[] dp = new int[n + 1];
        int[] coins = {1, 5, 10, 25};
        Arrays.fill(dp, 1);

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        CoinLcci coinLcci = new CoinLcci();
        System.out.println(coinLcci.waysToChange(278));
    }
}
