package lxl.y2020.AUG;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-28 10:52
 **/
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int wordL = words[0].length();
        int sublength = wordL * words.length;
        int length = s.length();
        List<Integer> ans = new ArrayList<>();
        //按单词长度逐个后移
        for (int i = 0; i < wordL; i++) {
            int left = i;
            Map<String, Integer> indexMap = new HashMap<>();
            int right = i;
            while (right + wordL <= length) {
                String word = s.substring(right, right + wordL);
                int count = wordMap.getOrDefault(word, 0);
                if (count == 0) {
                    left = right + wordL;
                    right = left;
                    indexMap.clear();
                } else if (count == indexMap.getOrDefault(word, 0)) {
                    String beginWord = s.substring(left, left + wordL);
                    indexMap.put(beginWord, indexMap.get(beginWord) - 1);
                    left += wordL;
                } else {
                    indexMap.put(word, indexMap.getOrDefault(word, 0) + 1);
                    if (right + wordL - left == sublength) {
                        ans.add(left);
                        String beginWord = s.substring(left, left + wordL);
                        indexMap.put(beginWord, indexMap.get(beginWord) - 1);
                        left += wordL;
                    }
                    right += wordL;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        String[] words = {};
        String word = "";
//[6,9,12]
        System.out.println(JSONUtil.toJson(substringWithConcatenationOfAllWords.findSubstring(word, words)));
    }
}
