package lxl.y2020.MAY;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-14 10:24
 **/
public class TwoSumIvInputIsABst {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Set<Integer> help = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (help.contains(k - root.val)) {
            return true;
        }
        help.add(root.val);
        return this.findTarget(root.left, k) || this.findTarget(root.right, k);
    }
}
