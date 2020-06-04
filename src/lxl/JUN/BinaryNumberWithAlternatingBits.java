package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * <p>
 * 示例 2:
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * <p>
 * 示例 3:
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * <p>
 * 示例 4:
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-04 14:13
 **/
public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        char[] num = Integer.toBinaryString(n).toCharArray();
        for (int i = 1, l = num.length; i < l; i++) {
            if (num[i] == num[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //位运算
    public boolean hasAlternatingBits2(int n) {
        int pre = n & 1;
        n >>>= 1;
        while (n != 0) {
            if ((n & 1) == pre)
                return false;
            pre = n & 1;
            n >>>= 1;
        }
        return true;
    }

}
