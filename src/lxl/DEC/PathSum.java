package lxl.DEC;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 14:35
 **/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return this.checkHasPathSum(root,sum,0);
    }
    private boolean checkHasPathSum(TreeNode root, int sum,int indexSum) {
        indexSum += root.val;
        if(root.left == null && root.right == null){
            return indexSum == sum;
        }else{
            boolean re = false;
            if(root.left != null){
                re = this.checkHasPathSum(root.left,sum,indexSum);
            }
            if(re){
                return re;
            }
            if(root.right != null){
                re = this.checkHasPathSum(root.right,sum,indexSum);
            }
            return re;
        }
    }

    public static void main(String[] args) {

    }
}
