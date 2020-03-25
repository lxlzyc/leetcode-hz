package lxl.MAR;

import lxl.util.ListNode;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * <p>
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * @author: lxl
 * @create: 2020-03-25 10:20
 **/
public class AddTwoNumbersii {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int ten = 0;
        int count;
        int stack1num;
        int stack2num;
        ListNode next = null;
        ListNode index = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                stack1num = 0;
            } else {
                stack1num = stack1.pop();
            }
            if (stack2.isEmpty()) {
                stack2num = 0;
            } else {
                stack2num = stack2.pop();
            }
            count = stack1num + stack2num + ten;
            if (count > 0) {
                ten = 1;
                count -= 10;
            } else {
                ten = 0;
            }
            index = new ListNode(count);
            index.next = next;
            next = index;
        }
        if (ten > 0) {
            index = new ListNode(ten);
            index.next = next;
        }
        return index;
    }

    public static void main(String[] args) {

    }

}
