package lxl.y2019.DEC;

import lxl.util.JSONUtil;
import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 10:27
 **/
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return this.levelOrderList(list,true);

    }

    private List<List<Integer>> levelOrderList(List<TreeNode> root,boolean flag) {
        if(root.isEmpty()){
            return new ArrayList<>();
        }
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        if(flag){
            for (TreeNode treeNode:root){
                list.add(treeNode.val);
                if(treeNode.left != null){
                    next.add(treeNode.left);
                }
                if(treeNode.right != null){
                    next.add(treeNode.right);
                }
            }
        }else{
            for (int i = root.size()-1; i >= 0 ; i--) {
                TreeNode treeNode = root.get(i);
                list.add(treeNode.val);
                if(treeNode.right != null){
                    next.add(treeNode.right);
                }
                if(treeNode.left != null){
                    next.add(treeNode.left);
                }
            }
            Collections.reverse(next);

        }
        flag = !flag;
        re.add(list);
        re.addAll(this.levelOrderList(next,flag));
        return re;
    }

    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,4,5,15,7};
        TreeNode treeNode = TreeNodeUtil.buildTreeNode(nodes);
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(JSONUtil.toJson(binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(treeNode)));
    }

}
