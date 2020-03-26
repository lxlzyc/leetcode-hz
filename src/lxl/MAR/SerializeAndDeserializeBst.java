package lxl.MAR;

import java.util.ArrayDeque;

/**
 * @program: leetcode-hz
 * @description: 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-26 15:12
 **/
public class SerializeAndDeserializeBst {
    //二叉搜索树能只够通过前序序列或后序序列构造

    //二叉树可以通过前序序列或后序序列和中序序列构造。
    //二叉搜索树的中序序列是递增排序的序列，inorder = sorted(preorder)。

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        this.buildSerialize(stringBuilder, root);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void buildSerialize(StringBuilder stringBuilder, TreeNode root) {
        if (root == null) {
            return;
        }
        this.buildSerialize(stringBuilder, root.left);
        this.buildSerialize(stringBuilder, root.right);
        stringBuilder.append(root.val + " ");

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nums = data.split(" ");
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (String num : nums) {
            arrayDeque.add(Integer.valueOf(num));
        }
        return this.helpDeserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, arrayDeque);
    }

    private TreeNode helpDeserialize(int minValue, int maxValue, ArrayDeque<Integer> arrayDeque) {
        if (arrayDeque.isEmpty()) {
            return null;
        }
        int val = arrayDeque.getLast();
        if (val < minValue || val > maxValue) {
            return null;
        }
        arrayDeque.removeLast();

        TreeNode node = new TreeNode(val);
        node.right = this.helpDeserialize(val, maxValue, arrayDeque);
        node.left = this.helpDeserialize(minValue, val, arrayDeque);
        return node;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.right = treeNode3;
        treeNode2.left = treeNode1;
        SerializeAndDeserializeBst serializeAndDeserializeBst = new SerializeAndDeserializeBst();
        System.out.println(serializeAndDeserializeBst.serialize(treeNode2));
        System.out.println(serializeAndDeserializeBst.deserialize("1 3 2").toString());


    }
}
