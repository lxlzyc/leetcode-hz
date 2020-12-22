package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * <p>
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-22 10:53
 **/
public class ThreeStepsProblemLcci {

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        long pre1 = 1;
        long pre2 = 2;
        long pre3 = 4;
        int offset = 3;
        while (offset < n) {
            offset++;
            long index = (pre1 + pre2 + pre3) % 1000000007;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = index;
        }
        return (int) pre3;
    }

    public static void main(String[] args) {
        ThreeStepsProblemLcci threeStepsProblemLcci = new ThreeStepsProblemLcci();
        System.out.println(threeStepsProblemLcci.waysToStep(12000));
    }
}
