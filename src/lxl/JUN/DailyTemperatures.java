package lxl.JUN;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * @author: lxl
 * @create: 2020-06-11 10:22
 **/
public class DailyTemperatures {
    //暴力超时
    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        if (length == 0) {
            return new int[0];
        }
        int[] re = new int[length];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (re[j] == 0 && T[i] > T[j]) {
                    re[j] = i - j;
                }
            }
        }
        return re;
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        if (length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] re = new int[length];
        for (int i = 0; i < length; i++) {
            int index = T[i];
            while (!stack.isEmpty() && index > T[stack.peek()]) {
                re[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return re;
    }
}
