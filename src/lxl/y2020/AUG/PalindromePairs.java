package lxl.y2020.AUG;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 336. 回文对
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-06 10:24
 **/
public class PalindromePairs {
    //方法一：枚举前缀和后缀
    //
    //        思路及算法
    //
    //假设存在两个字符串 s1s_1s1​ 和 s2s_2s2​，s1+s2s_1+s_2s1​+s2​ 是一个回文串，记这两个字符串的长度分别为 len1len_1len1​ 和 len2len_2len2​，我们分三种情况进行讨论：
    //
    //len1=len2\textit{len}_1 = \textit{len}_2len1​=len2​，这种情况下 s1s_1s1​ 是 s2s_2s2​ 的翻转。
    //len1>len2\textit{len}_1 > \textit{len}_2len1​>len2​，这种情况下我们可以将 s1s_1s1​ 拆成左右两部分：t1t_1t1​ 和 t2t_2t2​，其中 t1t_1t1​ 是 s2s_2s2​ 的翻转，t2t_2t2​ 是一个回文串。
    //len1<len2\textit{len}_1 < \textit{len}_2len1​<len2​，这种情况下我们可以将 s2s_2s2​ 拆成左右两部分：t1t_1t1​ 和 t2t_2t2​，其中 t2t_2t2​ 是 s1s_1s1​ 的翻转，t1t_1t1​ 是一个回文串。
    //
    //这样，对于每一个字符串，我们令其为 s1s_1s1​ 和 s2s_2s2​ 中较长的那一个，然后找到可能和它构成回文串的字符串即可。
    //
    //具体地说，我们枚举每一个字符串 kkk，令其为 s1s_1s1​ 和 s2s_2s2​ 中较长的那一个，那么 kkk 可以被拆分为两部分，t1t_1t1​ 和 t2t_2t2​。
    //
    //当 t1t_1t1​ 是回文串时，符合情况 333，我们只需要查询给定的字符串序列中是否包含 t2t_2t2​ 的翻转。
    //当 t2t_2t2​ 是回文串时，符合情况 222，我们只需要查询给定的字符串序列中是否包含 t1t_1t1​ 的翻转。
    //
    //也就是说，我们要枚举字符串 kkk 的每一个前缀和后缀，判断其是否为回文串。如果是回文串，我们就查询其剩余部分的翻转是否在给定的字符串序列中出现即可。
    //
    //注意到空串也是回文串，所以我们可以将 kkk 拆解为 k+∅k+\varnothingk+∅ 或 ∅+k\varnothing+k∅+k，这样我们就能将情况 111 也解释为特殊的情况 222 或情况 333。
    //
    //而要实现这些操作，我们只需要设计一个能够在一系列字符串中查询「某个字符串的子串的翻转」是否存在的数据结构，有两种实现方法：
    //
    //我们可以使用字典树存储所有的字符串。在进行查询时，我们将待查询串的子串逆序地在字典树上进行遍历，即可判断其是否存在。
    //
    //我们可以使用哈希表存储所有字符串的翻转串。在进行查询时，我们判断带查询串的子串是否在哈希表中出现，就等价于判断了其翻转是否存在。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<Integer>> palindromePairs(String[] words) {
        int l = words.length;
        if (l <= 1) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> reverseMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            reverseMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char[] word = words[i].toCharArray();
            //构建result
            Set<Integer> last = new HashSet<>();
            Set<Integer> last2 = new HashSet<>();
            last.add(reverseMap.getOrDefault(words[i], -1));

            for (int j = 0, k = word.length; j < k; j++) {
                //从左检查子串
                if (this.isPalindRomePairs(word, j, k - 1)) {
                    last.add(reverseMap.getOrDefault(words[i].substring(0, j), -1));
                }
                //从右检查子串
                if (this.isPalindRomePairs(word, 0, k - j - 1)) {
                    last2.add(reverseMap.getOrDefault(words[i].substring(k - j, k), -1));
                }
            }
            last.remove(i);
            last.remove(-1);
            for (Integer offset : last) {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                index.add(offset);
                ans.add(index);
            }
            last2.remove(-1);
            for (Integer offset : last2) {
                List<Integer> index = new ArrayList<>();
                index.add(offset);
                index.add(i);
                ans.add(index);
            }
        }
        return ans;
    }

    private boolean isPalindRomePairs(char[] word, int left, int right) {
        while (left < right) {
            if (word[left] != word[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs palindromePairs = new PalindromePairs();
        System.out.println(JSONUtil.toJson(palindromePairs.palindromePairs(words)));
    }
}
