package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 202. 快乐数
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 14:55
 **/
public class HappyNumber {
    //不是快乐数的数称为不快乐数(unhappy number)，所有不快乐数的数位平方和计算，最后都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
    //已知规律： [1 ~ 4] 中只有 1 是快乐数，[5 ~ ∞] 的数字要么回归到 1 要么回归到 4 或 3
    //因此仅需在 n > 4 时调用递归
    public boolean isHappy(int n) {
        if (n > 4) {
            int nextn = 0;
            int help;
            while (n > 0) {
                help = n % 10;
                n = n / 10;
                nextn += help * help;
            }
            return this.isHappy(nextn);
        } else {
            if (n == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(1));
    }
}
