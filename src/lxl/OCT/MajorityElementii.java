package lxl.OCT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-13 10:13
 **/
public class MajorityElementii {

    public List<Integer> majorityElement(int[] nums) {
        int count = nums.length / 3 + 1;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> help = new HashMap<>();
        for (int n : nums) {
            int ncount = help.getOrDefault(n, 0);
            if (ncount >= 0) {
                if (ncount + 1 >= count) {
                    ans.add(n);
                    if (ans.size() >= 2) {
                        return ans;
                    }
                    help.put(n, -1);
                } else {
                    help.put(n, ncount + 1);
                }

            }
        }
        return ans;
    }

    public List<Integer> majorityElement2(int[] nums) {

        int num1 = nums[0];
        int count1 = 0;
        int num2 = nums[0];
        int count2 = 0;
        //摩尔投票法
        for (int num : nums) {
            if (num == num1) {
                count1++;
                continue;
            }
            if (num == num2) {
                count2++;
                continue;
            }
            if (count1 <= 0) {
                num1 = num;
                count1 = 1;
                continue;
            }
            if (count2 <= 0) {
                num2 = num;
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }
        //计数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        int count = nums.length / 3 + 1;
        List<Integer> ans = new ArrayList<>();
        if (count1 >= count) {
            ans.add(num1);
        }
        if (count2 >= count) {
            ans.add(num2);
        }
        return ans;
    }

    public static void main(String[] args) {
        MajorityElementii majorityElementii = new MajorityElementii();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElementii.majorityElement2(nums));
    }

}
