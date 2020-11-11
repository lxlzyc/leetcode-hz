package lxl.y2020.MAR;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 448. 找到所有数组中消失的数字
 * @author: lxl
 * @create: 2020-03-25 10:40
 **/
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> re = new ArrayList<>();
        for (int i = 0, l = nums.length; i < l; i++) {
            if (nums[i] < 0) {
                if (nums[0 - nums[i] - 1] > 0) {
                    nums[0 - nums[i] - 1] = 0 - nums[0 - nums[i] - 1];
                }
            } else {
                if (nums[nums[i] - 1] > 0) {
                    nums[nums[i] - 1] = 0 - nums[nums[i] - 1];
                }
            }
        }
        for (int i = 0, l = nums.length; i < l; i++) {
            if (nums[i] > 0) {
                re.add(i + 1);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
        System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums));
    }
}
