package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-03 11:12
 **/
public class ConvertSortedArrayToBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int right = nums.length - 1;
        TreeNode base = this.buildTreeNode(nums, 0, right);
        return base;
    }

    private TreeNode buildTreeNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode index = new TreeNode(nums[mid]);
        index.left = this.buildTreeNode(nums, left, mid - 1);
        index.right = this.buildTreeNode(nums, mid + 1, right);
        return index;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10, -3, -1, 0, 5, 6, 9};
        TreeNode node = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);
        System.out.println(node);
    }
}
