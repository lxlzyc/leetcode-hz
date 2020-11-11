package lxl.y2020.JUL;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: LCP 13. 寻宝
 * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
 * <p>
 * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
 * <p>
 * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
 * <p>
 * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
 * <p>
 * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： ["S#O", "M..", "M.T"]
 * <p>
 * 输出：16
 * <p>
 * 解释：最优路线为： S->O, cost = 4, 去搬石头 O->第二行的M, cost = 3, M机关触发 第二行的M->O, cost = 3, 我们需要继续回去 O 搬石头。 O->第三行的M, cost = 4, 此时所有机关均触发 第三行的M->T, cost = 2，去T点拿宝藏。 总步数为16。 图片.gif
 * <p>
 * 示例 2：
 * <p>
 * 输入： ["S#O", "M.#", "M.T"]
 * <p>
 * 输出：-1
 * <p>
 * 解释：我们无法搬到石头触发机关
 * <p>
 * 示例 3：
 * <p>
 * 输入： ["S#O", "M.T", "M.."]
 * <p>
 * 输出：17
 * <p>
 * 解释：注意终点也是可以通行的。
 * <p>
 * 限制：
 * <p>
 * 1 <= maze.length <= 100
 * 1 <= maze[i].length <= 100
 * maze[i].length == maze[j].length
 * S 和 T 有且只有一个
 * 0 <= M的数量 <= 16
 * 0 <= O的数量 <= 40，题目保证当迷宫中存在 M 时，一定存在至少一个 O 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xun-bao
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-29 14:59
 **/
