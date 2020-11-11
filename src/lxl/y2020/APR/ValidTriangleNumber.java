package lxl.y2020.APR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-28 11:28
 **/
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int l = nums.length;
        int lastOffset;
        int count = 0;
        boolean end;
        for (int i = 0; i < l - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            lastOffset = i + 1;
            end = false;
            for (int j = i + 1; j < l - 1; j++) {
                if (end) {
                    count += lastOffset - j;

                } else {
                    int sum = nums[i] + nums[j];
                    while (lastOffset < l - 1 && nums[lastOffset + 1] < sum) {
                        lastOffset++;
                    }
                    if (lastOffset == l - 1) {
                        end = true;
                    }
                    count += lastOffset - j;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        int[] nums = {2, 2, 3, 4, 4, 5, 6, 7, 8, 10, 15, 20, 100};
        System.out.println(validTriangleNumber.triangleNumber(nums));
    }
}
