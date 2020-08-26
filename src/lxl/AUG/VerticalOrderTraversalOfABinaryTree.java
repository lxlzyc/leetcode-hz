package lxl.AUG;

import lxl.util.JSONUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode-hz
 * @description: 987. 二叉树的垂序遍历
 * 给定二叉树，按垂序遍历返回其结点值。
 * <p>
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 * <p>
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 * <p>
 * 如果两个结点位置相同，则首先报告的结点值较小。
 * <p>
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
 * 然后，值为 9 的结点出现在 (-1, -1)；
 * 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
 * 值为 20 的结点出现在 (1, -1)；
 * 值为 7 的结点出现在 (2, -2)。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
 * 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的结点数介于 1 和 1000 之间。
 * 每个结点值介于 0 和 1000 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-26 11:08
 **/
public class VerticalOrderTraversalOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Node {
        int val;
        int y;

        Node(int val, int y) {
            this.val = val;
            this.y = y;
        }
    }

    private TreeMap<Integer, List<Node>> treeMap;


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        this.dealTree(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : treeMap.keySet()) {
            List<Node> index = treeMap.get(key);
            Collections.sort(index, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int compare = Integer.compare(o1.y, o2.y);
                    if (compare == 0) {
                        compare = Integer.compare(o1.val, o2.val);
                    }
                    return compare;
                }
            });
            ans.add(index.stream().map(node -> node.val).collect(Collectors.toList()));
        }
        return ans;
    }

    private void dealTree(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        List<Node> value = treeMap.getOrDefault(x, new ArrayList<>());
        value.add(new Node(root.val, y));
        treeMap.put(x, value);
        this.dealTree(root.left, x - 1, y + 1);
        this.dealTree(root.right, x + 1, y + 1);
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfABinaryTree verticalOrderTraversalOfABinaryTree = new VerticalOrderTraversalOfABinaryTree();
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(6);
        TreeNode node41 = new TreeNode(5);
        TreeNode node42 = new TreeNode(7);

        node1.left = node21;
        node1.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node41;
        node22.right = node42;
        System.out.println(JSONUtil.toJson(verticalOrderTraversalOfABinaryTree.verticalTraversal(node1)));
    }
}
