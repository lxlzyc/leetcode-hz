package lxl.y2021.NOV;

import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-26 10:51
 **/
public class DeleteNodesAndReturnForest {

    public List<TreeNode> nodes;
    public Set<Integer> deleteNodes;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        nodes = new ArrayList<>();
        deleteNodes = new HashSet<>();
        for (int del : to_delete) {
            deleteNodes.add(del);
        }
        this.deleteNodes(root, null, true);
        return nodes;
    }

    private void deleteNodes(TreeNode root, TreeNode parent, boolean begin) {
        if (root == null) {
            return;
        }
        if (deleteNodes.isEmpty()) {
            if (begin) {
                nodes.add(root);
            }
            return;
        }
        if (deleteNodes.contains(root.val)) {
            //移除
            deleteNodes.remove(root.val);
            if (parent != null) {
                if (parent.left != null && parent.left.val == root.val) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            this.deleteNodes(root.left, root, true);
            this.deleteNodes(root.right, root, true);
        } else {
            if (begin) {
                nodes.add(root);
            }
            this.deleteNodes(root.left, root, false);
            this.deleteNodes(root.right, root, false);
        }
    }

    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7};
        TreeNode node = TreeNodeUtil.buildTreeNode(nodes);
        DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
        int[] delnodes = {3, 5};
        System.out.println(deleteNodesAndReturnForest.delNodes(node, delnodes));
    }
}
