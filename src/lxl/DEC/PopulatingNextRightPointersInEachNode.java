package lxl.DEC;

/**
 * @program: leetcode-hz
 * @description: 116. 填充每个节点的下一个右侧节点指针
 * @author: lxl
 * @create: 2019-12-27 15:11
 **/
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root != null){
            this.connectNode(root.left,root.right);
        }
        return root;
    }

    private void connectNode(Node left, Node right) {
        if(left == null){
            return;
        }
        left.next = right;
        this.connectNode(left.left,left.right);
        this.connectNode(left.right,right.left);
        this.connectNode(right.left,right.right);
    }


}
