package lxl.DEC;

/**
 * @program: leetcode-hz
 * @description: 35. 搜索插入位置
 * @author: lxl
 * @create: 2019-12-05 17:39
 **/
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left =0;
        int right =length-1;
        int middle;
        int offset = -1;
        while (left<=right){
            middle = (left + right) >>> 1;
            if(nums[middle] == target){
                offset = middle;
                break;
            }else if(nums[middle]>target){
                if(left >= right-1){
                    offset = left;
                }
                right = middle-1;

            }else{
                if(left >= right-1){
                    offset = left+1;
                }
                left = middle+1;
            }
        }

        return offset;
    }


    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1,3,5,7,9};
        System.out.println(searchInsertPosition.searchInsert(nums,2));
    }

}
