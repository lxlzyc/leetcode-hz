package lxl.y2020.JAN;

import lxl.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 14:57
 **/
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        if (!set.isEmpty()) {
            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
        }
        return null;
    }
}
