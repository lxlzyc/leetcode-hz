package lxl.work;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description:30. 串联所有单词的子串
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
 * @create: 2019-12-04 17:05
 **/
public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re = new ArrayList<>();

        if (s == null || s.isEmpty()) {
            return re;
        }

        List<String> wordList = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>();

        int sumlength = 0;
        int length = s.length();
        int indexOffset;
        //存储所有word第一次的位置
        TreeMap<Integer, HashSet<String>> beginMap = new TreeMap<>();
        //存储所有word最后一次的位置
        TreeMap<Integer, HashSet<String>> lastMap = new TreeMap<>();
        // 定义两个map集合，一个存目标单词，一个存滑动窗口
        Map<String, Integer> needs = new HashMap<>(5);
        Map<String, Integer> windows = new HashMap<>(10);

        int lastOffset;
        for (String word : words) {
            if (word != null) {
                wordList.add(word);
                sumlength += word.length();
                indexOffset = s.indexOf(word);
                int count = needs.getOrDefault(word, 0);
                needs.put(word, count + 1);

                if (s.indexOf(word) < 0) {
                    return re;
                } else {
                    HashSet<String> strings = new HashSet<>();
                    strings.add(word);

                    if (beginMap.containsKey(indexOffset)) {
                        strings.addAll(beginMap.get(indexOffset));
                    }
                    beginMap.put(indexOffset, strings);

                    strings.clear();
                    strings.add(word);

                    lastOffset = s.lastIndexOf(word);
                    if (lastMap.containsKey(lastOffset)) {
                        strings.addAll(beginMap.get(indexOffset));
                    }
                    lastMap.put(indexOffset, strings);

                }
            }
        }
        //移除不可能的区间
        //判断长度是否有问题
        //双指针
        int left = beginMap.firstKey();
        int right;

        int minBegin = beginMap.firstKey();
        int maxBegin = beginMap.lastKey();

        int minLast = lastMap.firstKey();
        int maxLast = lastMap.lastKey();
        HashSet<String> maxLastSet = lastMap.get(maxLast);
        int maxLastLength = 0;
        for (String set : maxLastSet) {
            maxLastLength = Math.max(maxLastLength, set.length());
        }
        int status = 0;//0 left在beginmap范围内， 1 left不在beginmap，right不在lastmap，2，right在lastmap
        Map.Entry<Integer, HashSet<String>> entry;
        int match;
        // 所有单词数
        int size = words.length;
        int len = words[0].length();
        while (left + sumlength <= length && left + sumlength <= maxLast + maxLastLength) {
            if (status == 0) {
                //弹出首项
                entry = beginMap.pollFirstEntry();
            } else if (status == 1) {
                entry = null;
            } else {
                entry = lastMap.pollFirstEntry();
            }

            // 初始化左右指针开始处为i，match初始化为0
            right = left;
            match = 0;

            // 右指针最多到字符串的最后一个单词开始位置
            while (right <= s.length() - len) {

                // 向右滑动，存入单词和出现的次数
                String s1 = s.substring(right, right + len);
                // 以单词长度为步长移动右指针
                right += len;
                int count = windows.getOrDefault(s1, 0);
                windows.put(s1, count + 1);

                // 如果单词和出现的次数与目标一致，则匹配+1
                if (needs.containsKey(s1) && windows.get(s1).intValue() == needs.get(s1).intValue()) {
                    match++;
                }

                // 当匹配数等于目标集合的大小（说明已经覆盖了目标集合）
                while (left < right && match == needs.size()) {

                    // right - left / len求出窗口中单词数，如果等于目标单词数，则匹配成功，将左指针位置加入list
                    if ((right - left) / len == size) {
                        re.add(left);
                    }

                    // 左指针右移，类似右指针方法
                    String s2 = s.substring(left, left + len);
                    left += len;
                    windows.put(s2, windows.get(s2) - 1);

                    if (needs.containsKey(s2) && windows.get(s2).intValue() < needs.get(s2).intValue()) {
                        match--;
                    }
                }
            }
            // 清空窗口，进行下一次遍历
            windows.clear();
            //beginMap有值时
            if (left < maxBegin) {
                //left跳到treeMap中下一个节点
                left = beginMap.firstKey();
                //endMap有值时
                if (left + sumlength >= minLast) {
                    while (true) {
                        if (lastMap.containsKey(left + sumlength)) {
                            while (true) {
                                Integer inner = lastMap.firstKey();
                                if (inner < left + sumlength) {
                                    lastMap.pollFirstEntry();
                                } else {
                                    break;
                                }
                            }
                        } else {
                            beginMap.pollFirstEntry();
                            left = beginMap.firstKey();
                            if (left == maxBegin) {
                                if (!lastMap.containsKey(left + sumlength)) {
                                    left = Math.max(left++, minLast);
                                }
                                break;
                            }
                        }
                    }
                }
            } else {
                //beginMap清空时
                left++;
                //endMap有值时
                if (left + sumlength >= minLast) {
                    while (true) {
                        Integer inner = lastMap.firstKey();
                        if (inner < left + sumlength) {
                            lastMap.pollFirstEntry();
                        } else {
                            left = inner - sumlength;
                            break;
                        }
                    }
                }
            }

        }
        return re;
    }


    public static void main(String[] args) {
        SubstringWithConcatenation substringWithConcatenation = new SubstringWithConcatenation();
        String[] words = {"ss", "ss", "df"};
        System.out.println(substringWithConcatenation.findSubstring("asssssssdf", words));
    }
}
