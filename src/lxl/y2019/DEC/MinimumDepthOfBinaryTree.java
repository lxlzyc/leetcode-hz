package lxl.y2019.DEC;

import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

/**
 * @program: leetcode-hz
 * @description: 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 11:16
 **/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        Integer min = null;
        min = this.getMin(root,min,0);
        return min == null?0:min;
    }

    private Integer getMin(TreeNode root, Integer min, int length) {
        if(root == null){
            return min;
        }
        length ++;
        if(root.left == null && root.right == null){
            if(min != null){
                min = Math.min(min,length);
            }else{
                min = length;
            }
        }else{
            if(root.left != null){
                min = this.getMin(root.left,min,length);
            }
            if(root.right != null){
                min = this.getMin(root.right,min,length);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree maximumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        Integer[] nodes = {1,2,3,4,5};
        TreeNode treeNode = TreeNodeUtil.buildTreeNode(nodes);
        System.out.println(maximumDepthOfBinaryTree.minDepth(treeNode));
    }
}
