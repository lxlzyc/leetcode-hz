package lxl.y2019.NOV;

/**
 * @program: leetcode-hz
 * @description: 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-22 14:28
 **/
public class IntegerBreak {
    //观察以上枚举，我们可以列出以下贪心法则：
    //
    //第一优先级： 333；把数字 nnn 拆成尽可能多的 333 之和；
    //特殊情况： 拆完后，如果余数是 111；则应把最后的 3+13 + 13+1 替换为 2+22 + 22+2，因为后者乘积更大；
    //第二优先级： 222；留下的余数如果是 222，则保留，不再拆为 1+11+11+1。
    //
    //算法流程：
    //
    //当 n<=3n <= 3n<=3 时，按照贪心规则应直接保留原数字，但由于题目要求必须拆分，因此必须拆出一个 111，即直接返回 n−1n - 1n−1；
    //求 nnn 除以 333 的整数部分 aaa 和余数部分 bbb；
    //当 b==0b == 0b==0 时，直接返回 3a3^a3a；
    //当 b==1b == 1b==1 时，要将一个 1+31 + 31+3 转换为 2+22+22+2，此时返回 3a−1∗23^{a-1} * 23a−1∗2；
    //当 b==2b == 2b==2 时，返回 3a∗b3^a * b3a∗b。
    //
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int integerBreak(int n) {
        return 0;
    }

    public static void main(String[] args) {

    }

}
