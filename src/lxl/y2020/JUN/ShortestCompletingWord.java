package lxl.y2020.JUN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 748. 最短完整词
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 * <p>
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * <p>
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 * <p>
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 牌照（licensePlate）的长度在区域[1, 7]中。
 * 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 * 单词列表（words）长度在区间 [10, 1000] 中。
 * 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-16 10:49
 **/
public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Character[] chars = this.getLicenseClearChar(licensePlate);
        int sameLength = Integer.MAX_VALUE;
        String re = null;
        for (String word : words) {
            if (word.length() < sameLength && word.length() >= chars.length) {
                boolean same = this.checkSame(chars, word);
                if (same) {
                    sameLength = word.length();
                    re = word;
                }
            }
        }
        return re;
    }

    private boolean checkSame(Character[] chars, String word) {
        char[] words = word.toCharArray();
        Arrays.sort(words);
        int begin = 0;
        int max = chars.length;
        for (int i = 0, l = words.length; i < l; i++) {
            if (begin >= max) {
                break;
            }
            if (words[i] == chars[begin]) {
                begin++;
            }
        }
        return begin >= max;
    }

    //asc 65-90 A-Z
    //asc 97-122 a-z
    private Character[] getLicenseClearChar(String licensePlate) {
        List<Character> list = new ArrayList<>();
        char[] lows = licensePlate.toCharArray();
        for (int i = 0, l = lows.length; i < l; i++) {
            if (lows[i] >= 65 && lows[i] <= 90) {
                list.add((char) (lows[i] + 32));
            } else if (lows[i] >= 97 && lows[i] <= 122) {
                list.add(lows[i]);
            }
        }
        Character[] result = list.toArray(new Character[list.size()]);
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        String li = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple", "stsp"};
        System.out.println(shortestCompletingWord.shortestCompletingWord(li, words));
    }
}
