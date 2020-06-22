package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 775. 全局倒置与局部倒置
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，
 * 局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
 * <p>
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [1,0,2]
 * 输出: true
 * 解释: 有 1 个全局倒置，和 1 个局部倒置。
 * <p>
 * 示例 2:
 * <p>
 * 输入: A = [1,2,0]
 * 输出: false
 * 解释: 有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 注意:
 * <p>
 * A 是 [0, 1, ..., A.length - 1] 的一种排列
 * A 的长度在 [1, 5000]之间
 * 这个问题的时间限制已经减少了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/global-and-local-inversions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-22 11:26
 **/
public class GlobalAndLocalInversions {
    //一个局部倒置也是一个全局倒置，因此只需要检查有没有非局部倒置就可以了。这里的非局部倒置指的是 A[i] > A[j], i < j，其中 j - i > 1。
    //思路
    //
    //暴力法中需要检查是否存在满足 j >= i+2 的 A[i] > A[j]，这和检查 A[i] > min(A[i+2:]) 是等价的。如果提前计算出 min(A[0:]), min(A[1:]), min(A[2:]), ...
    // 这些区间的最小值，就可以立即完成检查操作。
    //
    //算法
    //
    //从右往左遍历数组 A，保存见到的最小的数。定义 floor = min(A[i:]) 来保存最小的数，如果 A[i-2] > floor，直接返回 False，当遍历结束都没有返回 False，返回 True。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/global-and-local-inversions/solution/quan-ju-dao-zhi-yu-ju-bu-dao-zhi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        int floor = N;
        for (int i = N - 1; i >= 2; --i) {
            floor = Math.min(floor, A[i]);
            if (A[i - 2] > floor) {
                return false;
            }
        }
        return true;

    }

    public boolean isIdealPermutation2(int[] A) {
        for (int i = 0; i < A.length; ++i)
            if (Math.abs(A[i] - i) > 1)
                return false;
        return true;
    }

    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/global-and-local-inversions/solution/quan-ju-dao-zhi-yu-ju-bu-dao-zhi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
