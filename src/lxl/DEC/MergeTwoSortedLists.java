package lxl.DEC;

import lxl.util.ListNode;

/**
 * @program: leetcode-hz
 * @description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-03 15:41
 **/
public class MergeTwoSortedLists {
    //static class ListNode {
    //    int val;
    //    ListNode next;
    //
    //    ListNode(int x) {
    //        val = x;
    //    }
    //
    //    @Override
    //    public String toString() {
    //        return val+"-"+ (next == null ? "end":next.toString());
    //    }
    //}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode next = listNode;
        while (true){
            if(l1 == null){
                next.next = l2;
                break;
            }
            if(l2 == null){
                next.next = l1;
                break;
            }
            if(l1.val<=l2.val){
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            }else{
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            }
        }
        return listNode.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }


    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode a1 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(6);
        ListNode e1 = new ListNode(7);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        System.out.println(mergeTwoSortedLists.mergeTwoLists(a,a1).toString());
    }
}
