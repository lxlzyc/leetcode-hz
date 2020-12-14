package lxl.y2019.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 25. K 个一组翻转链表
 * 题目描述
 * 评论 (332)
 * 题解(143)New
 * 提交记录
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author: lxl
 * @create: 2019-12-04 14:32
 **/
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode offset1 = zero;
        ListNode offset2;
        ListNode pre;
        ListNode next;
        ListNode reverse;
        // 1 找到k长度链表
        // 2 翻转链表
        // 3 拼接翻转链表
        int count = 0;
        while (true) {
            pre = offset1;

            offset1 = offset1.next;
            if (offset1 == null) {
                break;
            }
            count++;
            offset2 = offset1.next;
            if (offset2 == null) {
                break;
            }
            count++;
            while (count < k) {
                offset2 = offset2.next;
                if (offset2 == null) {
                    break;
                }
                count++;
            }
            if (offset2 == null) {
                break;
            }
            next = offset2.next;
            if (count == k) {
                // 前 pre；
                // 后 next;
                // 切断链表
                offset2.next = null;
                //翻转链表
                reverse = this.reverseLinkNode2(offset1);
                //拼回链表
                offset1.next = next;
                pre.next = reverse;
                //// 将当前节点的后一个节点指向前一个节点
                //currentNode.next = prevNode;
                //// 将前一个节点指向当前节点
                //prevNode = currentNode;
                //// 将当前节点指向后一个节点
                //currentNode = nextNode;

                count = 0;
            } else {
                break;
            }

        }
        return zero.next;
    }

    //翻转链表
    private void reverseLinkNode(ListNode pre) {
        System.out.println("pre=" + pre);
        Stack<ListNode> stack = new Stack<>();
        ListNode node = pre.next;
        ListNode clearNode;
        while (node != null) {
            clearNode = node;
            node = node.next;
            clearNode.next = null;
            stack.push(clearNode);
        }
        ListNode next = stack.pop();
        node = next;
        while (!stack.empty()) {
            node.next = stack.pop();
            node = node.next;
        }
        pre.next = next;
        System.out.println("end=" + pre);
    }

    //翻转链表2
    private ListNode reverseLinkNode2(ListNode head) {

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
        return reverseHead;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        System.out.println(reverseNodesInKGroup.reverseKGroup2(ListNodeTest.getListNode4(), 3));
        System.out.println(reverseNodesInKGroup.reverseKGroup(ListNodeTest.getListNode4(), 3));

    }

    //node1->node2->node3->node4->node5 3
    //base->node2->node1->node3...
    //base->node3->node2->node1->node4...
    //base->node3->node2->node1->node5->node4...

    public ListNode reverseKGroup2(ListNode head, int k) {
        //base节点
        ListNode base = new ListNode(0);
        ListNode pre = base;
        pre.next = head;
        ListNode index = head;
        int i = 0;
        while (index != null) {
            i++;
            if (i == k) {
                i = 0;
                ListNode next = index.next;
                index.next = null;
                ListNode[] re = this.reverseList(pre.next);
                pre.next = re[1];
                pre = re[0];
                pre.next = next;
                index = next;
            } else {
                index = index.next;
            }
        }
        return base.next;
    }

    //翻转链表
    public ListNode[] reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return new ListNode[]{head, prev};
    }

}
