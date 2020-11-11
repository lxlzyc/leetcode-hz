package lxl.y2020.SEP;

/**
 * @program: leetcode-hz
 * @description: 685. 冗余连接 II
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * <p>
 * 注意:
 * <p>
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-17 09:33
 **/
public class RedundantConnectionii {

    static class UnionFind {
        int[] ancestor;

        public UnionFind(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; ++i) {
                ancestor[i] = i;
            }
        }

        public void union(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        public int find(int index) {
            if (ancestor[index] != index) {
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int l = edges.length;
        int[] parent = new int[l + 1];
        //构建并查集
        UnionFind uf = new UnionFind(l + 1);
        for (int i = 0; i < l + 1; i++) {
            parent[i] = i;
        }
        //
        int conflict = -1;
        //
        int cycle = -1;
        for (int i = 0; i < l; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                //如果node2的父节点初始化后，标识当前节点又有了新的父节点，异常
                conflict = i;
            } else {
                //node2的父节点 未初始化，初始化
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    //如果node1的父节点等于node2的父节点 构成了循环，标记
                    cycle = i;
                } else {
                    //不是循环，合并node1，node2。
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            //没有异常的时候，直接返回构成了循环的节点
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            //有异常的时候，获取异常位置
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                //在遍历图中的所有边之后，根据是否存在导致冲突的边和导致环路出现的边，得到附加的边。
                //
                //如果没有导致冲突的边，说明附加的边一定导致环路出现，而且是在环路中的最后一条被访问到的边，因此附加的边即为导致环路出现的边。
                //
                //如果有导致冲突的边，记这条边为 [u,v]，则有两条边指向 vvv，另一条边为 [parent[v],v]，需要通过判断是否有导致环路的边决定哪条边是附加的边。
                //
                //如果有导致环路的边，则附加的边不可能是 [u,v]（因为 [u,v] 已经被记为导致冲突的边，不可能被记为导致环路出现的边），因此附加的边是 [parent[v],v]。
                //
                //如果没有导致环路的边，则附加的边是后被访问到的指向 vvv 的边，因此附加的边是 [u,v]。
                //
                //作者：LeetCode-Solution
                //链接：https://leetcode-cn.com/problems/redundant-connection-ii/solution/rong-yu-lian-jie-ii-by-leetcode-solution/
                //来源：力扣（LeetCode）
                //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                //无循环，直接返回异常节点
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }


}
