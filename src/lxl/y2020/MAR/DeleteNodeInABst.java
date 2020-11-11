package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-26 15:47
 **/
public class DeleteNodeInABst {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //删除节点后，把左子节提升为父节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            return this.getDelRoot(root);
        }
        TreeNode base = root;
        if (root.val > key) {
            this.checkRootLeft(root, key);
        } else {
            this.checkRootRight(root, key);
        }
        return base;
    }

    private void checkRootRight(TreeNode root, int key) {
        if (root.right == null) {
            return;
        }
        if (root.right.val == key) {
            root.right = this.getDelRoot(root.right);
            return;
        }
        if (root.right.val > key) {
            this.checkRootLeft(root.right, key);
        } else {
            this.checkRootRight(root.right, key);
        }
    }

    private void checkRootLeft(TreeNode root, int key) {
        if (root.left == null) {
            return;
        }
        if (root.left.val == key) {
            root.left = this.getDelRoot(root.left);
            return;
        }
        if (root.left.val > key) {
            this.checkRootLeft(root.left, key);
        } else {
            this.checkRootRight(root.left, key);
        }
    }


    private TreeNode getDelRoot(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode leftLast = this.getTreeNodeLeftLast(root.left);
            leftLast.right = root.right;
            return root.left;
        }
    }

    private TreeNode getTreeNodeLeftLast(TreeNode left) {
        if (left.right != null) {
            return this.getTreeNodeLeftLast(left.right);
        } else {
            return left;
        }
    }


    public static void main(String[] args) {
        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;
        System.out.println(deleteNodeInABst.deleteNode(treeNode3, 2));
    }
}
