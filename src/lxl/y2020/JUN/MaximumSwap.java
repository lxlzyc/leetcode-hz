package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * <p>
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-01 15:45
 **/
public class MaximumSwap {
    //数字界定最大 10^8 不会越界
    public int maximumSwap(int num) {
        String numString = String.valueOf(num);
        int[] help = new int[9];
        int[] nums = new int[8];
        int i = 0;
        while (num != 0) {
            nums[i] = num % 10;
            num = num / 10;
            help[i + 1] = Math.max(help[i], nums[i]);
            i++;
        }
        i--;
        int max = i;
        while (i >= 0) {
            if (nums[i] < help[i]) {
                //交换
                for (int j = 0; j < i; j++) {
                    if (nums[j] == help[i]) {
                        nums[j] = nums[i];
                        nums[i] = help[i];
                        i = 0;
                        break;
                    }
                }
            }
            i--;
        }
        return this.buildValue(nums, max);
    }

    private int buildValue(int[] nums, int max) {
        int re = 0;
        for (int i = 0; i <= max; i++) {
            re += nums[i] * ((int) Math.pow(10, i));
        }
        return re;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(2736));
    }

}
