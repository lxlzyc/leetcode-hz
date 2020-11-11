package lxl.y2020.MAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * <p>
 * 下面是两个重复的子树：
 * <p>
 * 2
 * /
 * 4
 * <p>
 * 和
 * <p>
 * 4
 * <p>
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-07 14:06
 **/
public class FindDuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> duplicateNode;
    private Map<String, Integer> treeNodeMap;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        duplicateNode = new ArrayList<>();
        treeNodeMap = new HashMap<>();
        this.collect(root);
        return duplicateNode;
    }

    private String collect(TreeNode root) {
        if (root == null) {
            return "n";
        }
        String serial = root.val + "," + this.collect(root.left) + "," + this.collect(root.right);
        treeNodeMap.put(serial, treeNodeMap.getOrDefault(serial, 0) + 1);
        if (treeNodeMap.get(serial) == 2) {
            duplicateNode.add(root);
        }
        return serial;
    }
}
