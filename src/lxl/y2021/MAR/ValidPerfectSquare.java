package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * <p>
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/7 14:04
 * @Version 1.0
 */
public class ValidPerfectSquare {
    //
    private int max = 46340;

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int left = num % 2 == 0 ? 2 : 3;
        int right = Math.min(max, num / left);
        //二分法
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = mid * mid;
            if (sum == num) {
                return true;
            } else if (sum < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        int[] tests = {361201};
        for (int test : tests) {
            System.out.println(test + "===" + validPerfectSquare.isPerfectSquare(test));
        }
    }
}