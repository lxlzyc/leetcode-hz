package lxl.JUL;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-common-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-13 15:28
 **/
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        //转小写
        paragraph = paragraph.toLowerCase();
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, Integer> wordCountMap = new HashMap<>();
        bannedWords.add("");
        int max = 0;
        String maxWord = "";
        for (char index : paragraph.toCharArray()) {
            if (index - 'a' < 0 || index - 'a' > 25) {
                if (stringBuffer.length() > 0) {
                    String word = stringBuffer.toString();
                    stringBuffer.delete(0, stringBuffer.length());
                    if (!bannedWords.contains(word)) {
                        int count = wordCountMap.getOrDefault(word, 0) + 1;
                        if (count > max) {
                            max = count;
                            maxWord = word;
                        }
                        wordCountMap.put(word, count);
                    }
                }
            } else {
                stringBuffer.append(index);
            }
        }
        if (stringBuffer.length() > 0) {
            String word = stringBuffer.toString();
            stringBuffer.delete(0, stringBuffer.length());
            if (!bannedWords.contains(word)) {
                int count = wordCountMap.getOrDefault(word, 0) + 1;
                if (count > max) {
                    max = count;
                    maxWord = word;
                }
                wordCountMap.put(word, count);
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String[] ba = {"hit"};
        System.out.println(mostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ba));
    }
}
