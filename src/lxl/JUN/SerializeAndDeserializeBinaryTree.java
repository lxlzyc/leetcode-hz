package lxl.JUN;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode-hz
 * @description: 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-16 09:34
 **/
public class SerializeAndDeserializeBinaryTree {

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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode index = queue.poll();
            if (index != null) {
                stringBuilder.append(index.val).append(",");
                queue.offer(index.left);
                queue.offer(index.right);
            } else {
                stringBuilder.append("x,");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] strings = data.split(",");
        int len = strings.length;
        Integer[] items = new Integer[len];
        for (int i = 0, l = len; i < l; i++) {
            if (strings[i].equals("x")) {
                items[i] = null;
            } else {
                items[i] = Integer.valueOf(strings[i]);
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode base = new TreeNode(items[0]);
        queue.offer(base);
        int cur = 1;
        while (!queue.isEmpty()) {
            if (cur >= len) {
                break;
            }
            TreeNode index = queue.poll();
            if (items[cur] != null) {
                TreeNode left = new TreeNode(items[cur]);
                index.left = left;
                queue.offer(left);
            }
            cur++;
            if (cur < len && items[cur] != null) {
                TreeNode right = new TreeNode(items[cur]);
                index.right = right;
                queue.offer(right);
            }
            cur++;
        }
        return base;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;


        System.out.println(serializeAndDeserializeBinaryTree.serialize(treeNode1));
        TreeNode help = serializeAndDeserializeBinaryTree.deserialize(serializeAndDeserializeBinaryTree.serialize(treeNode1));
        //System.out.println(serializeAndDeserializeBinaryTree.serialize(treeNode1));

        System.out.println(serializeAndDeserializeBinaryTree.serialize(help));
    }
}
