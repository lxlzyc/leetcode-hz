package lxl.y2021.DEC;

/**
 * @program: leetcode-hz
 * @description: 1217. 玩筹码
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * <p>
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * <p>
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * <p>
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * <p>
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-02 14:08
 **/
public class MinimumCostToMoveChipsToTheSamePosition {
    //所有奇数位置的筹码都可以通过N次方式一移动到位置postion[1]，
    //所有偶数位置的筹码都可以通过M次方式一移动到位置position[2].
    //这里一共花费开销为0，然后使用K次方式二将postion[1]和postion[2]两者中筹码数量较少的那一堆移动到另一堆即可，
    //K即为min(position[1], position[2])。而postion[1]和postion[2]中的筹码数量实际上就是position数组中奇数位置的筹码数量和偶数位置的筹码数量。
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //统计postion数组中奇数位置的筹码数量odd和偶数位置的筹码数量even
    //        odd和even的较小者就是答案
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int num : position) {
            if ((num & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }

}
