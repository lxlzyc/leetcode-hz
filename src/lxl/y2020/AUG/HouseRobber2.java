package lxl.y2020.AUG;

/**
 * @program: leetcode-hz
 * @description: 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-10 13:48
 **/
public class HouseRobber2 {

    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        if (l == 1) {
            return nums[0];
        }
        //分解成不打劫第一家不打劫最后一家两个问题
        return Math.max(this.robDeal(nums, 0, l - 1), this.robDeal(nums, 1, l));
    }

    private int robDeal(int[] nums, int left, int right) {
        int pre = 0;
        int cur = 0;
        while (left < right) {
            int temp = cur;
            cur = Math.max(nums[left] + pre, cur);
            pre = temp;
            left++;
        }
        return cur;
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        int[] nums = {2, 3, 2};
        System.out.println(houseRobber2.rob(nums));
    }

}
