package lxl.y2021.DEC;

/**
 * @program: leetcode-hz
 * @description: 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * <p>
 * 示例 3:
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * <p>
 * 说明：
 * <p>
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-09 09:49
 **/
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        } else if (num % 2 == 0) {
            return this.isUgly(num / 2);
        } else if (num % 3 == 0) {
            return this.isUgly(num / 3);
        } else if (num % 5 == 0) {
            return this.isUgly(num / 5);
        } else {
            return num == 1;
        }
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(-2147483648));
        //System.out.println(uglyNumber.isUgly(5));
        //System.out.println(uglyNumber.isUgly(8));
        //System.out.println(uglyNumber.isUgly(14));

    }
}
