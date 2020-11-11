package lxl.y2020.FEB;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-02-25 19:24
 **/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length <= k) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char index : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > index) {
                stack.removeLast();
                k--;
            }
            stack.addLast(index);
        }
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        StringBuilder re = new StringBuilder();
        boolean zero = true;
        for (char index : stack) {
            if (zero && index == '0') {
                continue;
            }
            zero = false;
            re.append(index);
        }
        if (re.length() == 0) {
            return "0";
        }
        return re.toString();
    }


    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("112", 1));
    }
}
