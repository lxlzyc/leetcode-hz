package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 13:38
 **/
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode less = new ListNode(x);
        ListNode lessNext = less;
        ListNode other = new ListNode(0);
        ListNode otherNext = other;
        ListNode next = head;
        ListNode help;
        while (next != null){
            help = next.next;
            next.next = null;
            if(next.val < x){
                lessNext.next = next;
                lessNext = lessNext.next;
            }else{
                otherNext.next = next;
                otherNext = otherNext.next;
            }
            next = help;
        }
        lessNext.next = other.next;
        return less.next;
    }

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        System.out.println(partitionList.partition(ListNodeTest.getListNode5(),3));
    }
}
