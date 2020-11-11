package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 15:18
 **/
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode help = new ListNode(0);
        help.next = head;
        int count = 0;
        ListNode start = help;
        ListNode begin = null;
        ListNode end;
        while (head != null) {
            count++;
            if (count < m) {
                start = start.next;
            } else if (count == m) {
                start.next = null;
                begin = head;
            } else if (count == n) {
                end = head.next;
                head.next = null;
                this.reverseLinkNode(start, begin, end);
                break;
            }
            head = head.next;
        }
        return help.next;
    }

    //翻转链表
    private void reverseLinkNode(ListNode start, ListNode head, ListNode end) {
        ListNode reverseHead = null;
        // 指针1：当前节点
        ListNode currentNode = head;
        // 指针2：当前节点的前一个节点
        ListNode prevNode = null;
        // 指针3：当前节点的后一个节点
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            if (nextNode == null) {
                reverseHead = currentNode;
            }
            // 将当前节点的后一个节点指向前一个节点
            currentNode.next = prevNode;
            // 将前一个节点指向当前节点
            prevNode = currentNode;
            // 将当前节点指向后一个节点
            currentNode = nextNode;
        }
        start.next = reverseHead;
        head.next = end;
    }

    public static void main(String[] args) {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        System.out.println(reverseLinkedList2.reverseBetween(ListNodeTest.getListNode1(), 1, 2));
    }

}
