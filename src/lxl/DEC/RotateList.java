package lxl.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

/**
 * @program: leetcode-hz
 * @description: 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-16 17:52
 **/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode nextNode = head;
        int count = 0;
        while (nextNode != null){
            count ++;
            if(nextNode.next == null){
                break;
            }
            nextNode = nextNode.next;
        }
        ListNode indexNode = first;
        if(k%count == 0){
            return head;
        }
        k = count - k%count;
        for (int i = 0; i < k; i++) {
            indexNode = indexNode.next;
        }
        ListNode beginNode = indexNode.next;
        indexNode.next = null;
        nextNode.next = head;
        return beginNode;

    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        System.out.println(rotateList.rotateRight(ListNodeTest.getListNode1(),11));
    }

}
