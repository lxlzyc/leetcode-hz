package lxl.y2020.JUN;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 797. 所有可能的路径
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
 * <p>
 * 示例:
 * 输入: [[1,2], [3], [3], []]
 * 输出: [[0,1,3],[0,2,3]]
 * 解释: 图是这样的:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * 这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
 * <p>
 * 提示:
 * <p>
 * 结点的数量会在范围 [2, 15] 内。
 * 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 * @author: lxl
 * @create: 2020-06-30 14:22
 **/
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N - 1);
            ans.add(path);
            return ans;
        }

        for (int nei : graph[node]) {
            for (List<Integer> path : solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }

}
