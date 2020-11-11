package lxl.y2020.SEP;

/**
 * @program: leetcode-hz
 * @description: 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-07 17:25
 **/
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }
}
