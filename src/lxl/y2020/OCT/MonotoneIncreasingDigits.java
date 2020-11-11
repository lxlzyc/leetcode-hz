package lxl.y2020.OCT;

/**
 * @program: leetcode-hz
 * @description: 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * <p>
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-28 10:24
 **/
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int l = chars.length;
        int nineEnd = l;
        for (int i = l - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1]--;
                for (int j = i; j < nineEnd; j++) {
                    chars[j] = '9';
                }
                nineEnd = i;
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(332));

    }

}
