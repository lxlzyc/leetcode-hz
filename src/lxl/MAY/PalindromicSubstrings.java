package lxl.MAY;

/**
 * @program: leetcode-hz
 * @description: 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-07 14:25
 **/
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        //以i为中点寻找子串
        int count = 0;
        int j;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            count++;
            j = 1;
            while (i - j >= 0 && i + j < length) {
                if (chars[i - j] == chars[i + j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (i < length - 1) {
                j = 0;
                while (i - j >= 0 && i + j + 1 < length) {
                    if (chars[i - j] == chars[i + j + 1]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }


}
