package lxl.y2020.APR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-25 09:24
 **/
public class NAryTreePostorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node index = stack.peek();

            list.add(index.val);
            for (Node item : index.children) {
                stack.push(item);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node index : node.children) {
                stack.push(index);
            }
        }
        return list;
    }

}
