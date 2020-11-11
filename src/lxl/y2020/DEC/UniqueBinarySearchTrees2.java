package lxl.y2020.DEC;

import lxl.util.JSONUtil;
import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
 * 或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 * @author: lxl
 * @create: 2019-12-24 14:19
 **/
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> re = new ArrayList<>();
        for (int i = 3; i < n; i++) {
            re.addAll(this.buildTreeNode(i, 0, n - 1));
        }
        return re;
    }

    public List<TreeNode> buildTreeNode(int index, int left, int right) {
        List<TreeNode> re = new ArrayList<>();
        List<TreeNode> lefts = new ArrayList<>();
        for (int i = index - 1; i >= 0; i--) {
            //构建左子节点
            lefts = this.buildTreeNode(i, left, i);
        }
        System.out.println("index == " + index + "-" + left + "-" + right + "|left = " + JSONUtil.toJson(lefts));
        List<TreeNode> rights = new ArrayList<>();
        //for (int i = index + 1; i <= right; i++) {
        //    //构建右子节点
        //    rights = this.buildTreeNode(i, i, right);
        //}
        //System.out.println("index == " + index + "-" + left + "-" + right + "| right =" + JSONUtil.toJson(rights));

        if (lefts.isEmpty() && rights.isEmpty()) {
            re.add(new TreeNode(index + 1));
            return re;
        }
        if (lefts.size() <= 0) {
            for (TreeNode treeNode : rights) {
                TreeNode indexTree = new TreeNode(index + 1);
                indexTree.right = treeNode;
                re.add(indexTree);
            }
            return re;
        }
        if (rights.size() <= 0) {
            for (TreeNode treeNode : lefts) {
                TreeNode indexTree = new TreeNode(index + 1);
                indexTree.left = treeNode;
                re.add(indexTree);
            }
            return re;

        }
        for (TreeNode treeNodeRight : rights) {
            for (TreeNode treeNodeLeft : lefts) {
                TreeNode indexTree = new TreeNode(index + 1);
                indexTree.right = treeNodeRight;
                indexTree.left = treeNodeLeft;
                re.add(indexTree);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 uniqueBinarySearchTrees2 = new UniqueBinarySearchTrees2();
        List<TreeNode> treeNodes = uniqueBinarySearchTrees2.generateTrees(5);
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        for (TreeNode node : treeNodes) {
            System.out.println(binaryTreeInorderTraversal.inorderTraversal(node));
        }
    }
}
