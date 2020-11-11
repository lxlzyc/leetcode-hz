package lxl.y2020.JUN;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * <p>
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-24 10:25
 **/
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }

            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb : ans) {
            finalans.add(sb.toString());
        }
        return finalans;

    }
}
