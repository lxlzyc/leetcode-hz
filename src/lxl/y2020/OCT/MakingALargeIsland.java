package lxl.y2020.OCT;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 827. 最大人工岛
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * <p>
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * 说明:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-30 09:49
 **/
public class MakingALargeIsland {

    //上下左右
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private Set<Node> zeros;
    private UnionFind unionFind;

    public int largestIsland(int[][] grid) {
        zeros = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        unionFind = new UnionFind(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    this.doUnion(grid, i, j, m, n);
                } else if (grid[i][j] == 0) {
                    zeros.add(new Node(i, j));
                }
            }
        }
        Map<Node, Integer> lands = new HashMap<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Node index = unionFind.find(i, j);
                int count = lands.getOrDefault(index, 0) + 1;
                max = Math.max(max, count);
                lands.put(index, count);
            }
        }
        for (Node item : zeros) {
            Set<Node> nerNodes = this.getNerNodes(grid, item.x, item.y, m, n);
            int index = 1;
            for (Node node : nerNodes) {
                index += lands.getOrDefault(node, 0);
            }
            max = Math.max(index, max);
        }
        return max;
    }

    private Set<Node> getNerNodes(int[][] grid, int i, int j, int m, int n) {
        Set<Node> ans = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nexti = i + directions[k][0];
            int nextj = j + directions[k][1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n) {
                if (grid[nexti][nextj] == -1) {
                    Node node = unionFind.find(nexti, nextj);
                    ans.add(node);
                }
            }
        }
        return ans;
    }

    private void doUnion(int[][] grid, int i, int j, int m, int n) {
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int nexti = i + directions[k][0];
            int nextj = j + directions[k][1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n) {
                if (grid[nexti][nextj] == 1) {
                    unionFind.union(i, j, nexti, nextj);
                    doUnion(grid, nexti, nextj, m, n);
                }
            }
        }
    }

    //并查集
    static class UnionFind {
        Node[][] ancestor;

        public UnionFind(int m, int n) {
            ancestor = new Node[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    ancestor[i][j] = new Node(i, j);
                }
            }
        }

        public void union(int i1, int j1, int i2, int j2) {
            Node index = find(i1, j1);
            ancestor[index.x][index.y] = find(i2, j2);
        }

        public Node find(int i, int j) {
            Node index = ancestor[i][j];
            if (index.x != i || index.y != j) {
                ancestor[i][j] = find(index.x, index.y);
                index = ancestor[i][j];
            }
            return index;
        }
    }

    //并查集节点
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        MakingALargeIsland makingALargeIsland = new MakingALargeIsland();
        int[][] grid = {
                {1, 1, 0},
                {0, 0, 1},
                {0, 1, 0}};
        System.out.println(makingALargeIsland.largestIsland(grid));
    }
}
