package lxl.work2;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-13 11:29
 **/
public class IsTransformable {

    public boolean isTransformable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }
        for (int i = t.length() - 1; i >= 0; i--) {
            char index = chars2[i];
            LinkedList<Character> help = new LinkedList<>();
            while (!stack.isEmpty() && stack.peek() != index) {
                char pop = stack.pop();
                if (pop > index) {
                    return false;
                }
                help.addFirst(pop);
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
            stack.addAll(help);
        }
        return true;

    }

    public static void main(String[] args) {
        //IsTransformable isTransformable =new IsTransformable();
        //System.out.println(isTransformable.isTransformable("34521","23415"));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date date = new Date();
        if (date.before(calendar.getTime())) {
            System.out.println("计划开始/结束时间不得早于系统当前时间");
        }
        System.out.println("end");
    }
}
