package lxl.JAN;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 147. 对链表进行插入排序
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 10:35
 **/
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode base = new ListNode(Integer.MIN_VALUE);
        ListNode next = head.next;
        head.next = null;
        base.next = head;

        ListNode index;
        ListNode help;
        while (next != null) {
            help = next.next;
            next.next = null;
            index = base;
            while (true) {
                if (index.next != null) {
                    if (index.next.val >= next.val) {
                        break;
                    } else {
                        index = index.next;
                    }
                } else {
                    break;
                }
            }
            next.next = index.next;
            index.next = next;
            next = help;
        }
        return base.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode = ListNodeTest.getListNode5();
        System.out.println(insertionSortList.insertionSortList(listNode));
    }

}
