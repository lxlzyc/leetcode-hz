package lxl.MAR;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-24 14:16
 **/
public class PathSumiii {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;
    private int indexsum;
    private Set<TreeNode> beginTreeNode = new HashSet<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        indexsum = sum;
        if (root.val == indexsum) {
            count++;
        }
        beginTreeNode.add(root);
        this.dealPathSum(root.left, root.val);
        this.dealPathSum(root.right, root.val);
        return count;
    }


    private void dealPathSum(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        int val = root.val;

        System.out.println(root.val + "|" + i);
        if (!beginTreeNode.contains(root)) {
            beginTreeNode.add(root);
            //以root为初始节点
            this.dealPathSum(root.left, val);
            this.dealPathSum(root.right, val);
            if (root.val == indexsum) {
                count++;
            }
        }


        if (i + val == indexsum) {
            count++;
        }

        this.dealPathSum(root.left, i + val);
        this.dealPathSum(root.right, i + val);

    }

    //public int pathSum(TreeNode root, int sum) {
    //    return pathSum(root, sum, new int[1000], 0);
    //}
    //
    //public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
    //    if (root == null) {
    //        return 0;
    //    }
    //    int tmp = root.val;
    //    int n = root.val == sum ? 1 : 0;
    //    for (int i = p - 1; i >= 0; i--) {
    //        tmp += array[i];
    //        if (tmp == sum) {
    //            n++;
    //        }
    //    }
    //    array[p] = root.val;
    //    int n1 = pathSum(root.left, sum, array, p + 1);
    //    int n2 = pathSum(root.right, sum, array, p + 1);
    //    return n + n1 + n2;
    //}
    public static void main(String[] args) {
        PathSumiii pathSumiii = new PathSumiii();
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);

        node10.left = node5;
        node10.right = node_3;

        node5.left = node3;
        node5.right = node2;

        node_3.right = node11;

        node3.left = node3_2;
        node3.right = node_2;

        node2.right = node1;
        //TreeNode node1 = new TreeNode(1);
        //TreeNode node2 = new TreeNode(2);
        //TreeNode node3 = new TreeNode(3);
        //TreeNode node4 = new TreeNode(4);
        //TreeNode node5 = new TreeNode(5);
        //node1.right = node2;
        //node2.right = node3;
        //node3.right = node4;
        //node4.right = node5;


        System.out.println(pathSumiii.pathSum(node10, 8));
    }
}
