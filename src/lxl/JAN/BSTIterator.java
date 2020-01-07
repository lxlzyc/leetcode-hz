package lxl.JAN;

import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 16:45
 **/
public class BSTIterator {

    private List<Integer> list;
    private int offset;
    private int max;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        this.helper(root, list);
        offset = 0;
        max = list.size();
    }


    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(offset++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return offset < max;
    }
}
