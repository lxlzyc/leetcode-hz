package lxl.y2019.DEC;

/**
 * @program: leetcode-hz
 * @description: 32.最长的有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-05 15:25
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int left = 0;
        int right;
        int leftCount;
        while (left + maxLength < length) {
            leftCount  = 0;
            right = left;
            while (right < length && right + leftCount <= length) {
                if (chars[right] == '(') {
                    leftCount++;
                } else {
                    leftCount--;
                    if (leftCount < 0) {
                        break;
                    }else if(leftCount == 0){
                        maxLength = Math.max(right - left +1 , maxLength);
                    }
                }
                right++;
            }
            if(leftCount<0 && right-1>left){
                left = right-1;
            }else{
                left++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = ")(((((()())()()))()(()))(";
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }

}
