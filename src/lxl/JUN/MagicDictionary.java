package lxl.JUN;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 676. 实现一个魔法字典
 * <p>
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 * <p>
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 * <p>
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 示例 1:
 * <p>
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * <p>
 * 注意:
 * <p>
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-02 13:56
 **/
public class MagicDictionary {
    /**
     * Initialize your data structure here.
     */
    private Set<String> words;
    private Map<String, Integer> wordsLike;

    public MagicDictionary() {
        words = new HashSet<>();
        wordsLike = new HashMap<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String dic : dict) {
            if (!words.contains(dic)) {
                words.add(dic);
                Set<String> bors = this.getAllNerighbors(dic);
                for (String bo : bors) {
                    wordsLike.put(bo, wordsLike.getOrDefault(bo, 0) + 1);
                }
            }
        }
    }

    private Set<String> getAllNerighbors(String dic) {
        char[] ca = dic.toCharArray();
        Set<String> re = new HashSet<>();
        for (int i = 0, l = dic.length(); i < l; i++) {
            char help = ca[i];
            ca[i] = '*';
            String newString = new String(ca);
            re.add(newString);
            ca[i] = help;
        }
        return re;
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        char[] ca = word.toCharArray();
        for (int i = 0, l = word.length(); i < l; i++) {
            char help = ca[i];
            ca[i] = '*';
            String newString = new String(ca);
            int count = wordsLike.getOrDefault(newString, 0);
            if (count > 1 || (count == 1 && !words.contains(word))) {
                return true;
            }
            ca[i] = help;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] strings = {"hello", "leetcode"};
        magicDictionary.buildDict(strings);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));

    }
}
