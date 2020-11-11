package lxl.y2020.JUL;

import java.util.ArrayList;

/**
 * @program: leetcode-hz
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-03 16:04
 **/
public class ReversePrint {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> stack = new ArrayList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] re = new int[stack.size()];
        for (int i = 0, l = stack.size(); i < l; i++) {
            re[i] = stack.get(l - i - 1);
        }
        return re;
    }

}
