package lxl.JAN;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * <p>
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 16:37
 **/
public class ImplementTriePrefixTree {

    static class Node {
        char index;
        // 97-122 a-z
        // 所有的输入都是由小写字母 a-z 构成的
        Node[] nodes;

        Node(char index) {
            this.index = index;
            nodes = new Node[26];
        }
    }

    private Node base;
    private Set<String> words;

    public ImplementTriePrefixTree() {
        base = new Node('0');
        words = new HashSet<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node[] nodes = base.nodes;
        for (int i = 0, l = word.length(); i < l; i++) {
            char index = chars[i];
            int offset = Integer.valueOf(index) - 97;
            if (nodes[offset] == null) {
                nodes[offset] = new Node(index);
                nodes = nodes[offset].nodes;
            } else {
                nodes = nodes[offset].nodes;
            }
        }
        words.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return words.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node[] nodes = base.nodes;
        for (int i = 0, l = prefix.length(); i < l; i++) {
            char index = chars[i];
            int offset = Integer.valueOf(index) - 97;
            if (nodes[offset] == null) {
                return false;
            } else {
                nodes = nodes[offset].nodes;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree implementTriePrefixTree = new ImplementTriePrefixTree();
        implementTriePrefixTree.insert("apple");
        System.out.println(implementTriePrefixTree.search("appl"));
        System.out.println(implementTriePrefixTree.search("apple"));
        System.out.println(implementTriePrefixTree.startsWith("appl"));
        System.out.println("----------------");
        implementTriePrefixTree.insert("appt");
        System.out.println(implementTriePrefixTree.search("appt"));
        System.out.println(implementTriePrefixTree.search("apple"));
        System.out.println(implementTriePrefixTree.startsWith("appl"));
        System.out.println("----------------");
        System.out.println(implementTriePrefixTree.startsWith("appt"));
        System.out.println(implementTriePrefixTree.startsWith("app"));
        System.out.println(implementTriePrefixTree.startsWith("ad"));
        System.out.println("----------------");
        implementTriePrefixTree.insert("addd");
        System.out.println(implementTriePrefixTree.search("mddd"));
        System.out.println(implementTriePrefixTree.startsWith("ad"));
    }
}
