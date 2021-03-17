package lxl.y2021.MAR;

import lxl.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17 11:10
 * @Version 1.0
 */
public class TreeLevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode index = deque.poll();
            list.add(index.val);
            if (index.left != null) {
                deque.offer(index.left);
            }
            if (index.right != null) {
                deque.offer(index.right);
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.pollFirst();
        }
        return ans;
    }


}