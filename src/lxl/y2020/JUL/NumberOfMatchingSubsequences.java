package lxl.y2020.JUL;

import java.util.ArrayList;

/**
 * @program: leetcode-hz
 * @description: 792. 匹配子序列的单词数
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 * <p>
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 * <p>
 * 注意:
 * <p>
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-matching-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-06 19:52
 **/
public class NumberOfMatchingSubsequences {

    class Node {
        String word;
        int index;

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<Node>[] wordList = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            wordList[i] = new ArrayList<>();
        }
        for (String word : words) {
            wordList[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        char[] chars = S.toCharArray();
        int count = 0;
        for (char index : chars) {
            ArrayList<Node> indexArray = wordList[index - 'a'];
            wordList[index - 'a'] = new ArrayList<>();
            for (Node node : indexArray) {
                if (node.word.length() != node.index + 1) {
                    node.index++;
                    wordList[node.word.charAt(node.index) - 'a'].add(node);
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numberOfMatchingSubsequences.numMatchingSubseq("abcde", words));
    }
}
