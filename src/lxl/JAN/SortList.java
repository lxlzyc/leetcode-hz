package lxl.JAN;

import lxl.util.ListNode;

/**
 * @program: leetcode-hz
 * @description: 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 11:23
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return this.sortListInner(head);
    }

    private ListNode sortListInner(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode offset1 = head;
        ListNode offset2 = head;
        ListNode pre = null;
        while (offset2 != null && offset2.next != null) {
            pre = offset1;
            offset1 = offset1.next;
            offset2 = offset2.next.next;
        }
        pre.next = null;
        ListNode l = sortListInner(head);
        ListNode r = sortListInner(offset1);
        return mergeTwoLists(l, r);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode next = listNode;
        while (true) {
            if (l1 == null) {
                next.next = l2;
                break;
            }
            if (l2 == null) {
                next.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            } else {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            }
        }
        return listNode.next;
    }
}
