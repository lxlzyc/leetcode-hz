package lxl.y2020.DEC;

import lxl.util.TreeNode;

import java.util.Arrays;

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
 * @create: 2019-12-27 11:28
 **/
public class ConstructBinaryTreeFromPreorderAInorder {
    //前序遍历就是首先根结点
    //中序遍历就是中间再访问根结点
    //后序遍历就是最后访问根结点！
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length <= 0) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            treeNodes[i] = new TreeNode(preorder[i]);
        }
        TreeNode base = treeNodes[0];
        //Arrays.binarySearch(inorder,preorder[0]);0
        this.bulidTree(0, treeNodes, preorder, inorder);
        return base;
    }

    private void bulidTree(int i, TreeNode[] treeNodes, int[] preorder, int[] inorder) {
        TreeNode base = treeNodes[i];
        if (base == null) {
            return;
        }
        //inorder baseOffset 左边是左节点 右边是右节点
        int baseOffset = Arrays.binarySearch(inorder, preorder[i]);
        if (baseOffset - 1 >= 0 && treeNodes[baseOffset - 1] != null) {
            base.left = treeNodes[baseOffset - 1];
        }
    }

    //private int[] getPreorder(TreeNode treeNode){
    //
    //}
    //private int[] getInorder(TreeNode treeNode){
    //
    //}
}
