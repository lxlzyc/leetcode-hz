package lxl.y2020.NOV;

/**
 * @program: leetcode-hz
 * @description: 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-27 17:41
 **/
public class PalindromeNumber {
    // int 范围 -2147483648——2147483647
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x > 2147447412) {
            return false;
        }
        int y = x;
        int re = 0;
        while (x > 0) {
            re = re * 10 + x % 10;
            x = x / 10;
        }
        return y == re ? true : false;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(0));
        System.out.println(palindromeNumber.isPalindrome(1200));
        System.out.println(palindromeNumber.isPalindrome(120021));
        System.out.println(palindromeNumber.isPalindrome(1201021));

    }

}
