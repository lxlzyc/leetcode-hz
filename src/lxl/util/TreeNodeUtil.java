package lxl.util;

/**
 * @program: leetcode-hz
 * @description: 二叉树
 * @author: lxl
 * @create: 2019-12-24 14:10
 **/
public class TreeNodeUtil {
    public static TreeNode buildTreeNode(Integer[] nodes) {
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0, l = nodes.length; i < l; i++) {
            if (nodes[i] != null) {
                treeNodes[i] = new TreeNode(nodes[i]);
            }
        }
        for (int i = 1, l = nodes.length; i < l; i++) {
            TreeNode treeNode = treeNodes[i];
            if (treeNode != null) {
                treeNodes[(i - 1) / 2].left = treeNode;
                i++;
                if (i < l) {
                    treeNode = treeNodes[i];
                    if (treeNode != null) {
                        treeNodes[(i - 2) / 2].right = treeNode;
                    }
                }
            }
        }
        return treeNodes[0];
    }
}
