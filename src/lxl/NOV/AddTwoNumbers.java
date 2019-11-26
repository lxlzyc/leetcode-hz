package lxl.NOV;

/**
 * @program: leetcode-hz
 * @description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-26 14:33
 **/
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //数学加法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val+l2.val;
        int nextVal = sum/10;
        ListNode re = new ListNode(nextVal>0?(sum-10):sum);
        ListNode nextl1 = l1.next;
        ListNode nextl2 = l2.next;
        ListNode nextNode = re;
        while (nextl1 != null || nextl2 != null) {
            if(nextl1 == null){
                if(nextVal>0){
                    nextl1 = new ListNode(0);
                }else{
                    nextNode.next = nextl2;
                    break;
                }
            }
            if(nextl2 == null){
                if(nextVal>0){
                    nextl2 = new ListNode(0);
                }else{
                    nextNode.next = nextl1;
                    break;
                }
            }
            sum = nextl1.val+nextl2.val+nextVal;
            nextVal = sum/10;
            nextNode.next = new ListNode(nextVal>0?(sum-10):sum);
            nextNode = nextNode.next;
            nextl1 = nextl1.next;
            nextl2 = nextl2.next;

        }
        if(nextVal>0){
            nextNode.next = new ListNode(nextVal);
        }
        return re;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(4);
        //ListNode a3 = new ListNode(3);
        a1.next = a2;
        //a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(a1, b1));
    }

}
