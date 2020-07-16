package lxl.JUL;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * <p>
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * <p>
 * 注意:
 * <p>
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-16 09:46
 **/
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[100];
        //广度搜索
        Queue<Integer> offsets = new LinkedList<>();
        int nextcolor;
        int next;
        for (int i = 0, l = graph.length; i < l; i++) {
            if (color[i] == 0) {
                color[i] = 1;
            } else {
                continue;
            }
            offsets.offer(i);
            while (!offsets.isEmpty()) {
                next = offsets.poll();
                nextcolor = color[next] == 1 ? 2 : 1;
                for (int offset : graph[next]) {
                    if (color[offset] == 0) {
                        color[offset] = nextcolor;
                        offsets.offer(offset);
                    } else {
                        if (color[offset] != nextcolor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        //* 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        System.out.println(isGraphBipartite.isBipartite(graph));
    }

}
