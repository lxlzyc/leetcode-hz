package lxl.DEC;

import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-24 16:52
 **/
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<List<Integer>> re = this.levelOrderList(list);
        Collections.reverse(re);
        return re;

    }

    private List<List<Integer>> levelOrderList(List<TreeNode> root) {
        if(root.isEmpty()){
            return new ArrayList<>();
        }
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        for (TreeNode treeNode:root){
            list.add(treeNode.val);
            if(treeNode.left != null){
                next.add(treeNode.left);
            }
            if(treeNode.right != null){
                next.add(treeNode.right);
            }
        }
        re.add(list);
        re.addAll(this.levelOrderList(next));
        return re;
    }

    public static void main(String[] args) {

    }

}
