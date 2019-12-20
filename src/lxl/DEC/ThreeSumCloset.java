package lxl.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-02 16:27
 **/
public class ThreeSumCloset {
    //Math.abs(-3.5)=3.5 取绝对值
    //找到 sum 第一次 大于target，比较两侧
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if(length<3){
            return 0;
        }
        Arrays.sort(nums);
        int simNum = nums[0] + nums[1]+nums[2];
        int closed;

        if(simNum >= target){
            return simNum;
        }else{
            closed = target - simNum;
        }
        int first;
        int index = 0;
        int sum;
        int second;
        int firstRight = length - 2;
        int secondRight = length - 1;
        int targetFlag = target == 0 ? 0:(target/3 +1);
        while (index < firstRight) {
            first = nums[index];
            if (first > targetFlag) {
                break;
            }
            if(index > 0 && first == nums[index - 1]){
                index++;
                continue;
            }
            sum = first;

            for (int i = index + 1; i < secondRight; i++) {
                second = nums[i];
                if (i > index + 1 && second == nums[i - 1]) {
                    continue;
                }
                sum = first + second;
                if (target - sum < second) {
                    break;
                }
                for (int j = i + 1; j < length; j++) {
                    sum = first + second + nums[j];
                    if(sum > target){
                        if(Math.abs(target-sum)<closed){
                            closed = target - sum;
                            simNum = sum;

                        }
                        break;
                    }else if(sum == target){
                        return target;
                    }else{
                        if(target - sum< closed){
                            closed = target - sum;
                            simNum = sum;
                        }
                    }
                }
            }
            index++;
        }
        return simNum;

    }


    public static void main(String[] args) {
        ThreeSumCloset threeSumCloset = new ThreeSumCloset();
        int[] nums = {0,2,1,-3};
        System.out.println(threeSumCloset.threeSumClosest(nums,1));
    }

}
