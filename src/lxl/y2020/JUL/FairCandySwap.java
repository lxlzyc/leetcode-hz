package lxl.y2020.JUL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 888. 公平的糖果交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-30 13:40
 **/
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int inner = (sumB - sumA) / 2;
        for (int b : B) {
            if (Arrays.binarySearch(A, b - inner) >= 0) {
                return new int[]{b - inner, b};
            }
        }
        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        Set<Integer> nums = new HashSet<>();
        int sumA = 0;
        for (int a : A) {
            nums.add(a);
            sumA += a;
        }
        int sumB = Arrays.stream(B).sum();
        int inner = (sumB - sumA) / 2;
        for (int b : B) {
            if (nums.contains(b - inner)) {
                return new int[]{b - inner, b};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FairCandySwap fairCandySwap = new FairCandySwap();
        int[] A = {2};
        int[] B = {1, 3};
        System.out.println(Arrays.toString(fairCandySwap.fairCandySwap2(A, B)));
    }

}
