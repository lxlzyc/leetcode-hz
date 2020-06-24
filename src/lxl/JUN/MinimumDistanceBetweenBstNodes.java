package lxl.JUN;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 783. 二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-24 10:21
 **/
public class MinimumDistanceBetweenBstNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<Integer> vals = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.getAllVals(root);
        return min;
    }

    private void getAllVals(TreeNode root) {
        if (root == null) {
            return;
        }
        this.getAllVals(root.left);
        if (!vals.isEmpty()) {
            min = Math.min(min, Math.abs(root.val - vals.peek()));
        }
        if (min == 0) {
            return;
        }
        vals.push(root.val);
        this.getAllVals(root.right);
    }

}
