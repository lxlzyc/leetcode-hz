package lxl.y2019.DEC;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 11:25
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int help = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]+help>9){
                digits[i] = 0;
            }else{
                digits[i] += help;
                break;
            }
        }
        if(digits[0] == 0){
            int[] re = new int[digits.length+1];
            re[0] = 1;
            for (int i = 1,l=re.length; i < l; i++) {
                re[i] = digits[i-1];
            }
            return re;
        }else {
            return digits;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1};
        PlusOne plusOne = new PlusOne();
        System.out.println(JSONUtil.toJson(plusOne.plusOne(nums)));
    }

}
