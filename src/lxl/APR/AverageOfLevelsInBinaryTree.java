package lxl.APR;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * <p>
 * 注意：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-30 10:51
 **/
public class AverageOfLevelsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Double> index = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return index;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        this.dealAverageOfLevels(nodes);
        return index;
    }

    private void dealAverageOfLevels(List<TreeNode> nodes) {
        double sum = 0d;
        List<TreeNode> next = new ArrayList<>();
        for (TreeNode node : nodes) {
            sum += node.val;
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
        }
        index.add(sum / nodes.size());
        if (!next.isEmpty()) {
            this.dealAverageOfLevels(next);
        }
    }

}
