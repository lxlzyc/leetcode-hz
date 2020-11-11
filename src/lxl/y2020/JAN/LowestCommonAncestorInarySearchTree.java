package lxl.y2020.JAN;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 14:36
 **/
public class LowestCommonAncestorInarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return this.getlowestCommonAncestor(root, q, p);
        } else {
            return this.getlowestCommonAncestor(root, p, q);

        }
    }

    private TreeNode getlowestCommonAncestor(TreeNode root, TreeNode q, TreeNode p) {
        return root;
    }
}
