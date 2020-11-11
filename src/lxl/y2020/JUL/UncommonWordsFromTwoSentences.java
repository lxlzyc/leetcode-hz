package lxl.y2020.JUL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 884. 两句话中的不常见单词
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-30 13:42
 **/
public class UncommonWordsFromTwoSentences {
    private Set<String> words;
    private Set<String> commonWords;

    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        words = new HashSet<>();
        commonWords = new HashSet<>();
        this.buildWord(wordsA);
        this.buildWord(wordsB);
        return words.toArray(new String[words.size()]);
    }

    private void buildWord(String[] wordsA) {
        for (String word : wordsA) {
            if (!commonWords.contains(word)) {
                if (words.contains(word)) {
                    words.remove(word);
                    commonWords.add(word);
                } else {
                    words.add(word);
                }
            }
        }
    }

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences uncommonWordsFromTwoSentences = new UncommonWordsFromTwoSentences();
        System.out.println(Arrays.toString(uncommonWordsFromTwoSentences.uncommonFromSentences("apple apple", "banana")));
    }

}
