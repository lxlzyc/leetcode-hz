package lxl.y2020.APR;

import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-20 09:39
 **/
public class MaximumDepthOfNAryTree {

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

    ;
    private int max = 0;

    public int maxDepth(Node root) {
        this.getDepth(root, 0);
        return max;
    }

    private void getDepth(Node root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        max = Math.max(depth, max);
        if (root.children != null) {
            for (Node node : root.children) {
                this.getDepth(node, depth);
            }
        }


    }
}
