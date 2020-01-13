package lxl.JAN;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 14:26
 **/
public class PalindromeLinkedList {
    //快慢指针加栈
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.push(head.val);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.val);
        }
        if (fast.next == null) {
            stack.pop();
        }
        while (!stack.empty()) {
            if (stack.pop() != slow.next.val) {
                return false;
            } else {
                slow = slow.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(ListNodeTest.getListNode4()));
    }

}
