package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * <p>
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-17 10:38
 **/
public class LongestMountainInArray {

    private int max = 0;

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return max;
        }
        this.maxMounTain(A, A.length / 2, 1);
        return max;
    }

    public void maxMounTain(int[] A, int mid, int direction) {
        if (mid >= A.length - 1) {
            return;
        }
        if (mid < 1) {
            return;
        }
        int big = 0;
        while (mid + big < A.length - 1) {
            if (A[mid + big + 1] < A[mid + big]) {
                big++;
            } else {
                break;
            }
        }
        int small = 0;
        while (mid - small > 0) {
            if (A[mid - small] > A[mid - small - 1]) {
                small++;
            } else {
                break;
            }
        }
        if (big > 0 && small > 0) {
            max = Math.max(big + small + 1, max);
            if (direction >= 1) {
                //向右
                this.maxMounTain(A, mid + big * 2, 2);
            }
            if (direction <= 1) {
                //向左
                this.maxMounTain(A, mid - small * 2, 0);
            }
        } else {
            if (direction >= 1) {
                //向右
                this.maxMounTain(A, mid + big + 1, 2);
            }
            if (direction <= 1) {
                //向左
                this.maxMounTain(A, mid - small - 1, 0);
            }
        }
    }

    public static void main(String[] args) {
        LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
        int[] A = {1, 2, 2, 2};
        System.out.println(longestMountainInArray.longestMountain(A));
    }
}
