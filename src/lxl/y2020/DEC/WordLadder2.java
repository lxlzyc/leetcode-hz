package lxl.y2020.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 15:06
 **/
public class WordLadder2 {

    private Map<String, List<String>> wordMap = new HashMap<>();

    private Integer max = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (this.canChange(beginWord, endWord)) {
            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add(beginWord);
            list.add(endWord);
            lists.add(list);
            return lists;
        }
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        wordList.remove(beginWord);

        for (int i = 0, l = wordList.size(); i < l; i++) {
            String iString = wordList.get(i);
            if (this.canChange(beginWord, iString)) {
                List<String> simListBegin = wordMap.getOrDefault(beginWord, new ArrayList<>());
                simListBegin.add(iString);
                wordMap.put(beginWord, simListBegin);
            }
            for (int j = i + 1; j < l; j++) {
                String jString = wordList.get(j);
                List<String> simListI = wordMap.getOrDefault(iString, new ArrayList<>());
                List<String> simListJ = wordMap.getOrDefault(jString, new ArrayList<>());
                if (this.canChange(iString, jString)) {
                    simListI.add(jString);
                    wordMap.put(iString, simListI);
                    simListJ.add(iString);
                    wordMap.put(jString, simListJ);
                }

            }
        }
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(beginWord);
        List<List<String>> lists = this.findAllList(beginWord, endWord, arrayList);

        Iterator<List<String>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().size() != max) {
                iterator.remove();
            }
        }
        return lists;

    }

    private List<List<String>> findAllList(String beginWord, String endWord, List<String> line) {

        List<List<String>> lists = new ArrayList<>();
        if (line.size() + 1 > max) {
            return lists;
        }
        List<String> sim = wordMap.getOrDefault(beginWord, new ArrayList<>());
        if (sim.contains(endWord)) {
            line.add(endWord);
            max = Math.min(line.size(), max);
            lists.add(line);
            return lists;
        }
        for (String simWord : sim) {
            if (line.contains(simWord)) {
                continue;
            }
            List<String> index = new ArrayList<>();
            index.addAll(line);
            index.add(simWord);
            List<List<String>> re = this.findAllList(simWord, endWord, index);
            if (re != null && re.size() > 0) {
                lists.addAll(re);
            }
        }
        return lists;

    }

    private boolean canChange(String word1, String word2) {
        char[] wordChar1 = word1.toCharArray();
        char[] wordChar2 = word2.toCharArray();
        int nSameCount = 0;
        for (int i = 0, l = wordChar1.length; i < l; i++) {
            if (wordChar1[i] != wordChar2[i]) {
                nSameCount++;
                if (nSameCount > 1) {
                    break;
                }
            }
        }
        return nSameCount == 1;
    }

    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        list.add("dot");
        //
        //list.add("lot");
        //list.add("log");
        //list.add("cog");
        System.out.println(wordLadder2.findLadders("hot", "dog", list));
    }

}
