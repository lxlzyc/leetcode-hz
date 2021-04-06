package lxl.y2021.APR;

import lxl.util.TreeNode;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/6 9:37
 * @Version 1.0
 */
public class SuccessorLcci {
    //    找到p的右子树的最左孩子即可
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root.val != p.val) {
            //右边
            if (p.val > root.val) {
                root = root.right;
            }
            //左边
            else {
                pre = root;
                root = root.left;
            }
        }
        //假如没有右子树
        if (root.right == null) {
            return pre;
        } else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
}