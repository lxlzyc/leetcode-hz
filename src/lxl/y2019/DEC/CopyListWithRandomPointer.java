package lxl.y2019.DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-31 14:07
 **/
public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        List<Node> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        List<Node> nodesClone = new ArrayList<>();
        for (Node node : nodes) {
            nodesClone.add(new Node(node.val));
        }
        for (int i = 0, l = nodes.size(); i < l; i++) {
            Node index = nodesClone.get(i);
            if (i + 1 < nodes.size()) {
                index.next = nodesClone.get(i + 1);
            }
            Node random = nodes.get(i).random;
            if (random != null) {
                index.random = nodesClone.get(nodes.indexOf(random));
            }
        }
        return nodesClone.get(0);
    }

}
