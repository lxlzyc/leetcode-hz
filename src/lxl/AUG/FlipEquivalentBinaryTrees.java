package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 951. 翻转等价二叉树
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * <p>
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * <p>
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 * 解释：我们翻转值为 1，3 以及 5 的三个节点。
 * Flipped Trees Diagram
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 100 个节点。
 * 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-17 11:48
 **/
public class FlipEquivalentBinaryTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            if (root1.val != root2.val) {
                return false;
            }
            boolean check = this.flipEquiv(root1.left, root2.left);
            if (check) {
                check = this.flipEquiv(root1.right, root2.right);
            }
            if (!check) {
                check = this.flipEquiv(root1.left, root2.right);
                if (check) {
                    check = this.flipEquiv(root1.right, root2.left);
                }
            }
            return check;
        }
    }

    //输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
    //输出：true
    //解释：我们翻转值为 1，3 以及 5 的三个节点
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        FlipEquivalentBinaryTrees flipEquivalentBinaryTrees = new FlipEquivalentBinaryTrees();
        System.out.println(flipEquivalentBinaryTrees.flipEquiv(flipEquivalentBinaryTrees.getNodes1(), flipEquivalentBinaryTrees.getNodes2()));
    }

    public TreeNode getNodes1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node5.left = node7;
        node5.right = node8;
        return node1;
    }

    public TreeNode getNodes2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.right = node7;
        node5.left = node8;
        return node1;
    }
}
