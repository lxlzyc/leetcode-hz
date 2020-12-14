package lxl.y2019.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-03 16:12
 **/
public class GenerateParentheses {
    //龟速
    public List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>(n > 2 ? 1 << n : 8);
        if (n == 0) {
            return lists;
        }
        if (n == 1) {
            lists.add("()");
            return lists;
        }
        int length = n * 2;
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 1);
        for (int i = 1; i < length - 1; i++) {
            Map<String, Integer> innerMap = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (value > 0) {
                    innerMap.put(entry.getKey() + ")", value - 1);
                }
                if (value < n && value < (length - i)) {
                    innerMap.put(entry.getKey() + "(", value + 1);
                }
            }
            map = innerMap;
        }

        for (String key : map.keySet()) {
            lists.add(key + ")");
            System.out.println(key + ")");
        }
        return lists;
    }

    //,n,max
    //, int n,int max
    private static int count = 0;
    private static int max = 0;

    public List<String> generateParenthesis2(int n) {
        List<String> lists = new ArrayList<>(n > 2 ? 1 << n : 8);
        if (n == 0) {
            return lists;
        }
        if (n == 1) {
            lists.add("()");
            return lists;
        }
        count = n;
        max = n * 2;
        this.backTrack(lists, "", 0, 0);
        return lists;
    }

    private void backTrack(List<String> lists, String cur, int openCount, int closeCount) {
        if (cur.length() == max) {
            lists.add(cur);
            System.out.println(cur);

            return;
        }
        if (openCount > closeCount) {
            this.backTrack(lists, cur + ")", openCount, closeCount + 1);
        }

        if (openCount < count) {
            this.backTrack(lists, cur + "(", openCount + 1, closeCount);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis2(3);
        //System.out.println(generateParentheses.generateParenthesis(2));
    }

}
