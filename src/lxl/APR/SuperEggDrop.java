package lxl.APR;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * <p>
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-11 13:54
 **/
public class SuperEggDrop {
    //
    //我们可以考虑使用动态规划来做这道题，状态可以表示成 (K,N)(K, N)(K,N)，其中 KKK 为鸡蛋数，NNN 为楼层数。当我们从第 XXX 楼扔鸡蛋的时候：
    //
    //如果鸡蛋不碎，那么状态变成 (K,N−X)(K, N-X)(K,N−X)，即我们鸡蛋的数目不变，但答案只可能在上方的 N−XN-XN−X 层楼了。也就是说，我们把原问题缩小成了一个规模为 (K,N−X)(K, N-X)(K,N−X) 的子问题；
    //
    //如果鸡蛋碎了，那么状态变成 (K−1,X−1)(K-1, X-1)(K−1,X−1)，即我们少了一个鸡蛋，但我们知道答案只可能在第 XXX 楼下方的 X−1X-1X−1 层楼中了。也就是说，我们把原问题缩小成了一个规模为 (K−1,X−1)(K-1, X-1)(K−1,X−1) 的子问题。
    //
    //这样一来，我们定义 dp(K,N)dp(K, N)dp(K,N) 为在状态 (K,N)(K, N)(K,N) 下最少需要的步数。根据以上分析我们可以列出状态转移方程：
    //
    //dp(K,N)=1+min⁡1≤X≤N(max⁡(dp(K−1,X−1),dp(K,N−X)))dp(K, N) = 1 + \min\limits_{1 \leq X \leq N} \Big( \max(dp(K-1, X-1), dp(K, N-X)) \Big) dp(K,N)=1+1≤X≤Nmin​(max(dp(K−1,X−1),dp(K,N−X)))
    //
    //这个状态转移方程是如何得来的呢？对于 dp(K,N)dp(K, N)dp(K,N) 而言，我们像上面分析的那样，枚举第一个鸡蛋扔在的楼层数 XXX。由于我们并不知道真正的 FFF 值，因此我们必须保证 鸡蛋碎了之后接下来需要的步数 和 鸡蛋没碎之后接下来需要的步数 二者的 最大值 最小，这样就保证了在 最坏情况下（也就是无论 FFF 的值如何） dp(K,N)dp(K, N)dp(K,N) 的值最小。如果能理解这一点，也就能理解上面的状态转移方程，即最小化 max⁡(dp(K−1,X−1),dp(K,N−X))\max(dp(K-1, X-1), dp(K, N-X))max(dp(K−1,X−1),dp(K,N−X))。
    //
    //如果我们直接暴力转移求解每个状态的 dpdpdp 值，时间复杂度是为 O(KN2)O(KN^2)O(KN2)，即一共有 O(KN)O(KN)O(KN) 个状态，对于每个状态枚举扔鸡蛋的楼层 XXX，需要 O(N)O(N)O(N) 的时间。这无疑在当前数据范围下是会超出时间限制的，因此我们需要想办法优化枚举的时间复杂度。
    //
    //我们观察到 dp(K,N)dp(K, N)dp(K,N) 是一个关于 NNN 的单调递增函数，也就是说在鸡蛋数 KKK 固定的情况下，楼层数 NNN 越多，需要的步数一定不会变少。在上述的状态转移方程中，第一项 T1(X)=dp(K−1,X−1)\mathcal{T_1}(X) = dp(K-1, X-1)T1​(X)=dp(K−1,X−1) 是一个随 XXX 的增加而单调递增的函数，第二项 T2(X)=dp(K,N−X)\mathcal{T_2}(X) = dp(K, N-X)T2​(X)=dp(K,N−X) 是一个随着 XXX 的增加而单调递减的函数。
    //
    //这如何帮助我们来优化这个问题呢？当 XXX 增加时，T1(X)\mathcal{T_1}(X)T1​(X) 单调递增而 T2(X)\mathcal{T_2}(X)T2​(X) 单调递减，我们可以想象在一个直角坐标系中，横坐标为 XXX，纵坐标为 T1(X)\mathcal{T_1}(X)T1​(X) 和 T2(X)\mathcal{T_2}(X)T2​(X)。当一个函数单调递增而另一个函数单调递减时，我们如何找到一个位置使得它们的最大值最小呢？
    //
    //fig1
    //
    //如上图所示，如果这两个函数都是连续函数，那么我们只需要找出这两个函数的交点，在交点处就能保证这两个函数的最大值最小。但在本题中，T1(X)\mathcal{T_1}(X)T1​(X) 和 T2(X)\mathcal{T_2}(X)T2​(X) 都是离散函数，也就是说，XXX 的值只能取 1,2,31, 2, 31,2,3 等等。在这种情况下，我们需要找到最大的满足 T1(X)<T2(X)\mathcal{T_1}(X) < \mathcal{T_2}(X)T1​(X)<T2​(X) 的 X0X_0X0​，以及最小的满足 T1(X)≥T2(X)\mathcal{T_1}(X) \geq \mathcal{T_2}(X)T1​(X)≥T2​(X) 的 X1X_1X1​，对应到上图中，就是离这两个函数（想象中的）交点左右两侧最近的整数。
    //
    //我们只需要比较在 X0X_0X0​ 和 X1X_1X1​ 处两个函数的最大值，取一个最小的作为 XXX 即可。在数学上，我们可以证明出 X0X_0X0​ 和 X1X_1X1​ 相差 111，这也是比较显然的，因为它们正好夹住了那个想象中的交点，并且相距尽可能地近。因此我们就可以使用二分查找的方法找出 X0X_0X0​，再得到 X1X_1X1​：
    //
    //我们在所有满足条件的 XXX 上进行二分查找。对于状态 (K,N)(K, N)(K,N) 而言，XXX 即为 [1,N][1, N][1,N] 中的任一整数；
    //
    //在二分查找的过程中，假设当前这一步我们查找到了 XmidX_\textit{mid}Xmid​，如果 T1(Xmid)>T2(Xmid)\mathcal{T_1}(X_\textit{mid}) > \mathcal{T_2}(X_\textit{mid})T1​(Xmid​)>T2​(Xmid​)，那么真正的 X0X_0X0​ 一定在 XmidX_\textit{mid}Xmid​ 的左侧，否则真正的 X0X_0X0​ 在 XmidX_\textit{mid}Xmid​ 的右侧。
    //
    //二分查找的写法因人而异，本质上我们就是需要找到最大的满足 T1(X)<T2(X)\mathcal{T_1}(X) < \mathcal{T_2}(X)T1​(X)<T2​(X) 的 X0X_0X0​，根据 XmidX_\textit{mid}Xmid​ 进行二分边界的调整。在得到了 X0X_0X0​ 后，我们可以知道 X1X_1X1​ 即为 X0+1X_0 + 1X0​+1，此时我们只需要比较 max⁡(T1(X0),T2(X0))\max(\mathcal{T_1}(X_0), \mathcal{T_2}(X_0))max(T1​(X0​),T2​(X0​)) 和 max⁡(T1(X1),T2(X1))\max(\mathcal{T_1}(X_1), \mathcal{T_2}(X_1))max(T1​(X1​),T2​(X1​))，取较小的那个对应的位置作为 XXX 即可。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap();

    public int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K - 1, x - 1);
                    int t2 = dp(K, N - x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }

                ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
                        Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

}
