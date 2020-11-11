package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * <p>
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * <p>
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * <p>
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * <p>
 * 返回 false。
 * @author: lxl
 * @create: 2020-04-23 10:48
 **/
public class SubtreeOfAnotherTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return this.treeEquals(s, t);
    }

    private boolean treeEquals(TreeNode s, TreeNode t) {
        return s != null && (equal(s, t) || treeEquals(s.left, t) || treeEquals(s.right, t));

    }

    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }

}
