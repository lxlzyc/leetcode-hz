package lxl.y2020.JUN;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * <p>
 * 示例 2：
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * <p>
 * 示例 3：
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-18 09:38
 **/
public class RecoverATreeFromPreorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        int length = S.length();
        if (length == 0) {
            return null;
        }

        if (!S.contains("-")) {
            TreeNode treeNode = new TreeNode(Integer.valueOf(S));
            return treeNode;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int depth = 0;
        TreeNode base = new TreeNode(Integer.valueOf(S.substring(0, S.indexOf("-"))));
        linkedList.add(base);
        linkedList.add(null);
        int left, right;
        left = S.indexOf("-");
        right = left;
        char[] chars = S.toCharArray();
        while (right < length) {
            if (chars[right] == '-') {
                depth++;
            } else {
                int help = 1;
                while (right + help < length && chars[right + help] != '-') {
                    help++;
                }
                int index = Integer.valueOf(S.substring(right, right + help));
                TreeNode treeNode = new TreeNode(index);
                TreeNode parentNode = linkedList.get(depth - 1);
                if (parentNode.left == null) {
                    parentNode.left = treeNode;
                } else {
                    parentNode.right = treeNode;
                }
                linkedList.set(depth, treeNode);
                linkedList.add(null);
                depth = 0;
                right = right + help - 1;
            }
            right++;
        }
        return base;
    }

    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal recoverATreeFromPreorderTraversal = new RecoverATreeFromPreorderTraversal();
        System.out.println(recoverATreeFromPreorderTraversal.recoverFromPreorder("1-2--3"));
    }
}
