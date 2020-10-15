package lxl.OCT;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * <p>
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-15 15:39
 **/
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node = this.buildTree(nums, 0, nums.length - 1);
        return node;
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxOffset = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxOffset]) {
                maxOffset = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxOffset]);
        node.left = this.buildTree(nums, left, maxOffset - 1);
        node.right = this.buildTree(nums, maxOffset + 1, right);
        return node;
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(maximumBinaryTree.constructMaximumBinaryTree(nums));
    }
}
