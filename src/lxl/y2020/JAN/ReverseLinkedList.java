package lxl.y2020.JAN;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 16:12
 **/
public class ReverseLinkedList {

    //public ListNode reverseList(ListNode head) {
    //    if (head == null || head.next == null) {
    //        return head;
    //    }
    //    ListNode base = new ListNode(0);
    //    ListNode pre = null;
    //    ListNode index = head;
    //    ListNode next;
    //    while (index != null) {
    //        next = index.next;
    //        if (next == null) {
    //            base.next = index;
    //        }
    //        index.next = pre;
    //        pre = index;
    //        index = next;
    //    }
    //    return base.next;
    //}

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(reverseLinkedList.reverseList(ListNodeTest.getListNode3()));
    }

    //翻转 node1 -> node2 -> node3 -> node4
    //翻转节点i至头节点。一次。
    // node2->node1->node3->node4
    //二次翻转
    // node3->node2->node1->node4
    //三次翻转
    // node4->node3->node2->node1
    // base->node4
    private ListNode reverseList(ListNode head) {
        //翻转链表
        ListNode base = new ListNode(0);
        ListNode index = head;
        ListNode next;
        ListNode pre = null;
        while (index != null) {
            next = index.next;
            //到结尾的时候，绑定到base节点上
            if (next == null) {
                base.next = index;
            }
            //翻转
            index.next = pre;
            pre = index;
            //处理后续
            index = next;

        }
        return base.next;
    }

}
