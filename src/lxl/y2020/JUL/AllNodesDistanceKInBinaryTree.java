package lxl.y2020.JUL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-27 14:00
 **/
public class AllNodesDistanceKInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, TreeNode> parents;
    private List<Integer> nodes;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parents = new HashMap<>();
        nodes = new ArrayList<>();
        this.buildParent(root);
        this.buildNodes(target, -1, K);
        return nodes;
    }

    private void buildNodes(TreeNode target, int pre, int k) {
        if (target == null) {
            return;
        }
        //距离0
        if (k == 0) {
            nodes.add(target.val);
            return;
        }
        int indexVal = target.val;
        //父节点
        TreeNode parent = parents.get(indexVal);
        if (parent != null && parent.val != pre) {
            this.buildNodes(parent, indexVal, k - 1);
        }
        //左子节点
        if (target.left != null && target.left.val != pre) {
            this.buildNodes(target.left, indexVal, k - 1);
        }
        //右子节点
        if (target.right != null && target.right.val != pre) {
            this.buildNodes(target.right, indexVal, k - 1);
        }
    }

    private void buildParent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left.val, root);
            this.buildParent(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            this.buildParent(root.right);
        }
    }
}
