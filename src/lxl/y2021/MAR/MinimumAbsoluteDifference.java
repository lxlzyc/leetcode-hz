package lxl.y2021.MAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/9 14:32
 * @Version 1.0
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1, l = arr.length; i < l; i++) {
            int help = arr[i] - arr[i - 1];
            if (help > min) {
                continue;
            }
            if (help < min) {
                result.clear();
                min = help;
            }
            result.add(Arrays.asList(new Integer[]{arr[i - 1], arr[i]}));
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsoluteDifference.minimumAbsDifference(arr));
    }
}