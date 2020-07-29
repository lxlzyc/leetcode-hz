package lxl.JUL;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 示例 2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * <p>
 * 示例 3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-29 15:08
 **/
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, 5));
    }

    //如果珂珂能以 K 的进食速度最终吃完所有的香蕉（在 H 小时内），那么她也可以用更快的速度吃完。
    //
    //当珂珂能以 K 的进食速度吃完香蕉时，我们令 possible(K) 为 true，那么就存在 X 使得当 K >= X 时， possible(K) = True。
    //
    //举个例子，当初始条件为 piles = [3, 6, 7, 11] 和 H = 8 时，存在 X = 4 使得 possible(1) = possible(2) = possible(3) = False，且 possible(4) = possible(5) = ... = True。
    //
    //算法
    //
    //我们可以二分查找 possible(K) 的值来找到第一个使得 possible(X) 为 True 的 X：这将是我们的答案。我们的循环中，不变量 possible(hi) 总为 True， lo 总小于等于答案。有关二分查找的更多信息，请参阅《力扣探索：二分查找》。
    //
    //为了找到 possible(K) 的值， (即珂珂是否能以 K 的进食速度在 H 小时内吃完所有的香蕉），我们模拟这一情景。对于每一堆（大小 p > 0），我们可以推断出珂珂将在 Math.ceil(p / K) = ((p-1) // K) + 1 小时内吃完这一堆，我们将每一堆的完成时间加在一起并与 H 进行比较。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/koko-eating-bananas/solution/ai-chi-xiang-jiao-de-ke-ke-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int minEatingSpeed(int[] piles, int H) {
        int minSpeed = 1;
        int maxSpeed = Arrays.stream(piles).max().getAsInt();
        int mid;
        int time;
        while (minSpeed < maxSpeed) {
            mid = (minSpeed + maxSpeed) >> 1;
            time = this.getTimes(piles, (double) mid);
            if (time > H) {
                minSpeed = mid + 1;
            } else {
                maxSpeed = mid;
            }
        }
        return minSpeed;
    }

    public int getTimes(int[] piles, double speed) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil(pile / speed);
        }
        return time;
    }


    public int minEatingSpeed2(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / K + 1;
        }
        return time <= H;
    }

}
