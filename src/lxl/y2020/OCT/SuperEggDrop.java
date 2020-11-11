package lxl.y2020.OCT;

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
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * @author: lxl
 * @create: 2020-10-21 11:20
 **/
public class SuperEggDrop {
    //如果我们可以做 T 次操作，而且有 K 个鸡蛋，那么我们能找到答案的最高的 N 是多少？
    //我们设 f(T,K) 为在上述条件下的 N。
    //如果我们求出了所有的 f(T,K)，那么只需要找出最小的满足 f(T,K)≥N 的 T。
    //那么我们如何求出 f(T,K) 呢？我们还是使用动态规划。因为我们需要找出最高的 N，因此我们不必思考到底在哪里扔这个鸡蛋，我们只需要扔出一个鸡蛋，看看到底发生了什么：
    //
    //如果鸡蛋没有碎，那么对应的是 f(T−1,K)，也就是说在这一层的上方可以有 f(T−1,K) 层；
    //
    //如果鸡蛋碎了，那么对应的是 f(T−1,K−1)，也就是说在这一层的下方可以有 f(T−1，K−1) 层。
    //  f(T,K)=1+f(T−1,K−1)+f(T−1,K)
    //
    //边界条件为：当 T≥1的时候 f(T,1)=T，当 K≥1 时，f(1,K)=1。
    //
    //那么问题来了：T 最大可以达到多少？由于我们在进行动态规划时，T 在题目中并没有给出，那么我们需要进行到动态规划的哪一步呢？
    // 可以发现，操作次数是一定不会超过楼层数的，因此 T≤N，我们只要算出在 f(N,K) 内的所有 f 值即可。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }
        // T次操作 有K个鸡蛋，最恶劣情况下能找到的N 为 f(T,K)
        int[][] f = new int[N + 1][K + 1];
        //初始化1次操作，能找到的都是1
        for (int i = 1; i <= K; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                //i次扔j个鸡蛋 = 1 + (i-1次扔j-1个鸡蛋（鸡蛋碎了）)+(i-1次扔j个鸡蛋（鸡蛋没碎）)
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        System.out.println(superEggDrop.superEggDrop(3, 14));
    }

}
