package lxl.y2020.APR;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * <p>
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-14 22:45
 **/
public class ConvertBstToGreaterTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack = new Stack<>();

    public TreeNode convertBST(TreeNode root) {
        this.dealRoot(root);
        int count = 0;
        while (stack.isEmpty()) {
            TreeNode help = stack.pop();
            help.val += count;
            count = help.val;
        }
        return root;
    }

    private void dealRoot(TreeNode root) {
        if (root == null) {
            return;
        }
        this.dealRoot(root.left);
        stack.push(root);
        this.dealRoot(root.right);

    }

}
