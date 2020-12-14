package lxl.y2019.DEC;

import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-24 16:52
 **/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return this.levelOrderList(list);

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
