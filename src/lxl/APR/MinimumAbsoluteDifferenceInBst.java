package lxl.APR;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-13 22:56
 **/
public class MinimumAbsoluteDifferenceInBst {
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

    public int getMinimumDifference(TreeNode root) {
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


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(2236);
        TreeNode treeNode3 = new TreeNode(1277);
        TreeNode treeNode4 = new TreeNode(2776);
        TreeNode treeNode5 = new TreeNode(519);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        MinimumAbsoluteDifferenceInBst min = new MinimumAbsoluteDifferenceInBst();
        System.out.println(min.getMinimumDifference(treeNode1));

    }

}
