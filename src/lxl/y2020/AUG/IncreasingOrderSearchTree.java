package lxl.y2020.AUG;

/**
 * @program: leetcode-hz
 * @description: 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-03 17:14
 **/
public class IncreasingOrderSearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode index;
    private TreeNode parent;

    public TreeNode increasingBST(TreeNode root) {
        parent = new TreeNode(0);
        index = parent;
        this.deal(root);
        return parent.right;
    }

    private void deal(TreeNode node) {
        if (node == null) {
            return;
        }
        this.deal(node.left);
        node.left = null;
        index.right = node;
        index = node;
        this.deal(node.right);
    }

}
