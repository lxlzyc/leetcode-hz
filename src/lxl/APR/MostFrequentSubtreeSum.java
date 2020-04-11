package lxl.APR;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * <p>
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * <p>
 * 示例 2：
 * 输入：
 * <p>
 * 5
 * /  \
 * 2   -5
 * <p>
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * <p>
 * <p>
 * <p>
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-11 19:52
 **/
public class MostFrequentSubtreeSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> counts = new HashMap<>();
    private int max = 0;
    List<Integer> maxnums = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        this.getValCount(root);
        int[] re = new int[maxnums.size()];
        for (int i = 0; i < maxnums.size(); i++) {
            re[i] = maxnums.get(i);
        }
        return re;
    }

    private int getValCount(TreeNode root) {
        int val = root.val;
        int left = 0;
        if (root.left != null) {
            left = this.getValCount(root.left);

        }
        int right = 0;
        if (root.right != null) {
            right = this.getValCount(root.right);
        }
        val = val + left + right;
        counts.put(val, counts.getOrDefault(val, 0) + 1);
        if (counts.get(val) > max) {
            maxnums.clear();
            maxnums.add(val);
            max = counts.get(val);
        } else if (counts.get(val) == max) {
            maxnums.add(val);
        }
        System.out.println(root.val + "-" + val);
        return val;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(-5);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        //treeNode4.right = treeNode5;
        MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
        System.out.println(Arrays.toString(mostFrequentSubtreeSum.findFrequentTreeSum(treeNode2)));

    }
}
