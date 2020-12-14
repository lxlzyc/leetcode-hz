package lxl.y2019.DEC;

/**
 * @program: leetcode-hz
 * @description: 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 15:11
 **/
public class PopulatingNextRightPointersInEachNode2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root != null) {
            this.connectNode(root.left, root.right);
        }
        return root;
    }

    private void connectNode(Node left, Node right) {
        if (left != null && right != null) {
            left.next = right;
            this.connectNode(left.left, left.right);

            this.connectNode(left.right == null ? left.left : left.right,
                    right.left == null ? right.right : right.left);

            this.connectNode(right.left, right.right);
        } else if (left != null) {
            this.connectNode(left.left, left.right);
        } else if (right != null) {
            this.connectNode(right.left, right.right);
        }

    }


}
