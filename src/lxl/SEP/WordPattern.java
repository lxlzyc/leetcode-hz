package lxl.SEP;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-01 15:47
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<String, Character> help = new HashMap<>();
        boolean[] visit = new boolean[26];
        for (int i = 0, l = words.length; i < l; i++) {
            if (help.containsKey(words[i])) {
                if (help.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                if (!visit[pattern.charAt(i) - 'a']) {
                    help.put(words[i], pattern.charAt(i));
                    visit[pattern.charAt(i) - 'a'] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "aaaa", str = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }

}
