package lxl.APR;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-15 21:25
 **/
public class FindLargestValueInEachTreeRow {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> treeNodes = new ArrayList<>();
    private List<Integer> maxList = new ArrayList<>();

    private void getBottomTreeNode() {
        if (treeNodes.isEmpty()) {
            return;
        }
        Integer max = treeNodes.get(0).val;
        List<TreeNode> treeNodeHelp = new ArrayList<>();
        for (int i = 0, l = treeNodes.size(); i < l; i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (treeNode.left != null) {
                treeNodeHelp.add(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodeHelp.add(treeNode.right);
            }
            max = Math.max(treeNode.val, max);

        }
        maxList.add(max);
        treeNodes = treeNodeHelp;
        this.getBottomTreeNode();
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return maxList;
        }
        treeNodes.add(root);
        this.getBottomTreeNode();
        return maxList;
    }
}
