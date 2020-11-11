package lxl.y2020.JAN;

import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 13:49
 **/
public class KthSmallestElementInABst {
    private List<Integer> nodeList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        this.buildTreeNodeList(root, k);
        return nodeList.get(k - 1);
    }

    private void buildTreeNodeList(TreeNode root, int k) {
        if (root != null && nodeList.size() < k) {
            this.buildTreeNodeList(root.left, k);
            nodeList.add(root.val);
            this.buildTreeNodeList(root.right, k);
        }
    }

}
