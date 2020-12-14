package lxl.y2019.DEC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 39.组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-09 10:27
 **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> lists = this.combinationSumDeal(candidates,target,0,candidates.length-1);
        //System.out.println(JSONUtil.toJson(lists));
        return lists;
    }

    private List<List<Integer>> combinationSumDeal(int[] candidates, int target,int offset,int maxOffset) {
        List<List<Integer>> lists = new ArrayList<>();
        if(offset == maxOffset){
            if(target%candidates[offset] == 0){
                List<Integer> list = new ArrayList<>(Collections.nCopies(target/candidates[offset],candidates[offset]));
                lists.add(list);
            }
        }else if(candidates[offset]>target){
            return lists;
        }else{
            int first = candidates[offset];
            int firstCount = 0;
            while (first*firstCount<=target){
                List<Integer> index = new ArrayList<>(Collections.nCopies(firstCount,first));
                if(first*firstCount == target){
                    firstCount++;
                    lists.add(index);
                    continue;
                }
                List<List<Integer>> nextLists = this.combinationSumDeal(candidates,target-first*firstCount,offset+1,maxOffset);
                if(index.size()<=0){
                    lists.addAll(nextLists);
                }else if(nextLists.size()>0){
                    for(List<Integer> nextList:nextLists){
                        ArrayList<Integer> indexClone =  new ArrayList<>(index);
                        indexClone.addAll(nextList);
                        lists.add(indexClone);
                    }

                }
                firstCount++;

            }
        }
        return lists;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {1};
        System.out.println(combinationSum.combinationSum(nums,2));
    }

}
