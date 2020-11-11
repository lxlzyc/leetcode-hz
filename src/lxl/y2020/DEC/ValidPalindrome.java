package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 125. 验证回文串
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 14:37
 **/
public class ValidPalindrome {
    //asc 40-57  0-9
    //asc 65-90 A-Z
    //asc 97-122 a-z
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        int left = 0;
        boolean re = true;
        while (right > left) {
            int check = this.checkEffect(chars[left]);
            while (check == 0 && right > left + 1) {
                left++;
                check = this.checkEffect(chars[left]);
            }
            if (check == 0) {
                left++;
                continue;
            }
            check = this.checkEffect(chars[right]);
            while (check == 0 && right - 1 > left) {
                right--;
                check = this.checkEffect(chars[right]);
            }
            if (check == 0) {
                right--;
                continue;
            }
            if (check == 1) {
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                } else {
                    re = false;
                    break;
                }
            } else {
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                } else if (check == 2 && chars[left] == chars[right] + 32) {
                    left++;
                    right--;
                } else if (check == 3 && chars[left] == chars[right] - 32) {
                    left++;
                    right--;
                } else {
                    re = false;
                    break;
                }
            }

        }
        return re;
    }

    private int checkEffect(char aChar) {
        if (aChar >= 48 && aChar <= 57) {
            return 1;
        } else if (aChar >= 65 && aChar <= 90) {
            return 2;
        } else if (aChar >= 97 && aChar <= 122) {
            return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }

}
