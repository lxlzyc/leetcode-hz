package lxl.y2020.OCT;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: leetcode-hz
 * @description: 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-29 13:58
 **/
public class ShuffleAnArray {
    //洗牌
    private int[] nums;
    private int[] shuffle;
    private int l;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.l = nums.length;
        this.shuffle = Arrays.copyOf(nums, l);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < l - 1; i++) {
            int randomSwap = random.nextInt(l - i);
            if (randomSwap != i) {
                int temp = shuffle[i];
                shuffle[i] = shuffle[randomSwap];
                shuffle[randomSwap] = temp;
            }
        }
        return shuffle;
    }
}
