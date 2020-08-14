package lxl.AUG;

import java.util.ArrayList;

/**
 * @program: leetcode-hz
 * @description: 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * <p>
 * 百度百科中对完全二叉树的定义如下：
 * <p>
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中将会有 1 到 100 个结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-14 14:04
 **/
public class CheckCompletenessOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ATreeNode {
        TreeNode treeNode;
        int value;

        ATreeNode(TreeNode treeNode, int value) {
            this.treeNode = treeNode;
            this.value = value;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        ArrayList<ATreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new ATreeNode(root, 1));
        int i = 0;
        while (i < treeNodes.size()) {
            ATreeNode atreeNode = treeNodes.get(i);
            if (atreeNode.treeNode != null) {
                treeNodes.add(new ATreeNode(atreeNode.treeNode.left, atreeNode.treeNode.val * 2));
                treeNodes.add(new ATreeNode(atreeNode.treeNode.right, atreeNode.treeNode.val * 2 + 1));
            }
            i++;
        }
        return treeNodes.get(i - 1).value == treeNodes.size();
    }

}
