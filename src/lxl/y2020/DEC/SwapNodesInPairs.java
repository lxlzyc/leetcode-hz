package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-04 13:49
 **/
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode next1 = zero;
        ListNode next2;
        ListNode help;
        while (true) {
            help = next1;
            next1 = next1.next;
            if (next1 == null) {
                break;
            }
            next2 = next1.next;
            if (next2 == null) {
                break;
            }
            //都不为null 交换两个值
            next1.next = next2.next;// 1 node 连到2next// 上
            next2.next = next1;// 2 node 连到1
            help.next = next2;
        }
        return zero.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        System.out.println(swapNodesInPairs.swapPairs(ListNodeTest.getListNode1()));
    }

}
