package lxl.y2021.FEB;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * @date 2021/2/1 13:38
 * @Version 1.0
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int help = target / 2;
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i <= help; i++) {
            int index = i;
            int sum = i;
            while (sum < target) {
                index++;
                sum += index;
            }
            if (sum == target) {
                int[] arr = new int[index - i + 1];
                for (int j = i; j <= index; j++) {
                    arr[j - i] = j;
                }
                ans.add(arr);
            }
        }
        int[][] result = new int[ans.size()][];
        int offset = 0;
        for (int[] item : ans) {
            result[offset++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        System.out.println(findContinuousSequence.findContinuousSequence(9));
    }
}