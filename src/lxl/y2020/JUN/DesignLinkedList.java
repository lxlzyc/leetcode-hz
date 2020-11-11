package lxl.y2020.JUN;

import lxl.util.JSONUtil;

/**
 * @program: leetcode-hz
 * @description: 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * \如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-09 15:15
 **/
public class DesignLinkedList {
    static class Node {
        Node pre;
        int val;
        Node next;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private int size;
    //哨兵头尾节点
    private Node first;
    private Node last;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {
        size = 0;
        first = new Node(-1, null, null);
        last = new Node(-1, null, null);
        first.next = last;
        last.pre = first;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node node;
        if (index + 1 < size - index) {
            node = first;
            for (int i = 0; i < index + 1; ++i) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = 0; i < size - index; ++i) {
                node = node.pre;
            }
        }

        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node next = first.next;
        Node node = new Node(val, null, null);
        node.next = next;
        node.pre = first;
        first.next = node;
        next.pre = node;
        ++size;
        //System.out.println(JSONUtil.toJson(first));
        this.systemFirst();
    }

    private void systemFirst() {
        Node node = first.next;
        while (node.val >= 0) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("size=" + size);

        System.out.println("");
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node pre = last.pre;
        Node node = new Node(val, null, null);
        node.pre = pre;
        node.next = last;
        last.pre = node;
        pre.next = node;
        ++size;
        //System.out.println(JSONUtil.toJson(first));
        this.systemFirst();

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }

        Node node;
        Node next;
        if (index < size - index) {
            node = first;
            for (int i = 0; i < index; ++i) {
                node = node.next;
            }
            next = node.next;
        } else {
            next = last;
            for (int i = 0; i < size - index; ++i) {
                next = next.pre;
            }
            node = next.pre;
        }
        Node indexNode = new Node(val, null, null);
        indexNode.next = next;
        indexNode.pre = node;
        node.next = indexNode;
        next.pre = indexNode;
        ++size;
        this.systemFirst();
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node node;
        Node next;
        if (index < size - index) {
            node = first;
            for (int i = 0; i < index; ++i) {
                node = node.next;
            }
            next = node.next.next;
        } else {
            next = last;
            for (int i = 0; i < size - index - 1; ++i) {
                next = next.pre;
            }
            node = next.pre.pre;
        }
        --size;
        node.next = next;
        next.pre = node;
        this.systemFirst();

    }


    public static void main(String[] args) {
//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//
//[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
//


        DesignLinkedList linkedList = new DesignLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(JSONUtil.toJson(linkedList.get(4)));//输出2
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);
        //
        //linkedList.addAtTail(3);
        //linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        //System.out.println(JSONUtil.toJson(linkedList.get(1)));//输出2
        //linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        //System.out.println(JSONUtil.toJson(linkedList.get(1)));
        //返回3

    }
}
