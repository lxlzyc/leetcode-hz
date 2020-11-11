package lxl.y2020.MAY;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 示例 :
 * <p>
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * <p>
 * 注意：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-07 14:15
 **/
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        if (length <= 1) {
            return length;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] == o2[1]) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(pairs[0]);
        for (int j = 1; j < length; j++) {
            int[] peek = stack.peek();
            int[] index = pairs[j];
            if (peek[1] < index[0]) {
                stack.push(index);
            } else if (peek[1] > index[1]) {
                stack.pop();
                stack.push(index);
            }
        }
        return stack.size();
    }
}
