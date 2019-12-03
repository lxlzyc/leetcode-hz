package lxl.DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-03 11:00
 **/
public class RemoveNthNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val+"-"+ (next == null ? "end":next.toString());
        }
    }
    //前后塞入null listnode处理特殊情况 单次遍历记录
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(null);
        nodes.add(head);
        ListNode next = head.next;
        while (next != null){
            nodes.add(next);
            next = next.next;
        }
        nodes.add(null);

        int size = nodes.size();

        int nOffset = size - n -1;

        ListNode re = nodes.get(nOffset-1);
        ListNode reNext = nodes.get(nOffset+1);

        if(re == null){
            return reNext;
        }else{
            re.next = reNext;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        ListNode a = new ListNode(1);
        //ListNode b = new ListNode(2);
        //ListNode c = new ListNode(3);
        //ListNode d = new ListNode(4);
        //ListNode e = new ListNode(5);
        //a.next = b;
        //b.next = c;
        //c.next = d;
        //d.next = e;
        System.out.println(removeNthNode.removeNthFromEnd(a,1));

    }

}
