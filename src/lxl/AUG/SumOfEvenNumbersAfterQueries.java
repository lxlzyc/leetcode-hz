package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 985. 查询后的偶数和
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-19 14:16
 **/
public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }
        int[] ans = new int[queries.length];
        int offset;
        for (int i = 0, l = queries.length; i < l; i++) {
            offset = queries[i][1];
            if (A[offset] % 2 == 0) {
                sum -= A[offset];
            }
            A[offset] += queries[i][0];
            if (A[offset] % 2 == 0) {
                sum += A[offset];
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries = new SumOfEvenNumbersAfterQueries();
        int[] A = {1, 2, 3, 4};
        int[][] queries = {
                {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        };
        System.out.println(sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(A, queries));
    }
}
