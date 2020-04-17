package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * https://leetcode-cn.com/problems/jump-game/
 * @author: lxl
 * @create: 2020-04-17 13:44
 **/
public class JumpGame {

    //贪心法，求最大
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int length = nums.length - 1;
        int i = 0;
        int help;
        while (i <= length) {
            if (nums[i] + i >= length) {
                return true;
            }
            if (nums[i] == 0) {
                break;
            }
            //最远跳跃距离
            help = nums[i] + i;
            boolean change = false;
            //求更优跳跃距离
            for (int j = i + 1, l = nums[i] + i; j <= l; j++) {
                if (nums[j] + j > help) {
                    help = nums[j] + j;
                    change = true;
                    i = j;
                }
            }
            if (!change) {
                i = nums[i] + i;
            }

        }
        return i >= length;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpGame.canJump(nums));
    }
}
