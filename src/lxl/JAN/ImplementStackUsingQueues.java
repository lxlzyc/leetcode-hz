package lxl.JAN;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * <p>
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 11:23
 **/
public class ImplementStackUsingQueues {
    private List<Integer> list = new LinkedList<>();
    private int lengh = -1;

    public ImplementStackUsingQueues() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
        lengh++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int pop = this.top();
        list.remove(lengh);
        lengh--;
        return pop;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.get(lengh);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return lengh == -1;
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(2);
        obj.push(3);

        System.out.println(obj.top());

        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
        System.out.println(obj.pop());

        System.out.println(obj.empty());
    }

}
