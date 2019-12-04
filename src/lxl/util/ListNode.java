package lxl.util;

/**
 * @program: leetcode-hz
 * @description: 节点
 * @author: lxl
 * @create: 2019-12-04 13:50
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val+"-"+ (next == null ? "end":next.toString());
    }
}
