package lxl.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-13 13:31
 **/
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] sumIntervals = Arrays.copyOf(intervals, intervals.length+1);
        sumIntervals[sumIntervals.length-1] = newInterval;

        int length = intervals.length;
        //if (length <= 1) {
        //    return intervals;
        //}
        List<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] inner = intervals[i];
            sortList.add(inner[0]);
            sortList.add(inner[1]);
        }

        int left = newInterval[0];
        int right = newInterval[1];
        int begin = this.dichotomy(sortList,0,left);
        System.out.println(JSONUtil.toJson(sortList));
        System.out.println("begin = "+begin);

        List<Integer> returnList = new ArrayList<>();
        if(begin%2==0){
            sortList.set(begin,left);
            begin = begin +1;
        }
        System.out.println(JSONUtil.toJson(sortList));
        System.out.println("begin = "+begin);

        while (begin<sortList.size()){
            if(sortList.get(begin)<right){
                sortList.remove(begin);
            }else if(sortList.get(begin)>right){
                if(sortList.size()%2 == 1){
                    sortList.add(begin,right);
                }
                break;
            }else{
                if(sortList.size()%2 == 1){
                    sortList.remove(begin);
                }
                break;
            }
        }
        System.out.println(JSONUtil.toJson(sortList));

        System.out.println();


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

    private int dichotomy(List<Integer> sortList,int left, int i) {
        int size = sortList.size()-1;
        int right = size;
        int half = 0;
        while (left<right){
            half = left + right >> 1;
            if(sortList.get(half) > i){
                //if(half - 1>0 && sortList.get(half -1 )<i){
                //    half = half -1;
                //    break;
                //}
                right = half-1;
            }else if(sortList.get(half)<i){
                //if(half + 1< size && sortList.get(half +1 )>i){
                //    break;
                //}
                left = half+1;
            }else{
                break;
            }
        }
        int index = sortList.get(half);
        if(index < i){
            half = half + 1;
        }
        return half;
    }


    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int[][] sumIntervals = Arrays.copyOf(intervals, intervals.length+1);
        sumIntervals[sumIntervals.length-1] = newInterval;
        return this.merge(sumIntervals);
    }

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
        InsertInterval insert = new InsertInterval();
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        int[][] intervals = {{1, 3}, {6,9}};
        int[] newInterval = {11,12};
        int[][] re = insert.insert(intervals,newInterval);
        for(int[] inner:re){
            System.out.println(JSONUtil.toJson(inner));

        }
    }
}
