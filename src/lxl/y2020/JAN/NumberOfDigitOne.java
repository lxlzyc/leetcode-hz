package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例:
 * <p>
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 14:10
 **/
public class NumberOfDigitOne {


    public int countDigitOne(int n) {
        int sum = 0;
        int pre = 0;
        int help = 1;
        while (n > 0) {
            if (n % 10 > 1) {
                sum += help + 1;
            } else {
                sum += pre + 1;
            }
            pre = n % 10;
            help = help * 10;
            n = n / 10;
        }
        return sum;
    }
    //
    //private int getDigitOne(int n) {
    //    if(n<10){
    //        return 1;
    //    }
    //}

    public static void main(String[] args) {
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        System.out.println(numberOfDigitOne.countDigitOne(2));
    }

}
