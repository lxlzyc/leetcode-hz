package lxl.y2020.AUG;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
 * 返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-11 16:06
 **/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pleft = 0;
        for (int i = 0, l = pushed.length; i < l; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[pleft]) {
                stack.pop();
                pleft++;
            }
        }
        return pleft == popped.length;
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences.validateStackSequences(A, B));
    }
}
