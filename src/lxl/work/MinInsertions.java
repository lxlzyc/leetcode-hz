package lxl.work;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 5470. 平衡括号字符串的最少插入次数
 * 5470. 平衡括号字符串的最少插入次数
 * 显示英文描述
 * <p>
 * 通过的用户数 0
 * 尝试过的用户数 0
 * 用户总通过次数 0
 * 用户总提交次数 0
 * 题目难度 Medium
 * <p>
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * <p>
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * <p>
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * <p>
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * <p>
 * 请你返回让 s 平衡的最少插入次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "())"
 * 输出：0
 * 解释：字符串已经平衡了。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "))())("
 * 输出：3
 * 解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "(((((("
 * 输出：12
 * 解释：添加 12 个 ')' 得到平衡字符串。
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = ")))))))"
 * 输出：5
 * 解释：在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 只包含 '(' 和 ')' 。
 * @author: lxl
 * @create: 2020-08-08 22:33
 **/
public class MinInsertions {

    public int minInsertions(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char index : s.toCharArray()) {
            if (index == '(') {
                linkedList.add(index);
            } else {
                int size = linkedList.size();
                if (size >= 2 && linkedList.get(size - 2) == '(' && linkedList.get(size - 1) == ')') {
                    linkedList.removeLast();
                    linkedList.removeLast();
                } else {
                    linkedList.add(index);
                }
            }
        }

        int count = 0;
        Stack<Character> help = new Stack<>();
        for (Character c : linkedList) {
            System.out.print(c);
        }
        System.out.println("");
        for (char item : s.toCharArray()) {
            if (help.isEmpty()) {
                if (item == '(') {
                    help.push(item);
                } else if (item == ')') {
                    help.push('(');
                    help.push(')');
                    count++;
                }
                continue;
            }
            if (item == '(') {
                if (help.peek() == '(') {
                    count += 2;
                } else {
                    count++;
                    help.pop();
                }
            } else if (item == ')') {
                if (help.size() > 1) {
                    if (help.peek() == '(') {
                        help.push(item);
                    } else {
                        help.pop();
                        help.pop();
                    }
                } else {
                    help.push(item);
                }
            } else {
                if (help.peek() == '(') {
                    count += 2;
                } else {
                    count += 1;
                }
                help.clear();
            }
        }
        if (!help.isEmpty()) {
            if (help.peek() == '(') {
                count += 2;
            } else {
                count++;
            }
        }
        return count;
    }

    //"()()()()()("
    //"()*))()*))" 4
    //"(()))(()))()())))"
    public static void main(String[] args) {
        MinInsertions minInsertions = new MinInsertions();
        //() () () )) 4
        System.out.println(minInsertions.minInsertions("(()))(()))()())))"));
        System.out.println(minInsertions.minInsertions("()*()*()*))"));

        //System.out.println(minInsertions.minInsertions("))())("));
        //System.out.println(minInsertions.minInsertions("(((((("));
        //System.out.println(minInsertions.minInsertions(")))))))"));

    }
}
