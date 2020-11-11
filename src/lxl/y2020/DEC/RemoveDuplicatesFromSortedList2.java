package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-19 15:12
 **/
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode base = new ListNode(head.val > 0 ? head.val - 1 : head.val + 1);
        base.next = head;
        ListNode index = base;
        ListNode next;
        while (index != null && index.next != null) {
            next = index.next;
            int val = next.val;
            boolean same = false;
            while (next.next != null) {
                if (next.next.val == val) {
                    same = true;
                    next = next.next;
                } else {
                    break;
                }
            }
            System.out.println(next);
            if (same) {
                index.next = next.next;
            } else {
                index.next = next;
                index = index.next;
            }
        }
        return base.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        System.out.println(ListNodeTest.getListNode3());
        System.out.println(removeDuplicatesFromSortedList2.deleteDuplicates(ListNodeTest.getListNode3()));
    }

}
