package lxl.y2020.DEC;

import lxl.util.JSONUtil;
import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * <p>
 * 输出: [1,3,2]
 * @author: lxl
 * @create: 2019-12-24 14:09
 **/
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        re.addAll(this.inorderTraversal(root.left));
        re.add(root.val);
        re.addAll(this.inorderTraversal(root.right));
        return re;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println(JSONUtil.toJson(binaryTreeInorderTraversal.inorderTraversal(treeNode)));

    }
}
