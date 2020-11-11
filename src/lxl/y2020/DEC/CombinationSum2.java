package lxl.y2020.DEC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-09 11:20
 **/
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> lists = this.combinationSumDeal(candidates, target, 0, candidates.length - 1);
        return lists;
    }

    private List<List<Integer>> combinationSumDeal(int[] candidates, int target, int offset, int maxOffset) {
        List<List<Integer>> lists = new ArrayList<>();
        if (offset > maxOffset) {
            return lists;
        } else if (offset == maxOffset) {
            if (target == candidates[offset]) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                lists.add(list);
            }
        } else if (candidates[offset] > target) {
            return lists;
        } else {
            int first = candidates[offset];
            int firstCount = 0;
            int count = 1;
            while (offset + count <= maxOffset && first == candidates[offset + count]) {
                count++;
            }
            while (firstCount <= count) {
                if (firstCount * first > target) {
                    break;
                }
                List<Integer> index = new ArrayList<>(Collections.nCopies(firstCount, first));
                if (first * firstCount == target) {
                    firstCount++;
                    lists.add(index);
                    continue;
                }
                List<List<Integer>> nextLists =
                        this.combinationSumDeal(candidates, target - first * firstCount, offset + count, maxOffset);
                if (index.size() <= 0) {
                    lists.addAll(nextLists);
                } else if (nextLists.size() > 0) {
                    for (List<Integer> nextList : nextLists) {
                        ArrayList<Integer> indexClone = new ArrayList<>(index);
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
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] nums = {1, 1};

        System.out.println(combinationSum2.combinationSum2(nums, 1));
    }

}
