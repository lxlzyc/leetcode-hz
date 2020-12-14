package lxl.y2020.DEC;

import lxl.util.ListNode;

/**
 * @program: leetcode-hz
 * @description: 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * <p>
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-07 13:39
 **/
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        return this.getDecimal(head, 0);
    }

    private int getDecimal(ListNode head, int sum) {
        if (head == null) {
            return sum;
        }
        sum = sum * 2 + head.val;
        return this.getDecimal(head.next, sum);
    }
}
