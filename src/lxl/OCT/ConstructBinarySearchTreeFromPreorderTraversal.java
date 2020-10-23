package lxl.OCT;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 1008. 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 * <p>
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * preorder 中的值互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-23 11:06
 **/
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return this.build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[left]);
        int bigeer = 1;
        while (left + bigeer <= right) {
            if (preorder[left + bigeer] > preorder[left]) {
                break;
            }
            bigeer++;
        }
        node.left = this.build(preorder, left + 1, left + bigeer - 1);
        node.right = this.build(preorder, left + bigeer, right);
        return node;
    }

}
