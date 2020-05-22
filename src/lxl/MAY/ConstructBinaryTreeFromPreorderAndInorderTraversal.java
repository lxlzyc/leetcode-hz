package lxl.MAY;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-22 13:39
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> indexMap;
    private int max;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        max = preorder.length - 1;
        for (int i = 0; i <= max; i++) {
            indexMap.put(inorder[i], i);
        }
        return this.buildTreeInner(preorder, inorder, 0, max, 0, max);
    }

    private TreeNode buildTreeInner(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        int pre_root = preleft;
        int inorderIndex = indexMap.get(preorder[pre_root]);
        //根节点
        TreeNode base = new TreeNode(preorder[pre_root]);
        int size_left_subtree = inorderIndex - inleft;
        //左子树
        base.left = this.buildTreeInner(preorder, inorder, preleft + 1, preleft + size_left_subtree,
                inleft, inorderIndex - 1
        );
        base.right = this.buildTreeInner(preorder, inorder, preleft + size_left_subtree + 1, preright,
                inorderIndex + 1, inright
        );
        return base;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 9, 20, 15, 7};
        int[] nums2 = {9, 3, 15, 20, 7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(nums1, nums2));
    }
}
