package lxl.APR;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-06 10:00
 **/
public class IncreasingSubsequences {

    //vector<vector<int>> findSubsequences(vector<int>& nums) {
    //    vector<vector<int>> paths;
    //    vector<int> path;
    //
    //    DFS(paths, path, nums, 0);
    //
    //    return paths;
    //}
    //
    //void DFS(vector<vector<int>> &paths, vector<int> &path, vector<int> nums, int loc){
    //    // 先写终止条件
    //    if (loc == nums.size()){
    //        paths.push_back(path);
    //        return;
    //    }
    //
    //    // 按顺序访问分支
    //    for (int i=loc; i<nums.size(); ++i){
    //        path.push_back(nums[i]);        // 本节点处理
    //        DFS(paths, path, nums, i+1);    // 进入子分支
    //        path.pop_back();                // 恢复现场
    //    }
    //}

    private Set<String> set = new HashSet<>();
    //private Set<String>

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> lists = new ArrayList<>();
        this.dfsNums(lists, nums, 0, nums.length);
        return this.formatSet(set);
    }

    private List<List<Integer>> formatSet(Set<String> set) {
        List<List<Integer>> lists = new ArrayList<>();
        for (String str : set) {
            String[] strings = str.split(",");
            List<Integer> list = new ArrayList<>();
            for (String index : strings) {
                list.add(Integer.valueOf(index));
            }
            lists.add(list);
        }
        return lists;
    }

    private void dfsNums(List<Integer> lists, int[] nums, int i, int size) {
        if (lists.size() >= 2) {
            set.add(this.formatList(lists));
        }

        for (int j = i; j < size; j++) {
            if (lists.size() == 0 || lists.get(lists.size() - 1) <= nums[i]) {
                lists.add(nums[j]);
                this.dfsNums(lists, nums, j + 1, size);
                lists.remove(lists.size() - 1);
            }

        }
    }

    private String formatList(List<Integer> lists) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : lists) {
            stringBuilder.append(i).append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int nums[] = {4, 6, 7, 7};
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        System.out.println(increasingSubsequences.findSubsequences(nums));
    }

}
