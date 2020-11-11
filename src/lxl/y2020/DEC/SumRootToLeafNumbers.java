package lxl.y2020.DEC;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-30 17:01
 **/
public class SumRootToLeafNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        this.dealSum(root, 0);
        return sum;
    }

    private void dealSum(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        this.dealSum(root.left, num);
        this.dealSum(root.right, num);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        //TreeNode left1 = new TreeNode(4);
        //TreeNode right1 = new TreeNode(5);
        //left.left = left1;
        //left.right = right1;
        System.out.println(sumRootToLeafNumbers.sumNumbers(root));
    }

}
