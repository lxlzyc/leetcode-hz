package lxl.FEB;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @author: lxl
 * @create: 2020-02-25 20:16
 **/
public class SumOfLeftLeaves {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        sum = 0;
        this.getSumLeft(root.left);
        this.getSumRight(root.right);
        return sum;
    }

    private void getSumRight(TreeNode root) {
        if (root == null) {
            return;
        }
        this.getSumLeft(root.left);
        this.getSumRight(root.right);
    }

    private void getSumLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        this.getSumLeft(root.left);
        this.getSumRight(root.right);
    }


}
