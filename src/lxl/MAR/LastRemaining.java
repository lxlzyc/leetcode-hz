package lxl.MAR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-30 11:03
 **/
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        if (n == 2) {
            if (m % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

    public int lastRemaining2(int n, int m) {
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        int count = 0;
        int index = 0;
        int mcount = 0;
        while (count < n - 1) {
            if (m > n - count) {
                m = m % (n - count);
            }
            if (index == n) {
                index = 0;
            }
            if (nums[index] == 1) {
                mcount++;
                if (mcount == m) {
                    mcount = 0;
                    nums[index] = 0;
                    count++;
                }
            }
            index++;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                return i;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(5, 3));
        System.out.println(lastRemaining.lastRemaining(10, 17));

        System.out.println(lastRemaining.lastRemaining2(5, 3));
        System.out.println(lastRemaining.lastRemaining2(10, 17));

    }

}
