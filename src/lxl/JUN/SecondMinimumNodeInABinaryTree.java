package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   2
 * <p>
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-02 11:27
 **/
public class SecondMinimumNodeInABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] min = new int[2];

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        min[0] = root.val;
        min[1] = -1;
        this.findSecondMin(root.left);
        this.findSecondMin(root.right);
        return min[1];
    }

    private void findSecondMin(TreeNode node) {
        if (node == null) {
            return;
        }
        if (min[1] >= 0) {
            if (node.val == min[0]) {
                this.findSecondMin(node.left);
                this.findSecondMin(node.right);
            } else if (node.val < min[1]) {
                min[1] = node.val;
            }
        } else if (node.val > min[0]) {
            min[1] = node.val;
        } else {
            this.findSecondMin(node.left);
            this.findSecondMin(node.right);
        }
    }

    public static void main(String[] args) {
        SecondMinimumNodeInABinaryTree secondMinimumNodeInABinaryTree = new SecondMinimumNodeInABinaryTree();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(5);
        System.out.println(secondMinimumNodeInABinaryTree.findSecondMinimumValue(treeNode));
    }

}
