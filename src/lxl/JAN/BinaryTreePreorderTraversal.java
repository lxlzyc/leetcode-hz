package lxl.JAN;

import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-06 10:18
 **/
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(this.preorderTraversal2(root.left));
        list.addAll(this.preorderTraversal2(root.right));
        return list;
    }
}
