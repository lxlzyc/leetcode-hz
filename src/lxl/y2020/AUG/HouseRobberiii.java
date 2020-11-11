package lxl.y2020.AUG;

/**
 * @program: leetcode-hz
 * @description: 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 通过次数44,118
 * 提交次数75,439
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-05 09:53
 **/
public class HouseRobberiii {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] dp = this.dealRoot(root);
        return Math.max(dp[0], dp[1]);
    }

    //int[] dp 0记录包含root节点的最大值，1记录不包含root节点的最大值
    private int[] dealRoot(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = this.dealRoot(root.left);
        int[] right = this.dealRoot(root.right);
        return new int[]{root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }

    public static void main(String[] args) {
        //TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        //TreeNode treeNode6 = new TreeNode(1);

        treeNode4.left = treeNode5;
        treeNode5.left = treeNode3;
        treeNode3.left = treeNode2;
        HouseRobberiii houseRobberiii = new HouseRobberiii();
        System.out.println(houseRobberiii.rob(treeNode4));
    }

}
