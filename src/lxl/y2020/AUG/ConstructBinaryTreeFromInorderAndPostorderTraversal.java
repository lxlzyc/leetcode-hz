package lxl.y2020.AUG;

import lxl.util.JSONUtil;

import java.util.HashMap;

/**
 * @program: leetcode-hz
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
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
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-28 13:52
 **/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree2(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree2(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree2(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree2(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }

    private HashMap<Integer, Integer> help = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = postorder.length;
        if (l == 0) {
            return null;
        }
        for (int i = 0; i < l; i++) {
            help.put(inorder[i], i);
        }
        return this.build(postorder, 0, 0, l);
    }

    //中序 根据节点值，左边为左子节点，右边为右子节点。
    //后序的末尾 为当前节点 根据中序的分割成两部分
    private TreeNode build(int[] postorder, int inorderleft, int postorderleft, int length) {
        System.out.println("--" + inorderleft + "-" + postorderleft + "-" + length);
        if (length <= 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postorderleft + length - 1]);
        if (length == 1) {
            return treeNode;
        }
        int inorderOffset = help.get(treeNode.val);
        int leftLength = inorderOffset - inorderleft;
        int rightLength = inorderleft + length - inorderOffset - 1;
        //左子节点
        treeNode.left = this.build(postorder, inorderleft, postorderleft, leftLength);
        //右子节点
        treeNode.right = this.build(postorder, inorderOffset + 1, postorderleft + leftLength, rightLength);
        return treeNode;
    }


    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTreeFromInorderAndPostorderTraversal = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] nodes1 = {9, 3, 15, 20, 7};
        int[] nodes2 = {9, 15, 7, 20, 3};

        System.out.println(JSONUtil.toJson(constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(nodes1, nodes2)));
        System.out.println(JSONUtil.toJson(constructBinaryTreeFromInorderAndPostorderTraversal.buildTree2(nodes1, nodes2)));

    }

}
