package lxl.NOV;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description:
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 *
 * 示例 1:
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1.
 * 航班数量范围是 [0, n * (n - 1) / 2].
 * 每个航班的格式 (src, dst, price).
 * 每个航班的价格范围是 [1, 10000].
 * k 范围是 [0, n - 1].
 * 航班没有重复，且不存在环路
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: lxl
 * @create: 2019-11-21 16:32
 **/
public class FindCheapestPrice {

    /**
     * 假设 pre[node] 是到经过 T 个节点到达目的节点 node 的最短距离，然后求解经过 T+1 个节点到达目的节点的最短距离。对于每一条连接城市 u 和 v，
     * 成本为 w的航线，更新后的最短距离为 dis[v] = min(dis[v], pre[u] + w)。
     * 实际上，初始令 dis = dist[0] 和 pre = dist[1]，在下一步循环迭代 (i = 1) 时，可以重复使用 dis = dist[1] 和 pre = dist[0]，以此类推。
     *
     * @author liuxiangli
     * @date 2019/11/22 9:43
     * @since 1.0.0
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @returen int
     * @throws
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;

        //最大步骤
        for (int i = 0; i <= K; ++i){
            for (int[] edge: flights){
                //第一步，列出src到所有位置的金额
                //第二步，列出所有位置到其他位置的金额
                //第三部，获取dist[K&1][dst]
                //dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);
                //System.out.println("i="+i+"-"+"|"+(i&1)+","+edge[1]+"="+ dist[i&1][edge[1]]+"-"+(dist[~i&1][edge[0]] + edge[2]));
                //
                //if(edge){
                //
                //}
            }
        }

        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }

    public static void main(String[] args) {
        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();

        int[][] n = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice.findCheapestPrice(
                3,
                n,
        0,
        2,
        2
        ));
    }

}
