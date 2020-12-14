package lxl.y2019.DEC;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-24 16:06
 **/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean re = false;
        if (root.left != null) {
            if (root.val <= root.left.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentLeft(root.left, root.val);
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentRight(root.right, root.val);
            }
        }
        return re;
    }

    public boolean isValidBSTWithParentRight(TreeNode root, int parent) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean re = false;
        if (root.left != null) {
            if (root.val <= root.left.val || parent >= root.left.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentLeft(root.left, root.val);
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val || parent >= root.right.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentRight(root.right, root.val);
            }
        }
        return re;
    }

    public boolean isValidBSTWithParentLeft(TreeNode root, int parent) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean re = false;
        if (root.left != null) {
            if (root.val <= root.left.val || parent <= root.left.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentLeft(root.left, root.val);
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val || parent <= root.right.val) {
                return false;
            } else {
                re = this.isValidBSTWithParentRight(root.right, root.val);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);


        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        System.out.println(validateBinarySearchTree.isValidBST(treeNode));

    }
}
