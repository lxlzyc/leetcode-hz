package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 853. 车队
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * <p>
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * <p>
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * <p>
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * <p>
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * <p>
 * <p>
 * 会有多少车队到达目的地?
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * 所有车的初始位置各不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/car-fleet
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-23 15:57
 **/
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = position.length;
        if (l <= 1) {
            return l;
        }
        this.quickSort(position, speed, 0, l - 1);

        double[] times = new double[l];
        for (int i = 0; i < l; i++) {
            times[i] = (double) (target - position[i]) / speed[i];
        }
        int count = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (i < l - 1 && times[i] <= times[i + 1]) {
                times[i] = times[i + 1];
            } else {
                count++;
            }

        }
        return count;
    }

    private void quickSort(int[] nums, int[] speed, int left, int right) {
        if (left >= right) {
            return;
        }
        int lo = left + 1;
        int hi = right;
        while (lo <= hi) {
            if (nums[lo] > nums[left]) {
                this.swap(nums, speed, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
        lo--;
        swap(nums, speed, left, lo);

        quickSort(nums, speed, left, lo - 1);
        quickSort(nums, speed, lo + 1, right);

    }

    private void swap(int[] nums, int[] speed, int lo, int hi) {
        int help = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = help;
        int help2 = speed[lo];
        speed[lo] = speed[hi];
        speed[hi] = help2;
    }

    public static void main(String[] args) {
        int target = 10;
        int[] position = {8, 3, 7, 4, 6, 5};
        int[] speed = {4, 4, 4, 4, 4, 4};

        CarFleet carFleet = new CarFleet();
        System.out.println(carFleet.carFleet(target, position, speed));
    }
}
