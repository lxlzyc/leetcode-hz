package lxl.y2021.NOV;

/**
 * @program: leetcode-hz
 * @description: 1089. 重复零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-18 17:02
 **/
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {

        int[] num = new int[arr.length];
        int[] arrcopy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            //赋值一个与原数组一样的数组
            arrcopy[i] = arr[i];
        }
        int dis = 0;
        for (int i = 0; i < arr.length; i++) {
            //记录因为0的出现，导致的每一个元素应该偏移的量dis，记录于num数组。
            if (arr[i] == 0) {
                dis++;
            }
            num[i] = dis;
        }
        //如果没有0，直接返回了
        if (dis == 0) return;
        //初始化原数组，置为0
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        //偏移量作用
        for (int i = 0; i + num[i] < arr.length; i++) {
            arr[i + num[i]] = arrcopy[i];
        }
    }

}
