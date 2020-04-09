package lxl.APR;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-09 14:18
 **/
public class FindModeInBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉搜索树的中序遍历是递增顺序，把问题转换为求递增数组众数即可。
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        if (root.left == null && root.right == null) {
            int[] re = new int[1];
            re[0] = root.val;
            return re;
        }
        List<Integer> list = new ArrayList<>();
        this.getAllNode(root, list);
        System.out.println(JSONUtil.toJson(list));
        List<Integer> max = new ArrayList<>();
        int maxCount = 1;
        int help = 1;
        int old = list.get(0);
        max.add(old);
        for (int i = 1, l = list.size(); i < l; i++) {
            if (list.get(i) == old) {
                help++;
            } else {
                if (help > maxCount) {
                    maxCount = help;
                    max.clear();
                    max.add(old);
                } else if (help == maxCount) {
                    max.add(old);
                }
                old = list.get(i);
                help = 1;
            }
        }
        if (help > maxCount) {
            maxCount = help;
            max.clear();
            max.add(old);
        } else if (help == maxCount) {
            max.add(old);
        }
        if (maxCount == 1) {
            int[] re = new int[list.size()];
            for (int i = 0, l = re.length; i < l; i++) {
                re[i] = list.get(i);
            }
            return re;
        } else {
            int[] re = new int[max.size()];
            for (int i = 0, l = re.length; i < l; i++) {
                re[i] = max.get(i);
            }
            return re;
        }
    }

    private void getAllNode(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        this.getAllNode(root.left, list);
        list.add(root.val);
        this.getAllNode(root.right, list);
    }

    public static void main(String[] args) {
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(5);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.right = treeNode5;
        //treeNode3.right = treeNode4;
        //treeNode4.left = treeNode5;
        //treeNode4.right = treeNode6;

        System.out.println(Arrays.toString(findModeInBinarySearchTree.findMode(treeNode1)));
    }
}
