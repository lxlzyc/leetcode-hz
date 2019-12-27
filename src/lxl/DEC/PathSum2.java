package lxl.DEC;

import lxl.util.TreeNode;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-27 14:35
 **/
public class PathSum2 {

    private List<List<Integer>> lists = new ArrayList<>();

    private Map<TreeNode,TreeNode> nodeMap = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        nodeMap.put(root,null);
        this.checkHasPathSum(root,sum,0);
        return lists;
    }
    private void checkHasPathSum(TreeNode root, int sum,int indexSum) {
        indexSum += root.val;
        if(root.left == null && root.right == null){
            if(indexSum == sum){
                lists.add(this.bulidPath(root));
            }
        }else{
            if(root.left != null){
                nodeMap.put(root.left,root);
                this.checkHasPathSum(root.left,sum,indexSum);
            }
            if(root.right != null){
                nodeMap.put(root.right,root);
                this.checkHasPathSum(root.right,sum,indexSum);
            }
        }
    }

    private List<Integer> bulidPath(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        while (true){
            list.addFirst(root.val);
            root = nodeMap.get(root);
            if(root == null){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
