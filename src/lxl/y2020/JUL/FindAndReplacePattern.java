package lxl.y2020.JUL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-31 15:30
 **/
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int l = pattern.length();
        char[] patterns = pattern.toCharArray();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (this.checkWord(word, patterns, l)) {
                ans.add(word);
            }
        }
        return ans;
    }

    //遍历第一个映射表并使用一个数组记录每个值出现的次数。如果某个值出现了超过一次，就说明有两个字母映射到同一个字母，否则映射就是合法的。
    private boolean checkWord(String word, char[] patterns, int l) {
        Map<Character, Character> wordChange = new HashMap<>();
        char[] words = word.toCharArray();
        for (int i = 0; i < l; i++) {
            if (!wordChange.containsKey(words[i])) {
                wordChange.put(words[i], patterns[i]);
            } else if (wordChange.get(words[i]) != patterns[i]) {
                return false;
            }
        }
        boolean[] wordCheck = new boolean[26];
        for (Character index : wordChange.values()) {
            if (wordCheck[index - 'a']) {
                return false;
            } else {
                wordCheck[index - 'a'] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern.findAndReplacePattern(words, pattern));
    }

}
