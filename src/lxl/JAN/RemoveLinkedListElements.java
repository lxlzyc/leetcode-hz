package lxl.JAN;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 15:12
 **/
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode help = new ListNode(0);
        help.next = head;
        head = help;
        while (head.next != null) {
            if (head.next.val == val) {
                if (head.next.next != null) {
                    head.next = head.next.next;
                } else {
                    head.next = null;
                    break;
                }
            } else {
                head = head.next;
            }
        }
        return help.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeTest.getListNode3();
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        System.out.println(removeLinkedListElements.removeElements(node, 4));
    }
}
