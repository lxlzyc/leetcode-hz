package lxl.y2020.JAN;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 11:37
 **/
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = this.invertTree(right);
        root.right = this.invertTree(left);
        return root;
    }


}
