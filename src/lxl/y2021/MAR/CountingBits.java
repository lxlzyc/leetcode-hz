package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/3 9:33
 * @Version 1.0
 */
public class CountingBits {
    //    对于所有的数字，只有两类：
//    奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
//    举例：
//            0 = 0       1 = 1
//            2 = 10      3 = 11
//    偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，
//         也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
//    另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
//
//    作者：duadua
//    链接：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                bits[i] = bits[i / 2];
            } else {
                bits[i] = bits[i - 1] + 1;
            }
        }
        return bits;
    }
}