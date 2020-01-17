package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 307. 区域和检索 - 数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * <p>
 * 说明:
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-17 10:37
 **/
public class RangeSumQueryMutable {

    private int[] sums;
    private int[] nums;
    private int length;

    public RangeSumQueryMutable(int[] nums) {
        length = nums.length;
        sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        int valchange = val - nums[i];
        while (i < length) {
            sums[i + 1] = sums[i + 1] + valchange;
            i++;
        }
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        System.out.println(sums[j + 1] - sums[i]);
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
//        ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
//[[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
        int[] nums = {7, 2, 7, 2, 0};
        RangeSumQueryMutable rangeSumQueryMutable = new RangeSumQueryMutable(nums);
        rangeSumQueryMutable.update(4, 6);

        rangeSumQueryMutable.update(0, 2);
        rangeSumQueryMutable.update(0, 9);
        rangeSumQueryMutable.sumRange(4, 4);
        rangeSumQueryMutable.update(3, 8);
        rangeSumQueryMutable.sumRange(0, 4);
        rangeSumQueryMutable.update(4, 1);
        rangeSumQueryMutable.sumRange(0, 3);
        rangeSumQueryMutable.sumRange(0, 4);
        rangeSumQueryMutable.update(0, 4);


    }

}
