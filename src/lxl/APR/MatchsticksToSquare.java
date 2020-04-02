package lxl.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * <p>
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,2,2]
 * 输出: true
 * <p>
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,3,3,3,4]
 * 输出: false
 * <p>
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * 注意:
 * <p>
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-02 10:23
 **/
public class MatchsticksToSquare {
    //深度搜索
    //我们依次对每一根火柴进行搜索，当搜索到第 i 根火柴时，
    //我们可以把它放到四组中的任意一种。对于每一种放置方法，
    //我们继续对第 i + 1 根火柴进行递归搜索。
    //当我们搜索完全部的 N 根火柴后，再判断每一组火柴的长度之和是否都相同。

    private int[] numsCp;
    private int[] help = new int[4];
    private int length;
    private int square;

    public boolean makesquare(int[] nums) {
        length = nums.length;
        if (length < 4) {
            return false;
        }
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if (count % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        square = count / 4;
        if (nums[length - 1] > square) {
            return false;
        }
        numsCp = nums;
        help[0] += numsCp[0];
        return this.dfsNums(1);
    }

    private boolean dfsNums(int index) {
        if (index == length) {
            if (help[0] == help[1] && help[1] == help[2] && help[2] == help[3]) {
                return true;
            } else {
                return false;
            }
        }
        int indexNum = numsCp[index];
        for (int i = 0; i < 4; i++) {
            if (help[i] + indexNum <= square) {
                help[i] += indexNum;
                if (this.dfsNums(index + 1)) {
                    return true;
                }
                help[i] -= indexNum;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 4, 3, 3, 3, 3, 4, 3, 4, 3, 3, 3, 3, 4};
        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        System.out.println(matchsticksToSquare.makesquare(nums));
    }

}
