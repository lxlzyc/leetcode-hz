package lxl.DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 46.全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-09 15:11
 **/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
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
        re = this.initPermute(nums,length);
        return re;
    }

    private List<List<Integer>> initPermute(int[] nums, int length) {
        List<List<Integer>> re = new ArrayList<>();
        if(length<=0){
            return re;
        }
        for (int i = 0; i < length; i++) {

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
        Permutations permutations = new Permutations();
        int[] nums = {1,3,4,5,6};
        System.out.println(permutations.permute(nums));
    }


}
