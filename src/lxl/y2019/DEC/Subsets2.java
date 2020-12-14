package lxl.y2019.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-18 13:48
 **/
public class Subsets2 {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = this.deal(nums, 0);
        List<Integer> emptyList = new ArrayList<>();
        re.add(emptyList);
        return re;
    }

    public List<List<Integer>> deal(int[] nums, int beginI) {
        List<List<Integer>> lists = new ArrayList<>();
        int begin = beginI;
        for (int i = begin, l = nums.length; i < l; i++) {
            int index = nums[i];
            if (i > begin && index == nums[i - 1]) {
                beginI++;
                continue;
            }
            List<List<Integer>> nexts = this.deal(nums, ++beginI);
            if (nexts.size() > 0) {
                for (List<Integer> next : nexts) {
                    next.add(0, index);
                    lists.add(next);
                }
            }
            List<Integer> integers = new ArrayList<>();
            integers.add(index);
            lists.add(integers);
        }
        return lists;
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        int[] nums = {1, 2, 2};
        System.out.println(JSONUtil.toJson(subsets.subsetsWithDup(nums)));
    }
}
