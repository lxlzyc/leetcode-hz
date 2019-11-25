package lxl.NOV;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: lxl
 * @create: 2019-11-25 10:10
 **/
public class IsValidParentheses {
    //题解使用map存储括号对应关系
    public boolean isValid(String s) {
        if(s == null ){
            return false;
        }
        int l = s.length();
        if(l == 0){
            return true;
        }
        if(l == 1){
            return false;
        }

        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        stack.push(chars[0]);
        for (int i = 1; i < l; i++) {
            char index = chars[i];
            if(!stack.empty()){
                char peek = (char) stack.peek();
                if(index == ')' && peek == '('){
                    stack.pop();
                }else if(index == ']' && peek == '['){
                    stack.pop();
                }else if(index == '}' && peek == '{'){
                    stack.pop();
                }else{
                    stack.push(index);
                }
            } else{
                stack.push(index);
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsValidParentheses isValidParentheses = new IsValidParentheses();
        System.out.println(isValidParentheses.isValid(""));
    }

}
