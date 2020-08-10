package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 5468. 第 k 个缺失的正整数
 * <p>
 * <p>
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 * @author: lxl
 * @create: 2020-08-08 22:32
 **/
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {

        int l = arr.length;
        int ans = k;
        for (int i = 0; i < l; i++) {
            if (arr[i] > ans) {
                return ans;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 7, 11};
        int[] b = {1, 2, 3, 4};
        FindKthPositive findKthPositive = new FindKthPositive();
        System.out.println(findKthPositive.findKthPositive(a, 1));
        System.out.println(findKthPositive.findKthPositive(b, 2));

    }
}
