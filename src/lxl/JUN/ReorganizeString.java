package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-19 10:30
 **/
public class ReorganizeString {
    public String reorganizeString(String S) {
        int length = S.length();
        if (length <= 1) {
            return S;
        }
        char[] chars = S.toCharArray();
        char[] counts = new char[26];
        int max = 0;
        int maxOffset = -1;
        for (int i = 0; i < length; i++) {
            char index = chars[i];
            counts[index - 'a']++;
            if (counts[index - 'a'] > max) {
                max = counts[index - 'a'];
                maxOffset = index - 'a';
            }
        }
        if (length % 2 == 0 && max > length / 2) {
            return "";
        } else if (length % 2 == 1 && max > length / 2 + 1) {
            return "";
        }
        char[] re = new char[length];
        int even = 1, odd = 0;
        while (counts[maxOffset] > 0) {
            counts[maxOffset]--;
            re[odd] = (char) (maxOffset + 'a');
            odd += 2;

        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                while (counts[i] > 0 && odd < length) {
                    re[odd] = (char) (i + 'a');
                    counts[i]--;
                    odd += 2;
                }
                while (counts[i] > 0) {
                    re[even] = (char) (i + 'a');
                    counts[i]--;
                    even += 2;
                }
            }

        }
        return new String(re);
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("vvvzy"));
    }

}
