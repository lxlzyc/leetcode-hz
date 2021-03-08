package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1051. 高度检查器
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * <p>
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 当前数组：[1,1,4,2,1,3]
 * 目标数组：[1,1,1,2,3,4]
 * 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 * 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 * 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 * <p>
 * 示例 2：
 * <p>
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * <p>
 * 示例 3：
 * <p>
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/8 10:38
 * @Version 1.0
 */
public class HeightChecker {
    //    首先我们进行一轮桶排序，即查看一个桶里装了几个元素，例如 1 4 3 1 5，a[1]=2:数值是1的桶装了两个1；
//    然后从小到大的位置开始检查对应位置是否对应正确的值。
//    不对应的就sum+1;
//
//    作者：bobola
//    链接：https://leetcode-cn.com/problems/height-checker/solution/jian-dan-de-tong-pai-xu-by-bobola/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];//申请101个空间，因为1 <= heights[i] <= 100，所以需要的桶可能从1到100
        int sum = 0;
        for (int height : heights) {
            arr[height]++;//遍历每个桶里面有几个元素，如1 1 2 3 4 1 则arr[1]=3,arr[2]=1,
        }
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {//从小位置开始检查当前位置对应的值是否是正确的，如arr[1]=3,也就代表第1个位置，第二个位置，第三个位置都应该是1，
                if (heights[j++] != i) {
                    //开始判断对应的位置上对应的值是否正确，如arr[1]=3，数组heights [0]下标开始存储，
                    // 因为有三个1（1是最小的）判断第一个位置heights[0]、第二个位置heights[1]、
                    // 第三个位置heights[2]是否等于1，否sum++
                    sum++;
                }
            }
        }
        return sum;
    }
}