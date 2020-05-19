package lxl.MAY;

/**
 * @program: leetcode-hz
 * @description: 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-19 21:31
 **/
public class ValidPalindromeii {

    public boolean validPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return true;
        }
        int left = 0;
        int right = length - 1;
        char[] schar = s.toCharArray();
        while (left < right) {
            if (schar[left] == schar[right]) {
                left++;
                right--;
                continue;
            } else {
                int left1 = left;
                int right1 = right;
                left1++;
                boolean flag = true;
                while (left1 < right1) {
                    if (schar[left1] == schar[right1]) {
                        left1++;
                        right1--;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    left1 = left;
                    right1 = right;
                    right1--;
                    flag = true;
                    while (left1 < right1) {
                        if (schar[left1] == schar[right1]) {
                            left1++;
                            right1--;
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                return flag;
            }
        }
        return true;
    }
}
