package lxl.y2021.JAN;

import java.util.*;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * <p>
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * <p>
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * <p>
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/19 11:27
 * @Version 1.0
 */
public class MinCostToConnectAllPoints {
//    Kruskal 算法是一种常见并且好写的最小生成树算法，由 Kruskal 发明。该算法的基本思想是从小到大加入边，是一个贪心算法。
//
//    其算法流程为：
//
//    将图 G={V,E} 中的所有边按照长度由小到大进行排序，等长的边可以按任意顺序。
//
//    初始化图 G 为 {V,∅}，从前向后扫描排序后的边，如果扫描到的边 e 在 G 中连接了两个相异的连通块,则将它插入 G 中。
//
//    最后得到的图 G 就是图 G 的最小生成树。
//
//    在实际代码中，我们首先将这张完全图中的边全部提取到边集数组中，然后对所有边进行排序，从小到大进行枚举，每次贪心选边加入答案。
//    使用并查集维护连通性，若当前边两端不连通即可选择这条边。

    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        //构建所有边长
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                edgeList.add(new Edge(dist(points, i, j), i, j));
            }
        }
        //边长排序
        Collections.sort(edgeList, new Comparator<Edge>() {
            public int compare(Edge edge1, Edge edge2) {
                return edge1.len - edge2.len;
            }
        });
        //并查集构建
        DisjointSetUnion dsu = new DisjointSetUnion(len);
        int ret = 0, num = 1;
        for (Edge edge : edgeList) {
            int indexlen = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += indexlen;
                num++;
                if (num == len) {
                    break;
                }
            }
        }
        return ret;
    }

    private int dist(int[][] points, int i, int j) {
        //曼哈顿距离
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
            return true;
        }
    }

    class Edge {
        int x;
        int y;
        int len;

        //标识第x-第y个节点的长度。
        public Edge(int len, int x, int y) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}