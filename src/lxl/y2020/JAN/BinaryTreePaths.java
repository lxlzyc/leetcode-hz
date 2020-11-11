package lxl.y2020.JAN;

import lxl.util.JSONUtil;
import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-16 10:18
 **/
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        this.getTreePaths(root, re, "");
        return re;
    }

    private void getTreePaths(TreeNode root, List<String> re, String path) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                re.add(path);
                return;
            }
            path += "->";
            this.getTreePaths(root.left, re, path);
            this.getTreePaths(root.right, re, path);
        }
    }

    public static void main(String[] args) {
        Integer[] integer = {1, 2, 3, null, 5};
        TreeNode root = TreeNodeUtil.buildTreeNode(integer);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(JSONUtil.toJson(binaryTreePaths.binaryTreePaths(root)));
    }

}
