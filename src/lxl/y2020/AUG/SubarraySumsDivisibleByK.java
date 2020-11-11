package lxl.y2020.AUG;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-18 11:46
 **/
public class SubarraySumsDivisibleByK {

    //通常，涉及连续子数组问题的时候，我们使用前缀和来解决。
    //
    //我们令 P[i]=A[0]+A[1]+...+A[i]P[i] = A[0] + A[1] + ... + A[i]P[i]=A[0]+A[1]+...+A[i]。那么每个连续子数组的和 sum(i,j)\textit{sum}(i, j)sum(i,j) 就可以写成 P[j]−P[i−1]P[j] - P[i-1]P[j]−P[i−1]（其中 0<i<j0 < i < j0<i<j）的形式。此时，判断子数组的和能否被 KKK 整除就等价于判断 (P[j]−P[i−1]) mod K==0(P[j] - P[i-1]) \bmod K == 0(P[j]−P[i−1])modK==0，根据 同余定理，只要 P[j] mod K==P[i−1] mod KP[j] \bmod K == P[i-1] \bmod KP[j]modK==P[i−1]modK，就可以保证上面的等式成立。
    //
    //因此我们可以考虑对数组进行遍历，在遍历同时统计答案。当我们遍历到第 iii 个元素时，我们统计以 iii 结尾的符合条件的子数组个数。我们可以维护一个以前缀和模 KKK 的值为键，出现次数为值的哈希表 record\textit{record}record，在遍历的同时进行更新。这样在计算以 iii 结尾的符合条件的子数组个数时，根据上面的分析，答案即为 [0..i−1][0..i-1][0..i−1] 中前缀和模 KKK 也为 P[i] mod KP[i] \bmod KP[i]modK 的位置个数，即 record[P[i] mod K]\textit{record}[P[i] \bmod K]record[P[i]modK]。
    //
    //最后的答案即为以每一个位置为数尾的符合条件的子数组个数之和。需要注意的一个边界条件是，我们需要对哈希表初始化，记录 record[0]=1\textit{record}[0] = 1record[0]=1，这样就考虑了前缀和本身被 KKK 整除的情况。
    //
    //注意：不同的语言负数取模的值不一定相同，有的语言为负数，对于这种情况需要特殊处理。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;

    }

    //超时
    public int subarraysDivByK2(int[] A, int K) {
        int l = A.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
