package lxl.APR;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。
 * <p>
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 * <p>
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-01 11:05
 **/
public class UniqueSubstringsInWraparoundString {

    //动态规划
    //dp表示以当前字符结尾的最长递增子串的长度，map数组里存的是当前状态以a-z字母结尾的最长子串长度。
    //每访问一个字符，则首先更新dp值，连续的则dp+1， 否则dp等于1。然后将dp值与map里对应的值比较，
    //大于的话说明有新的以当前字母结尾的子串，更新sum的值。
    public int findSubstringInWraproundString2(String p) {
        int length = p.length();
        if (length == 0) {
            return 0;
        }

        int[] map = new int[26];
        int dp = 0;
        int sum = 0;
        char[] arr = p.toCharArray();

        for (int i = 0; i < length; i++) {
            char c = arr[i];
            if (i == 0 || (c - arr[i - 1] - 1) % 26 == 0) {
                dp++;
            } else {
                dp = 1;
            }
            int cnt = map[c - 'a'];
            if (dp > cnt) {
                sum += dp - cnt;
                map[c - 'a'] = dp;
            }
        }
        return sum;
    }


    //暴力
    public int findSubstringInWraproundString(String p) {
        Set<String> stringSet = new HashSet<>();
        char[] chars = p.toCharArray();
        StringBuilder stringBuilder;
        for (int i = 0, l = p.length(); i < l; i++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(chars[i]);
            stringSet.add(stringBuilder.toString());
            for (int j = i + 1; j < l; j++) {
                if (chars[j] - chars[j - 1] == 1 || chars[j] - chars[j - 1] == -25) {
                    stringBuilder.append(chars[j]);
                    stringSet.add(stringBuilder.toString());
                } else {
                    i = j;
                    break;
                }
            }
        }
        return stringSet.size();
    }

    public static void main(String[] args) {
        UniqueSubstringsInWraparoundString uniqueSubstringsInWraparoundString = new UniqueSubstringsInWraparoundString();

        System.out.println(uniqueSubstringsInWraparoundString.findSubstringInWraproundString("zab"));
    }

}
