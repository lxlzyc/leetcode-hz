package lxl.OCT;

/**
 * @program: leetcode-hz
 * @description: 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-29 14:21
 **/
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] help = new int[26];
        for (char a : s.toCharArray()) {
            help[a - 'a']++;
        }
        for (char a : t.toCharArray()) {
            help[a - 'a']--;
            if (help[a - 'a'] < 0) {
                return a;
            }
        }
        return ' ';
    }

    //异或
    public char findTheDifference2(String s, String t) {
        char ans = t.charAt(0);
        for (int i = 0, l = s.length(); i < l; i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i + 1);
        }
        return ans;
    }
}
