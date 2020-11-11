package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * <p>
 * 输出:
 * <p>
 * 2
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * <p>
 * 输出:
 * <p>
 * 2
 * <p>
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-03 15:28
 **/
public class LongestUnivaluePath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }


}