public class XunBao {
    //一个人在迷宫中，要从起点 SSS 走到终点 TTT。迷宫有两类特殊点，分别是：
    //
    //MMM：机关点，需要用石头触发
    //OOO：石头点，一次可以搬一块石头
    //
    //只有当所有 MMM 点均被触发以后，终点才可到达，问起点走到终点的最小代价。
    //
    //思路与算法
    //虽然迷宫有很多格子，但是我们实际上的走法只有几种：
    //
    //从 SSS 走到 OOO，我们不会从 SSS 直接走到 MMM，因为触发机关要先搬石头
    //从 OOO 走到 MMM
    //从 MMM 走到 OOO
    //从 MMM 走到 TTT
    //
    //有一点性质很重要，不论我们触发机关还是搬运石头，都不会改变迷宫的连通状态。因此，两个点的最短距离一旦计算出，就不会再改变了。 于是第一步，我们可以做一步预处理——我们计算所有特殊点（包括 MMM，OOO，SSS，TTT）互相之间的最短距离，即对这里面的每个点做一次 BFS。这样我们就不需要考虑其他点了。为什么要预处理出这些特殊点两两之间的距离，这个问题会在在下文中解释。
    //
    //解决这个问题的关键是理解我们要以什么样的策略来取石头和触发机关：
    //
    //在最开始，我们一定会从 SSS，经过某一个 OOO，到达某一个 MMM。那么对于特定的 MMM 来说，我们枚举 OOO 就可以计算 S−O−MS-O-MS−O−M 的最短距离。那么如果我们要从起点 SSS 到达 MMM，一定会选择这条距离最短的路。这样，我们首先得到了 SSS 到每一个 MMM 的最短距离。
    //
    //fig1
    //
    //假定我们已经从起点到达了某个 MMM 了，接下来需要去其他的 OOO 点搬石头接着触发其他的机关，这是一个 M−O−M′M-O-M'M−O−M′ 的路线。同样的道理，对于给定的 M′M'M′，中间的 OOO 也是固定的。即给定 MMM 和 M′M'M′，我们可以确定一个 OOO，使得 M−O−M′M-O-M'M−O−M′ 距离最短。我们同样可以记录下这个最短距离，即得到了 所有 MMM 到 M′M'M′ 的最短距离。
    //
    //fig2
    //
    //最后，所有 MMM 到 TTT 的距离在前面已经计算出了。
    //
    //我们需要所有的 MMM 都被触发，MMM 的触发顺序不同会导致行走的路径长度不同。假设这里一共有 nnn 个 MMM，我们用 d(i,j)d(i, j)d(i,j) 表示第 iii 个 MMM 到第 jjj 个 MMM 经过某一个 OOO 的最短距离。因为这里的 nnn 不大于 161616，我们可以使用一个 161616 位的二进制数表示状态，这个二进制数的第 iii 位为 111 表示第 iii 个 MMM 已经触发，为 000 表示第 iii 个 MMM 还未被触发，记这个二进制数为 mask\rm maskmask。记 MiM_iMi​ 为第 iii 个 MMM（下标从 111 开始），每一个 mask\rm maskmask 都可以表示成两个集合，一个已触发集合、一个未触发集合，例如 n=16n = 16n=16，mask=0000 1100 0001 0001mask = 0000~1100~0001~0001mask=0000 1100 0001 0001 的已触发集合就可以表示为 T={M1,M5,M11,M12}T = \{ M_1, M_5, M_{11}, M_{12} \}T={M1​,M5​,M11​,M12​}，剩下的元素都在未触发集合 U−TU - TU−T 中。
    //
    //我们定义 f(mask,i)f({\rm mask}, i)f(mask,i) 表示当前在第 iii 个 MMM 处，触发状态为 mask{\rm mask}mask 的最小步数，如果当前 mask{\rm mask}mask 代表的已触发集合为 TTT，未触发集合为 U−TU - TU−T，则我们可以推出这样的动态规划转移方程：
    //
    //f(mask,i)=min⁡j∈T,j≠i{f(mask xor 2i,j)+d(j,i)}f({\rm mask}, i) = \min_{j \in T, j \neq i } \{ f({\rm mask}~{\rm xor}~2^i, j) + d(j, i)\} f(mask,i)=j∈T,j​=imin​{f(mask xor 2i,j)+d(j,i)}
    //
    //其中 mask xor 2i{\rm mask}~{\rm xor}~2^imask xor 2i 表示把 MiM_iMi​ 已触发的集合当中去掉，即 mask{\rm mask}mask 这个状态可以由 mask xor 2i{\rm mask}~{\rm xor}~2^imask xor 2i 状态转移得到，转移时我们除了关注触发状态 mask\rm maskmask 的变化，我们还关注是从哪一个 MMM 转移到了 MiM_iMi​，我们可以枚举 mask\rm maskmask 当中已触发的所有的 Mj(j≠i)M_j(j \neq i)Mj​(j​=i) 作为上一个位置，而 d(j,i)d(j, i)d(j,i) 就是我们从 jjj 转移到 iii 行走的最短步数，我们可以在预处理之后按照我们的策略得到所有的 d(j,i)d(j, i)d(j,i)（如果 i,ji, ji,j 不可达可以设为正无穷），然后 O(1)O(1)O(1) 查询，这就是预处理的目的。
    //
    //实际上，在实现的时候，如果我们用记忆化搜索的方式实现，那么我们用到的是上面的转移方程；如果我们使用循环实现的话，也可以使用下面的转移方程，写法类似递推：
    //
    //f(mask∣2j,j)=min⁡{f(mask,i)+d(i,j)}f({\rm mask} | 2^j, j) = \min \{ f({\rm mask}, i) + d(i, j) \} f(mask∣2j,j)=min{f(mask,i)+d(i,j)}
    //
    //大家可以结合代码来理解。当然，写代码的时候需要注意的是：
    //
    //由于本题的复杂度较高，使用 Python 等性能较差的语言实现时需要注意效率问题。
    //本题边界情况较多，比如迷宫没有 MMM、MMM 不可达等。
    //
    //题型小结
    //
    //这道题是一个非常经典的状态压缩动态规划模型：有 nnn 个任务 {M1,M2⋯Mn}\{M_1, M_2 \cdots M_n \}{M1​,M2​⋯Mn​}，每两个任务之间有一个 c(Mi,Mj)c(M_i, M_j)c(Mi​,Mj​) 表示在 MiM_iMi​ 之后（下一个）做 MjM_jMj​ 的花费，让你求解把 nnn 个任务都做完需要的最小花费。通常这个 nnn 会非常的小，因为需要构造 2n2^n2n 种状态，c(Mi,Mj)c(M_i, M_j)c(Mi​,Mj​) 可能是题目给出，也可能是可以在很短的时间内计算出来的一个值。这类问题的状态设计一般都是 f(mask,i)f({\rm mask}, i)f(mask,i) 表示当前任务完成的状态是 mask\rm maskmask，当前位置是 iii，考虑转移的时候我们只需要考虑当前任务的上一个任务即可。希望读者可以理解这里的思想，并尝试使用记忆化搜索和循环两种方式实现。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/xun-bao/solution/xun-bao-bfs-dp-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;

