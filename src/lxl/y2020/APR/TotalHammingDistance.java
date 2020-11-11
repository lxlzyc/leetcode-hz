package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * <p>
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 * @author: lxl
 * @create: 2020-04-03 13:32
 **/
public class TotalHammingDistance {

    //汉明距离等于两个数二进制表示中对应位置不同的数量。假设数组中的每个数都表示为 k 位的二进制数（高位补 0），
    //那么我们可以发现，要计算数组中任意两个数的汉明距离的总和，可以先算出数组中任意两个数二进制第 i 位的汉明
    //距离的总和，在将所有的 k 位之和相加。也就是说，二进制中的每一位都是可以独立计算的。
    //
    //因此，我们考虑数组中每个数二进制的第 i 位，假设一共有 t 个 0 和 n - t 个 1，那么显然在第 i 位的汉明距离
    //的总和为 t * (n - t)。
    //
    //由于所有的数都在 [0, 10^9] 的范围内，因此 k 最大为 31。我们只要计算出每一位上的汉明距离的总和，再相加即可。
    public int totalHammingDistance(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int sum = 0;
        int[] oneCounts = new int[32];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 32; j++) {
                //按位“与”操作符，如果两个数的二进制，相同位数都是1，则该位结果是1，否则是0.
                //判断二进制最后一位是不是1
                oneCounts[j] += nums[i] & 1;
                // “有符号”右移位操作符（>>）则按照操作符右侧指定的位数将操作符左边的操作数向右移。
                // “有符号”右移位操作符使用“符号扩展”；若符号位正，则在高位插入0；若符号位负。则在高位插入1。
                // 二进制右移
                nums[i] = nums[i] >> 1;
                // 右移后 = 0 无需继续判断
                if (nums[i] == 0) {
                    break;
                }
            }
        }
        for (int one : oneCounts) {
            sum += one * (length - one);
        }
        return sum;
    }


    //public int hammingDistance(int x, int y) {
    //    return Integer.bitCount(x ^ y);
    //}
}
