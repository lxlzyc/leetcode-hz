package lxl.y2019.NOV;

/**
 * @program: leetcode-hz
 * @description: 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-28 14:45
 **/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = length;
        int maxRightHeight = 0;
        int maxLeftHeight = 0;

        int max = Math.min(height[left], height[right - 1]) * (right - 1);

        while (right > 1) {
            right--;
            if (height[right] <= maxRightHeight) {
                continue;
            }
            maxRightHeight = height[right];
            while (left < length - 1) {
                if (height[left] >= maxRightHeight) {
                    max = Math.max(maxRightHeight * (right - left), max);
                    break;
                } else if (height[left] > maxLeftHeight) {
                    maxLeftHeight = height[left];
                    max = Math.max(maxLeftHeight * (right - left), max);
                }
                left++;
            }
            left = 0;
            maxLeftHeight = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1, 2};

        System.out.println(containerWithMostWater.maxArea(height));
    }
}
