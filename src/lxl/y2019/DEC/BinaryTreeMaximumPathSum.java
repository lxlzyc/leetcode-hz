package lxl.y2019.DEC;

import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

/**
 * @program: leetcode-hz
 * @description: 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 14:10
 **/
public class BinaryTreeMaximumPathSum {
    private Integer max = 0;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        this.rebuildMaxBase(root);
        return max;
    }

    private int rebuildMaxBase(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(this.rebuildMaxBase(root.left), 0);
        int maxRight = Math.max(this.rebuildMaxBase(root.right), 0);
        max = Math.max(root.val + maxLeft + maxRight, max);
        root.val += Math.max(maxLeft, maxRight);
        return root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(TreeNodeUtil.buildTreeNode(nums)));
    }

}
