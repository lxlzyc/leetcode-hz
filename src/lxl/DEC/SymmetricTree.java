package lxl.DEC;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @author: lxl
 * @create: 2019-12-24 16:45
 **/
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return this.isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        if(this.isSymmetric(left.left,right.right)){
            if(this.isSymmetric(left.right,right.left)){
                return true;
            }
        }
        return false;
    }


}
