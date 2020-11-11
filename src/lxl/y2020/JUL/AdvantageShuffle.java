package lxl.y2020.JUL;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-28 14:00
 **/
public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int l = A.length;
        if (l <= 1) {
            return A;
        }
        Arrays.sort(A);
        int[] re = new int[l];
        int[] tempB = new int[l];
        for (int i = 0; i < l; i++) {
            re[i] = -1;
            tempB[i] = B[i];
        }
        Arrays.sort(tempB);
        int offsetA = l - 1;
        Map<Integer, List<Integer>> help = new HashMap<>();

        for (int i = l - 1; i >= 0; i--) {
            if (tempB[i] < A[offsetA]) {
                List<Integer> integers = help.getOrDefault(tempB[i], new ArrayList<>());
                integers.add(A[offsetA]);
                help.put(tempB[i], integers);
                offsetA--;
            }
        }
        offsetA = 0;
        for (int i = 0; i < l; i++) {
            if (help.containsKey(B[i])) {
                List<Integer> integers = help.getOrDefault(B[i], new ArrayList<>());
                int index = integers.get(0);
                re[i] = index;
                integers.remove(0);
                if (integers.isEmpty()) {
                    help.remove(B[i]);
                } else {
                    help.put(B[i], integers);
                }
            } else {
                re[i] = A[offsetA];
                offsetA++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        AdvantageShuffle advantageShuffle = new AdvantageShuffle();
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};
        System.out.println(Arrays.toString(advantageShuffle.advantageCount(A, B)));

    }
}
