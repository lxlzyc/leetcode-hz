package lxl.y2020.DEC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-11 17:52
 **/
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if(length==0){
            return null;
        }
        List<List<Integer>> re = new ArrayList<>();
        if(length == 1){
            List<Integer> index = new ArrayList<>();
            index.add(nums[0]);
            re.add(index);
            return re;
        }
        Arrays.sort(nums);
        re = this.initPermute(nums,length);
        return re;
    }

    private List<List<Integer>> initPermute(int[] nums, int length) {
        List<List<Integer>> re = new ArrayList<>();
        if(length<=0){
            return re;
        }
        for (int i = 0; i < length; i++) {
            if(i>0){
                if(nums[i] == nums[i-1]){
                    continue;
                }
            }
            List<List<Integer>> nextPermute = this.initPermute(this.numsRemoveIndex(nums,i,length),length-1);
            if(nextPermute != null && nextPermute.size()>0){
                for (List<Integer> index:nextPermute){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(index);
                    re.add(list);
                }
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                re.add(list);
            }
        }
        return re;

    }

    private int[] numsRemoveIndex(int[] arr, int position,int length) {
        if(position >= length || position < 0){
            return null;
        }
        int[] res = new int[length - 1];
        for(int i = 0;i<length-1;i++){
            if(i < position){
                res[i] = arr[i];
            }else{
                res[i] = arr[i + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Permutations2 permutations = new Permutations2();
        int[] nums = {1,1,2};
        System.out.println(permutations.permuteUnique(nums));
    }

}
