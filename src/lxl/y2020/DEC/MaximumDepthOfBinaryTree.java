package lxl.y2020.DEC;

import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

/**
 * @program: leetcode-hz
 * @description: 104. 二叉树的最大深度
 * @author: lxl
 * @create: 2019-12-27 11:16
 **/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int max = 0;
        max = this.getMax(root,max,0);
        return max;
    }

    private int getMax(TreeNode root, int max, int length) {
        if(root == null){
            return max;
        }
        length ++;
        max = Math.max(length,max);
        max = this.getMax(root.left,max,length);
        max = this.getMax(root.right,max,length);
        return max;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        Integer[] nodes = {3,9,20,4,null,15,7,null,0};
        TreeNode treeNode = TreeNodeUtil.buildTreeNode(nodes);
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNode));
    }
}
