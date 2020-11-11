package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 430. 扁平化多级双向链表
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-23 16:50
 **/
public class FlattenAMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }


        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + this.val + (this.next == null ? "" : (this.next.toString()));
        }
    }

    ;

    public Node flatten(Node head) {
        Node header = new Node();
        header.next = head;
        this.build(head, null);
        return header.next;
    }

    private void build(Node base, Node next) {
        if (base.next == null) {
            base.next = next;
            if (next != null) {
                next.prev = base;
                this.build(next, null);
            }
            return;
        }
        base = base.next;
        Node child = base.child;
        if (child != null) {
            child.prev = base;
            Node indexNext = base.next;
            base.next = child;
            base.child = null;
            if (indexNext != null) {
                indexNext.prev = null;
                build(indexNext, next);
            }

            build(base, indexNext);
        } else {
            build(base, next);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node11.next = node12;

        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        node8.prev = node7;
        node9.prev = node8;
        node12.prev = node11;

        node3.child = node7;
        node8.child = node11;
        System.out.println(node1.toString());

        FlattenAMultilevelDoublyLinkedList flattenAMultilevelDoublyLinkedList = new FlattenAMultilevelDoublyLinkedList();

        System.out.println(flattenAMultilevelDoublyLinkedList.flatten(node1).toString());
    }
}
