package lxl.y2020.SEP;

/**
 * @program: leetcode-hz
 * @description: 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
 * <p>
 * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1 : 你猜测的数字比系统选出的数字大
 * 1 : 你猜测的数字比系统选出的数字小
 * 0 : 恭喜！你猜对了！
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-11 10:32
 **/
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int mid;
        int left = 1;
        int right = n;
        while (left < right) {
            mid = left + (right - left) / 2;
            int compare = this.guess(mid);
            if (compare == 0) {
                return mid;
            } else if (compare == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return this.guess(left) == 0 ? left : left + 1;
    }

    private int guess(int num) {
        return Integer.compare(6, num);
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();
        for (int i = 100; i > 10; i--) {
            System.out.println(guessNumberHigherOrLower.guessNumber(10));

        }
    }
}
