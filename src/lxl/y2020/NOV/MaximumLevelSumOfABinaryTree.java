package lxl.y2020.NOV;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-30 09:56
 **/
public class MaximumLevelSumOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = 1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int maxSum = Integer.MIN_VALUE;
        int maxI = 0;
        while (!stack.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            int indexSum = 0;
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                indexSum += treeNode.val;
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            if (indexSum > maxSum) {
                maxSum = indexSum;
                maxI = i;
            }
            i++;
            stack.addAll(next);
        }
        return maxI;
    }
}
