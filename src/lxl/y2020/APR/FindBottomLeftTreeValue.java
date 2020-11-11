package lxl.y2020.APR;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 * <p>
 * <p>
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-15 21:17
 **/
public class FindBottomLeftTreeValue {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> treeNodes = new ArrayList<>();
    private TreeNode help;

    public int findBottomLeftValue(TreeNode root) {
        treeNodes.add(root);
        this.getBottomTreeNode();
        return help.val;
    }

    private void getBottomTreeNode() {
        if (treeNodes.isEmpty()) {
            return;
        }
        help = treeNodes.get(0);
        List<TreeNode> treeNodeHelp = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.left != null) {
                treeNodeHelp.add(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodeHelp.add(treeNode.right);
            }
        }
        treeNodes = treeNodeHelp;
        this.getBottomTreeNode();
    }
}
