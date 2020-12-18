package lxl.y2020.DEC;

import lxl.util.ListNode;

/**
 * @program: leetcode-hz
 * @description: 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * <p>
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-18 10:59
 **/
public class KthNodeFromEndOfListLcci {

    public int kthToLast(ListNode head, int k) {
        ListNode help = head;
        while (head != null) {
            head = head.next;
            if (k == 0) {
                help = help.next;
            } else {
                k--;
            }
        }
        return help.val;
    }

}
