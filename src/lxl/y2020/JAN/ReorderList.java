package lxl.y2020.JAN;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-03 10:19
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        ListNode next = head.next;
        ListNode help;
        while (next != null) {
            help = next;
            listNodes.add(help);
            next = next.next;
            help.next = null;
        }
        int left = 0;
        int right = listNodes.size() - 1;
        while (left < right) {
            //if(left<right){
            listNodes.get(left).next = listNodes.get(right);
            if (left + 1 < right) {
                listNodes.get(right).next = listNodes.get(left + 1);
            } else {
                break;
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode node = ListNodeTest.getListNode2();
        System.out.println("--" + node);
        reorderList.reorderList(node);
        System.out.println("--" + node);

    }

}
