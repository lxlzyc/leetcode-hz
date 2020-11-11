package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-19 15:12
 **/
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode index = head.next;
        if (index == null) {
            return head;
        }
        ListNode pre = head;
        int oldval = head.val;
        while (true) {
            if (index.val != oldval) {
                if (index.next == null) {
                    break;
                }
                oldval = index.val;
                pre = index;
                index = index.next;
            } else {
                if (index.next == null) {
                    pre.next = null;
                    break;
                } else {
                    pre.next = index.next;
                    index = pre.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        System.out.println(ListNodeTest.getListNode3().toString());
        System.out.println(removeDuplicatesFromSortedList.deleteDuplicates(ListNodeTest.getListNode3()).toString());
    }

}
