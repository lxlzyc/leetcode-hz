package lxl.y2020.APR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * <p>
 * <p>
 * American keyboard
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-09 14:02
 **/
public class KeyboardRow {
    private int[] keys = {
            2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3
    };

    public String[] findWords(String[] words) {
        List<String> lists = new ArrayList<>();
        for (String s : words) {
            if (this.checkIsLine(s)) {
                lists.add(s);
            }
        }
        String[] strings = new String[lists.size()];
        lists.toArray(strings);
        return strings;
    }

    private boolean checkIsLine(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int i = keys[s.charAt(0) - 'a'];
        for (int j = 1, l = s.length(); j < l; j++) {
            if (keys[s.charAt(j) - 'a'] != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        String[] keys = {
                "qwertyuIOPP", "ASDFGghjkll", "zxCvbnmr"
        };
        System.out.println(Arrays.toString(keyboardRow.findWords(keys)));

    }
}
