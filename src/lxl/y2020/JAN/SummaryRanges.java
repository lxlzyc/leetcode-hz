package lxl.y2020.JAN;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 228. 汇总区间
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 11:42
 **/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> re = new ArrayList<>();
        if (nums.length <= 0) {
            return re;
        }
        Integer[] summary = new Integer[2];
        summary[0] = nums[0];
        //int summaryOffset = 1;
        for (int i = 1, l = nums.length; i < l; i++) {
            int index = nums[i];
            //if(summaryOffset == 0){
            //    summary[0] = index;
            //    summaryOffset = 1;
            //}else{
            if (summary[1] == null) {
                if (index - 1 == summary[0]) {
                    summary[1] = index;
                } else {
                    re.add("" + summary[0]);
                    summary[0] = index;
                }
            } else {
                if (index - 1 == summary[1]) {
                    summary[1] = index;
                } else {
                    re.add(summary[0] + "->" + summary[1]);
                    summary[0] = index;
                    summary[1] = null;

                }
            }
            //}
        }
        if (summary[0] != null) {
            if (summary[1] != null) {
                re.add(summary[0] + "->" + summary[1]);
            } else {
                re.add("" + summary[0]);
            }
        }
        for (String s : re) {
            System.out.println(s);
        }
        return re;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges.summaryRanges(nums));
    }

}
