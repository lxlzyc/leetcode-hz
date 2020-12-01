package lxl.y2021.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-01 10:04
 **/
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode base = new ListNode(0);
        Stack<ListNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        Set<Integer> offsets = new HashSet<>();
        base.next = head;
        ListNode pre = base;
        nodes.push(base);
        while (pre.next != null) {
            ListNode next = pre.next;
            if (next.val == 0) {
                pre.next = next.next;
                continue;
            }
            if (sums.isEmpty()) {
                sums.push(next.val);
                nodes.push(next);
                pre = next;
                offsets.add(next.val);
                continue;
            }
            int indexSum = sums.peek() + next.val;
            if (offsets.contains(indexSum)) {
                //总和重复，删除中间部分
                while (sums.peek() != indexSum) {
                    int pop = sums.pop();
                    nodes.pop();
                    offsets.remove(pop);
                }
                nodes.peek().next = next.next;
                pre = nodes.peek();
            } else if (indexSum == 0) {
                //总和为0 清空
                sums.clear();
                nodes.clear();
                offsets.clear();
                nodes.push(base);
                nodes.peek().next = next.next;
                pre = nodes.peek();
            } else {
                nodes.push(next);
                sums.push(indexSum);
                offsets.add(indexSum);
                pre = next;
            }
        }
        return base.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesFromLinkedList remove = new RemoveZeroSumConsecutiveNodesFromLinkedList();

        System.out.println(remove.removeZeroSumSublists(ListNodeTest.getListNode3()));
    }
}
