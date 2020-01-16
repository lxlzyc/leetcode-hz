package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-16 10:06
 **/
public class ValidAnagram {
    // a-z
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charsCount = new int[26];
        char[] chars = s.toCharArray();
        int index;
        for (int i = 0, l = chars.length; i < l; i++) {
            index = Integer.valueOf(chars[i]) - 97;
            charsCount[index] = charsCount[index] + 1;
        }
        chars = t.toCharArray();
        for (int i = 0, l = chars.length; i < l; i++) {
            index = Integer.valueOf(chars[i]) - 97;
            charsCount[index] = charsCount[index] - 1;
            if (charsCount[index] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }
}
