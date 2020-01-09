package lxl.JAN;

import lxl.util.JSONUtil;
import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-09 13:46
 **/
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return this.dealRightSideView(list);
    }

    private List<Integer> dealRightSideView(List<TreeNode> root) {
        if (root.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> re = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        for (int i = 0, l = root.size(); i < l; i++) {
            TreeNode treeNode = root.get(i);
            list.add(treeNode.val);
            if (treeNode.right != null) {
                next.add(treeNode.right);
            }
            if (treeNode.left != null) {
                next.add(treeNode.left);
            }
        }
        re.add(list.get(0));
        re.addAll(this.dealRightSideView(next));
        return re;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2};
        TreeNode treeNode = TreeNodeUtil.buildTreeNode(nums);
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        System.out.println(JSONUtil.toJson(binaryTreeRightSideView.rightSideView(treeNode)));
    }
}
