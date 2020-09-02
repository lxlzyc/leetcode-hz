package lxl.SEP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode-hz
 * @description: 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-02 11:35
 **/
public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int l = words.length;
        char[][] chars = new char[l][];
        for (int i = 0; i < l; i++) {
            char[] index = words[i].toCharArray();
            Arrays.sort(index);
            chars[i] = index;
        }

        Arrays.sort(chars, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                return Integer.compare(o2.length, o1.length);
            }
        });
        int max = 0;
        for (int i = 0; i < l; i++) {
            char[] char1 = chars[i];
            if (char1.length * char1.length <= max) {
                break;
            }
            for (int j = i + 1; j < l; j++) {
                char[] chars2 = chars[j];
                if (char1.length * chars2.length <= max) {
                    break;
                }
                if (this.check(char1, chars2)) {
                    max = Math.max(char1.length * chars2.length, max);
                    break;
                }
            }
        }
        return max;
    }

    private boolean check(char[] char1, char[] chars2) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < char1.length && l2 < chars2.length) {
            if (char1[l1] == chars2[l2]) {
                return false;
            } else if (char1[l1] < chars2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(maximumProductOfWordLengths.maxProduct(words));
    }

}
