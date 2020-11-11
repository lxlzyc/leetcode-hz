package lxl.util;

/**
 * @program: leetcode-hz
 * @description: 二叉树
 * @author: lxl
 * @create: 2019-12-24 14:10
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
