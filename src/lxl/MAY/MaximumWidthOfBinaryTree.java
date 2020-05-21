package lxl.MAY;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * <p>
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * <p>
 * 注意: 答案在32位有符号整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-21 15:08
 **/
public class MaximumWidthOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<HelpTreeNode> queue = new LinkedList<>();
        int max = 0;
        queue.add(new HelpTreeNode(root, 0));
        while (!queue.isEmpty()) {
            max = Math.max(queue.getLast().offset - queue.getFirst().offset + 1, max);
            LinkedList<HelpTreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                HelpTreeNode nodehelp = queue.pollFirst();
                if (nodehelp.node.left != null) {
                    temp.add(new HelpTreeNode(nodehelp.node.left, nodehelp.offset * 2));
                }
                if (nodehelp.node.right != null) {
                    temp.add(new HelpTreeNode(nodehelp.node.right, nodehelp.offset * 2 + 1));
                }
            }
            queue.addAll(temp);
        }
        return max;
    }

    class HelpTreeNode {
        TreeNode node;
        int offset;

        HelpTreeNode(TreeNode n, int x) {
            node = n;
            offset = x;
        }
    }
}
