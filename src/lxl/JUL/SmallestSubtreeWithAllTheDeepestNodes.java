package lxl.JUL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 865. 具有所有最深结点的最小子树
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * <p>
 * 我们返回值为 2 的结点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的结点。
 * 输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
 * 输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
 * 输入和输出都具有 TreeNode 类型。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点的数量介于 1 和 500 之间。
 * 每个结点的值都是独一无二的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-28 09:44
 **/
public class SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        SmallestSubtreeWithAllTheDeepestNodes smallestSubtreeWithAllTheDeepestNodes = new SmallestSubtreeWithAllTheDeepestNodes();

        System.out.println(smallestSubtreeWithAllTheDeepestNodes.subtreeWithAllDeepest(node3).val);
    }

    private List<Node> nodes;
    private int max;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        nodes = new ArrayList<>();
        max = 0;
        Node begin = new Node(root, null, 0);
        nodes.add(begin);
        this.dfsTree(begin);
        return this.getParentTreeNode(nodes);
    }

    private TreeNode getParentTreeNode(List<Node> nodes) {
        while (nodes.size() > 1) {
            Set<Node> temp = new HashSet<>();
            for (Node item : nodes) {
                temp.add(item.parent);
            }
            nodes.clear();
            nodes.addAll(temp);
        }
        return nodes.get(0).treeNode;
    }

    private void dfsTree(Node node) {
        TreeNode index = node.treeNode;
        if (index.left == null && index.right == null) {
            if (node.depth > max) {
                nodes.clear();
                nodes.add(node);
                max = node.depth;
            } else if (node.depth == max) {
                nodes.add(node);
            } else {
                return;
            }
        }
        if (index.left != null) {
            this.dfsTree(new Node(index.left, node, node.depth + 1));
        }
        if (index.right != null) {
            this.dfsTree(new Node(index.right, node, node.depth + 1));
        }
    }


    class Node {
        TreeNode treeNode;
        int depth;
        Node parent;

        public Node(TreeNode treeNode, Node parent, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
            this.parent = parent;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
