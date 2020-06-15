package lxl.JUN;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 743. 网络延迟时间
 * 有 N 个网络节点，标记为 1 到 N。
 * <p>
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点，
 * w 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * N 的范围在 [1, 100] 之间。
 * K 的范围在 [1, N] 之间。
 * times 的长度在 [1, 6000] 之间。
 * 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-15 13:31
 **/
public class NetworkDelayTime {


    public int networkDelayTime3(int[][] times, int N, int K) {
        //存储各节点距离初始节点的长度
        int[] dist = new int[N + 1];
        //存储各节点是否访问过
        boolean[] seen = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            seen[i] = false;
        }
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist[K] = 0;
        while (true) {
            //节点
            int canNode = -1;
            //节点距离原始节点长度
            int canDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!seen[i] && dist[i] < canDist) {
                    //取最短访问路径-连通未访问的节点
                    canDist = dist[i];
                    canNode = i;
                    if (canDist == 0) {
                        break;
                    }
                }
            }
            if (canNode < 0) {
                break;
            }
            //标识已经访问过
            seen[canNode] = true;
            if (graph.containsKey(canNode)) {
                for (int[] node : graph.get(canNode)) {
                    //遍历节点，更新长度
                    dist[node[0]] = Math.min(dist[node[0]], dist[canNode] + node[1]);
                }
            }
        }

        int ans = 0;
        for (int item : dist) {
            if (item == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, item);
        }
        return ans;
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        //[[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
        //[[4,2,76],[1,3,79],[3,1,81],[4,3,30],[2,1,47],[1,5,61],[1,4,99],[3,4,68],[3,5,46],[4,1,6],[5,4,7],
        //[5,3,44],[4,5,19],[2,3,13],[3,2,18],[1,2,0],[5,1,25],[2,5,58],[2,4,77],[5,2,74]]
        //5
        //3
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime.networkDelayTime3(times, 4, 2));
    }
}