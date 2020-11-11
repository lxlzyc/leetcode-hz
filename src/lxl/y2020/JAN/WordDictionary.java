package lxl.y2020.JAN;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * <p>
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-10 10:29
 **/
public class WordDictionary {
    static class Node {
        char index;
        // 97-122 a-z
        // 所有的输入都是由小写字母 a-z 构成的
        Node[] nodes;
        boolean nodesEffect = false;

        Node(char index) {
            this.index = index;
            nodes = new Node[26];
        }
    }


    private Node base;
    private Set<String> words;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        base = new Node('0');
        words = new HashSet<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node indexNode = base;
        Node[] nodes;
        for (int i = 0, l = word.length(); i < l; i++) {
            nodes = indexNode.nodes;

            char index = chars[i];
            int offset = Integer.valueOf(index) - 97;
            if (nodes[offset] == null) {
                nodes[offset] = new Node(index);
                indexNode.nodesEffect = true;
                indexNode = nodes[offset];
            } else {
                indexNode = nodes[offset];
            }
        }
        words.add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word.contains(".")) {
            return this.searchInner(word.toCharArray(), base, 0);
        } else {
            return words.contains(word);
        }
    }

    private boolean searchInner(char[] chars, Node indexNode, int begin) {
        Node[] nodes = indexNode.nodes;
        for (int i = begin, l = chars.length; i < l; i++) {
            nodes = indexNode.nodes;
            char index = chars[i];
            if (index != '.') {
                int offset = Integer.valueOf(index) - 97;
                if (nodes[offset] == null) {
                    return false;
                } else {
                    //nodes = nodes[offset].nodes;
                    indexNode = nodes[offset];
                }
            } else {
                boolean re = false;
                for (int j = 0; j < 26; j++) {
                    if (nodes[j] != null) {
                        re = this.searchInner(chars, nodes[j], i + 1);
                        if (re == true) {
                            return re;
                        }
                    }
                }

                return re;
            }
        }
        return !indexNode.nodesEffect;
    }

//["WordDictionary","","","","addWord","search","search","addWord","search","search","search","search","search","search"]
//            [[],[""],[""],[""],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
//    a=false
//            .at=false
//            .at=true
//    an.=true
//    a.d.=false
//    b.=false
//    a.d=true
//            .=false

    //["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
    //        [[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.search("a");
        wordDictionary.search(".at");
        wordDictionary.addWord("bat");
        wordDictionary.search(".at");
        wordDictionary.search("an.");
        wordDictionary.search("a.d.");
        wordDictionary.search("b.");
        wordDictionary.search("a.d");
        wordDictionary.search(".");

        //System.out.println(wordDictionary.search("abbbe"));
        //System.out.println(wordDictionary.search("abb.."));
        //System.out.println(wordDictionary.search("a..s"));
        //System.out.println(wordDictionary.search("a.....s"));
        //System.out.println(wordDictionary.search(".e"));
        //System.out.println(wordDictionary.search("..e"));

    }
}
