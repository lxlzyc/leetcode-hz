package lxl.y2019.NOV;

/**
 * @program: leetcode-hz
 * @description: 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 最优解 new 1001的数组
 * @author: lxl
 * @create: 2019-11-20 14:00
 **/
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int left = 0;
        int maxlength = arr1.length;
        int help;
        for (int arr_index : arr2) {
            for (int i = left; i < maxlength; i++) {
                if (arr1[i] == arr_index) {
                    help = arr1[left];
                    arr1[left] = arr1[i];
                    arr1[i] = help;
                    left++;
                }
            }
        }
        if (left < arr1.length) {
            for (int i = left; i < maxlength - 1; i++) {
                for (int j = left; j < maxlength - 1 - i + left; j++) {
                    if (arr1[j] > arr1[j + 1]) {
                        help = arr1[j];
                        arr1[j] = arr1[j + 1];
                        arr1[j + 1] = help;
                    }
                }
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19, 17, 20, 15, 18};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr3 = relativeSortArray.relativeSortArray(arr1, arr2);
        for (int i : arr3) {
            System.out.print(i + ",");
        }
    }

}
