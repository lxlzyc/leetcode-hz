package lxl.y2020.APR;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予
 * “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * <p>
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-10 16:31
 **/
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int length = nums.length;
        int[] numscp = Arrays.copyOf(nums, length);
        Map<Integer, Integer> help = new HashMap<>();
        Arrays.sort(numscp);
        for (int i = 0; i < length; i++) {
            help.put(numscp[i], length - i);
        }
        int index = 3;
        String[] re = new String[length];
        for (int i = 0; i < length; i++) {
            if (index == 0) {
                re[i] = "" + help.get(nums[i]);
            } else {
                if (nums[i] == numscp[length - 1]) {
                    re[i] = "Gold Medal";
                } else if (nums[i] == numscp[length - 2]) {
                    re[i] = "Silver Medal";
                } else if (nums[i] == numscp[length - 3]) {
                    re[i] = "Bronze Medal";
                } else {
                    re[i] = "" + help.get(nums[i]);

                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        int[] nums = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(nums)));
    }
}
