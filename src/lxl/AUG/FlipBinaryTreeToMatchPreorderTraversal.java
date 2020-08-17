package lxl.AUG;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 971. 翻转二叉树以匹配先序遍历
 * 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
 * <p>
 * 通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 * <p>
 * 考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
 * <p>
 * （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
 * <p>
 * 我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。
 * <p>
 * 如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
 * <p>
 * 如果不能，则返回列表 [-1]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-17 14:07
 **/
public class FlipBinaryTreeToMatchPreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> changes;
    private int offset;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        changes = new ArrayList<>();
        offset = 0;

        this.checkTree(root, voyage);

        if (offset < voyage.length) {
            changes.clear();
            changes.add(-1);
        }
        return changes;
    }

    private boolean checkTree(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (offset >= voyage.length) {
            offset = -1;
            return false;
        }
        if (root.val != voyage[offset]) {
            return false;
        }
        offset++;
        int index = offset;
        boolean re = this.checkTree(root.left, voyage) && this.checkTree(root.right, voyage);
        if (!re) {
            changes.add(root.val);
            offset = index;
            re = this.checkTree(root.right, voyage) && this.checkTree(root.left, voyage);
        }
        return re;
    }

    public static void main(String[] args) {
        FlipBinaryTreeToMatchPreorderTraversal fi = new FlipBinaryTreeToMatchPreorderTraversal();
        int[] voyage = {1, 2, 4, 5, 7, 8, 3, 6};
        System.out.println(fi.flipMatchVoyage(fi.getNodes1(), voyage));
        //System.out.println(fi.flipMatchVoyage(root,voyage));

    }


    public TreeNode getNodes1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.right = node7;
        node5.left = node8;
        return node1;
    }
}
