package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * <p>
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，
 * 在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * <p>
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * <p>
 * 提示:
 * <p>
 * nums长度在[1, 1000000]之间
 * @author: lxl
 * @create: 2020-07-31 10:52
 **/
public class MagicIndexLcci {

    public int findMagicIndex(int[] nums) {
        for (int i = 0, l = nums.length; i < l; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

}
