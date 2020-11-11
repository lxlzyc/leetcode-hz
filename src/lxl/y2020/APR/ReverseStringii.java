package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转
 * 。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 要求:
 * <p>
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-14 22:54
 **/
public class ReverseStringii {

    public String reverseStr(String s, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        int lengh = s.length();
        int begin = 0;
        char[] chars = s.toCharArray();
        while (begin + k * 2 < lengh) {
            for (int i = 1; i <= k; i++) {
                stringBuilder.append(chars[begin + k - i]);
            }
            stringBuilder.append(s.substring(begin + k, begin + k * 2));

            begin += k * 2;
        }
        if (begin + k <= lengh) {
            for (int i = 1; i <= k; i++) {
                stringBuilder.append(chars[begin + k - i]);
            }
            stringBuilder.append(s.substring(begin + k, lengh));
        } else {
            StringBuilder temp = new StringBuilder(s.substring(begin, lengh));

            stringBuilder.append(temp.reverse());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseStringii reverseStringii = new ReverseStringii();
        System.out.println(reverseStringii.reverseStr("abcdefg", 13));
    }

}
