package lxl.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-18 13:48
 **/
public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> re = this.deal(nums,0);
        List<Integer> emptyList = new ArrayList<>();
        re.add(emptyList);
        return re;
    }
    public List<List<Integer>> deal(int[] nums,int beginI) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = beginI,l=nums.length; i < l; i++) {
            int index =nums[i];
            List<List<Integer>> nexts = this.deal(nums,++beginI);
            if(nexts.size()>0){
                for (List<Integer> next:nexts ){
                    next.add(0,index);
                    lists.add(next);
                }
            }
            List<Integer> integers = new ArrayList<>();
            integers.add(index);
            lists.add(integers);
        }
        return lists;
    }

    //private int[] copyAndRemove(int[] nums, int offset) {
    //    if(nums.length == 0){
    //        return new int[1];
    //    }
    //    int[] cpnums = new int[nums.length-1];
    //    for (int i = 0,l=nums.length; i < l; i++) {
    //        if(i<offset){
    //            cpnums[i] = nums[i];
    //        }else if(i>offset){
    //            cpnums[i-1] = nums[i];
    //        }
    //    }
    //    return nums;
    //}

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(JSONUtil.toJson(subsets.subsets(nums)));
    }
}
