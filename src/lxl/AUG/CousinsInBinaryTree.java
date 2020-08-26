package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-26 13:51
 **/
public class CousinsInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        int parent;
        int depth;

        Node(int parent, int depth) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    private Node nodex;
    private Node nodey;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        nodex = null;
        nodey = null;
        this.build(root, 0, x, y);
        return nodex != null && nodey != null && nodex.depth == nodey.depth && nodex.parent != nodey.parent;
    }

    private void build(TreeNode root, int depth, int x, int y) {
        if (root.left != null) {
            if (root.left.val == x) {
                nodex = new Node(root.val, depth + 1);
                return;
            }
            if (root.left.val == y) {
                nodey = new Node(root.val, depth + 1);
                return;
            }
            this.build(root.left, depth + 1, x, y);
        }
        if (root.right != null) {
            if (root.right.val == x) {
                nodex = new Node(root.val, depth + 1);
                return;
            }
            if (root.right.val == y) {
                nodey = new Node(root.val, depth + 1);
                return;
            }
            this.build(root.right, depth + 1, x, y);
        }
    }
}
