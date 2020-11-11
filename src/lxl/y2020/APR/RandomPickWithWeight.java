package lxl.y2020.APR;

import java.util.Random;

/**
 * @program: leetcode-hz
 * @description: 528. 按权重随机选择
 * 给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
 * <p>
 * 说明:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出: [null,0]
 * <p>
 * 示例2:
 * <p>
 * 输入:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出: [null,0,1,1,1,0]
 * <p>
 * 输入语法说明：
 * <p>
 * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex 没有参数。
 * 输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-16 15:54
 **/
public class RandomPickWithWeight {


    private int[] line;
    private int sum;
    private Random random = new Random();
    private int l;

    public RandomPickWithWeight(int[] w) {
        l = w.length;
        sum = 0;
        line = new int[l];
        for (int i = 0; i < l; i++) {
            sum += w[i];
            line[i] = sum - 1;
        }
    }

    public int pickIndex() {
        if (l <= 1) {
            return 0;
        }
        int r = random.nextInt(sum);
        int mid = this.search(line, r);
        if (line[mid] < r) {
            return mid + 1;
        }
        return mid;
    }

    private int search(int[] array, int value) {
        int low = 0;
        int high = l - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                high = mid - 1;
            }
            if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 8};
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(nums);
        for (int i = 0; i < 20; i++) {
            System.out.println(randomPickWithWeight.pickIndex());
        }
    }
}