    public int minimalSteps(String[] maze) {
        n = maze.length;
        m = maze[0].length();
        // 机关 & 石头
        List<int[]> buttons = new ArrayList<int[]>();
        List<int[]> stones = new ArrayList<int[]>();
        // 起点 & 终点
        int sx = -1, sy = -1, tx = -1, ty = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i].charAt(j) == 'M') {
                    buttons.add(new int[]{i, j});
                }
                if (maze[i].charAt(j) == 'O') {
                    stones.add(new int[]{i, j});
                }
                if (maze[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                if (maze[i].charAt(j) == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        int nb = buttons.size();
        int ns = stones.size();
        int[][] startDist = bfs(sx, sy, maze);

        // 边界情况：没有机关
        if (nb == 0) {
            return startDist[tx][ty];
        }
        // 从某个机关到其他机关 / 起点与终点的最短距离。
        int[][] dist = new int[nb][nb + 2];
        for (int i = 0; i < nb; i++) {
            Arrays.fill(dist[i], -1);
        }
        // 中间结果
        int[][][] dd = new int[nb][][];
        for (int i = 0; i < nb; i++) {
            int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
            dd[i] = d;
            // 从某个点到终点不需要拿石头
            dist[i][nb + 1] = d[tx][ty];
        }

        for (int i = 0; i < nb; i++) {
            int tmp = -1;
            for (int k = 0; k < ns; k++) {
                int midX = stones.get(k)[0], midY = stones.get(k)[1];
                if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
                    if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
                        tmp = dd[i][midX][midY] + startDist[midX][midY];
                    }
                }
            }
            dist[i][nb] = tmp;
            for (int j = i + 1; j < nb; j++) {
                int mn = -1;
                for (int k = 0; k < ns; k++) {
                    int midX = stones.get(k)[0], midY = stones.get(k)[1];
                    if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {
                        if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {
                            mn = dd[i][midX][midY] + dd[j][midX][midY];
                        }
                    }
                }
                dist[i][j] = mn;
                dist[j][i] = mn;
            }
        }

        // 无法达成的情形
        for (int i = 0; i < nb; i++) {
            if (dist[i][nb] == -1 || dist[i][nb + 1] == -1) {
                return -1;
            }
        }

        // dp 数组， -1 代表没有遍历到
        int[][] dp = new int[1 << nb][nb];
        for (int i = 0; i < 1 << nb; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < nb; i++) {
            dp[1 << i][i] = dist[i][nb];
        }

        // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
        for (int mask = 1; mask < (1 << nb); mask++) {
            for (int i = 0; i < nb; i++) {
                // 当前 dp 是合法的
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < nb; j++) {
                        // j 不在 mask 里
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }

        int ret = -1;
        int finalMask = (1 << nb) - 1;
        for (int i = 0; i < nb; i++) {
            if (ret == -1 || ret > dp[finalMask][i] + dist[i][nb + 1]) {
                ret = dp[finalMask][i] + dist[i][nb + 1];
            }
        }

        return ret;
    }

    public int[][] bfs(int x, int y, String[] maze) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ret[i], -1);
        }
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curx = p[0], cury = p[1];
            for (int k = 0; k < 4; k++) {
                int nx = curx + dx[k], ny = cury + dy[k];
                if (inBound(nx, ny) && maze[nx].charAt(ny) != '#' && ret[nx][ny] == -1) {
                    ret[nx][ny] = ret[curx][cury] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ret;
    }

    public boolean inBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
