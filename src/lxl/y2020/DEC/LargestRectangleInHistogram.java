package lxl.y2020.DEC;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author: lxl
 * @create: 2019-11-25 15:31
 **/
public class LargestRectangleInHistogram {
    //在这种方法中，我们维护一个栈。一开始，我们把 -1 放进栈的顶部来表示开始。初始化时，按照从左到右的顺序，
    // 我们不断将柱子的序号放进栈中，直到遇到相邻柱子呈下降关系，也就是 a[i−1]>a[i]a[i-1] > a[i]a[i−1]>a[i] 。
    // 现在，我们开始将栈中的序号弹出，直到遇到 stack[j]stack[j]stack[j] 满足a[stack[j]]≤a[i]a\big[stack[j]\big] \leq a[i]a[stack[j]]≤a[i] 。
    // 每次我们弹出下标时，我们用弹出元素作为高形成的最大面积矩形的宽是当前元素与 stack[top−1]stack[top-1]stack[top−1]
    // 之间的那些柱子。也就是当我们弹出 stack[top]stack[top]stack[top] 时，记当前元素在原数组中的下标为 i ，当前弹出元素为高的最大矩形面积为：
    //
    //
    //更进一步，当我们到达数组的尾部时，我们将栈中剩余元素全部弹出栈。在弹出每一个元素是，我们用下面的式子来求面积：
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        if (l == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = heights[0];

        for (int i = 0; i < l; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram rectangle = new LargestRectangleInHistogram();
        int[] nums = {2, 1, 5, 0, 1, 1};
        System.out.println(rectangle.largestRectangleArea(nums));
    }

}
