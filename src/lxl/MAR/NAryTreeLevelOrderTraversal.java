package lxl.MAR;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-23 13:44
 **/
public class NAryTreeLevelOrderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
    private List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return re;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        this.dealNodes(nodes);
        return re;
    }

    private void dealNodes(List<Node> nodes) {
        List<Node> nexts = new ArrayList<>();
        List<Integer> nodeList = new ArrayList<>();
        for (Node node : nodes) {
            nodeList.add(node.val);
            if (node.children != null) {
                nexts.addAll(node.children);
            }
        }
        re.add(nodeList);
        if (!nexts.isEmpty()) {
            this.dealNodes(nexts);
        }
    }

    public static void main(String[] args) {
        NAryTreeLevelOrderTraversal nAryTreeLevelOrderTraversal = new NAryTreeLevelOrderTraversal();
        Node base1 = new Node(1);
        Node base3 = new Node(3);
        Node base2 = new Node(2);
        Node base4 = new Node(4);
        Node base5 = new Node(5);
        Node base6 = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(base3);
        list1.add(base2);
        list1.add(base4);
        List<Node> list2 = new ArrayList<>();
        list2.add(base5);
        list2.add(base6);
        base1.children = list1;
        base3.children = list2;
        System.out.println(nAryTreeLevelOrderTraversal.levelOrder(base1));
    }
}
