package lxl.y2020.OCT;

/**
 * @program: leetcode-hz
 * @description: 622. 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-27 16:57
 **/
public class DesignCircularQueue {
    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private int maxSize;
    private int size;
    private Node base;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public DesignCircularQueue(int k) {
        base = new Node(0, null, null);
        base.pre = base;
        base.next = base;
        maxSize = k;
        size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node next = base.next;
        Node index = new Node(value, base, next);
        base.next = index;
        next.pre = index;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        Node pre = base.pre.pre;
        base.pre = pre;
        pre.next = base;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return base.pre.val;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return base.next.val;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size >= maxSize;
    }

    public static void main(String[] args) {
        DesignCircularQueue circularQueue = new DesignCircularQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3

        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
    }
}
