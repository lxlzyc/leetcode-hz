package lxl.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-12 17:55
 **/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }
        List<Integer> sortList = new ArrayList<>();
        int left;
        int right;
        int listLeft;
        int listRight;
        for (int i = 0; i < length; i++) {
            boolean insert = false;
            left = intervals[i][0];
            right = intervals[i][1];

            for (int j = 0; j < sortList.size(); j = j + 2) {
                listLeft = sortList.get(j);
                listRight = sortList.get(j + 1);
                if (right < listLeft) {
                    sortList.add(j, right);
                    sortList.add(j, left);
                    insert = true;
                    break;
                }
                if (left <= listRight) {
                    sortList.set(j, Math.min(left, listLeft));
                    if(right>listRight){
                        sortList.set(j + 1, right);
                        while (j + 2 < sortList.size()) {
                            listLeft = sortList.get(j + 2);
                            listRight = sortList.get(j + 3);
                            if (listLeft <= right) {
                                if (right < listRight) {
                                    sortList.remove(j + 1);
                                    sortList.remove(j + 1);
                                    break;
                                } else {
                                    sortList.remove(j + 2);
                                    sortList.remove(j + 2);
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    insert = true;
                    break;
                }
            }
            if (!insert) {
                sortList.add(left);
                sortList.add(right);
            }
        }
        int[][] re = new int[sortList.size() / 2][2];
        int[] index;
        for (int i = 0, l = sortList.size()/2; i < l; i++) {
            index = new int[2];
            index[0] = sortList.get(i*2);
            index[1] = sortList.get(i*2 + 1);
            re[i] = index;
        }
        return re;

    }


    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] re = mergeIntervals.merge(intervals);
        for(int[] inner:re){
            System.out.println(JSONUtil.toJson(inner));

        }
    }

}
