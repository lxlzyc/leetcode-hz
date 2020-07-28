package lxl.JUL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode-hz
 * @description: 872. 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-28 14:33
 **/
public class LeafSimilarTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Queue<TreeNode> queue;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        queue = new LinkedList<>();
        this.dfsTreeNode(root1);
        return this.checkDfsTreeNode(root2);
    }

    private boolean checkDfsTreeNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (queue.isEmpty()) {
                return false;
            }
            return root.val == queue.poll().val;
        }
        boolean re = true;
        if (root.left != null) {
            re = this.checkDfsTreeNode(root.left);
        }
        if (re && root.right != null) {
            re = this.checkDfsTreeNode(root.right);
        }
        return re;
    }

    private void dfsTreeNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            queue.offer(root);
            return;
        }
        if (root.left != null) {
            this.dfsTreeNode(root.left);
        }
        if (root.right != null) {
            this.dfsTreeNode(root.right);
        }
    }

}
