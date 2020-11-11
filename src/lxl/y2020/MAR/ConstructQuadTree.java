package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 427. 建立四叉树
 * 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
 * <p>
 * 每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-quad-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-23 11:05
 **/
public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;

    public Node construct(int[][] grid) {
        if (grid.length == 1) {
            Node node = new Node(grid[0][0] == 1, true);
            return node;
        }
        int m = grid.length;
        int n = grid[0].length;
        return this.buildNode(grid, 0, n, 0, m);
    }

    private Node buildNode(int[][] grid, int left, int right, int top, int bottom) {
        //System.out.println(left+","+(right-1)+"-"+top+","+(bottom-1));
        if (left == right - 1) {
            return new Node(grid[left][top] == 1, true);
        } else {
            Node node = new Node(
                    false,
                    false,
                    this.buildNode(grid, left, (left + right) / 2, top, (top + bottom) / 2),
                    this.buildNode(grid, (left + right) / 2, right, top, (top + bottom) / 2),
                    this.buildNode(grid, left, (left + right) / 2, (top + bottom) / 2, bottom),
                    this.buildNode(grid, (left + right) / 2, right, (top + bottom) / 2, bottom)
            );
            return node;
        }
    }

    public static void main(String[] args) {
        ConstructQuadTree constructQuadTree = new ConstructQuadTree();
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node node = constructQuadTree.construct(grid);
        System.out.println(node);
    }
}
