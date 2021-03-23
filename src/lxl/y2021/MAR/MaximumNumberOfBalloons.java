package lxl.y2021.MAR;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/23 13:39
 * @Version 1.0
 */
public class MaximumNumberOfBalloons {
    //    balloon
    private char[] ballon = {'b', 'a', 'n', 'l', 'o'};

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> help = new HashMap<>();
        for (char c : ballon) {
            help.put(c, 0);
        }
        for (char c : text.toCharArray()) {
            if (help.containsKey(c)) {
                help.put(c, help.get(c) + 1);
            }
        }
        int min = help.get(ballon[0]);
        for (int i = 1; i < 3; i++) {
            min = Math.min(help.get(ballon[i]), min);
        }
        for (int i = 3; i < 5; i++) {
            min = Math.min(help.get(ballon[i]) / 2, min);
        }
        return min;
    }
}