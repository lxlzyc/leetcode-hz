package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 476. 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-02 14:36
 **/
public class NumberComplement {
    public int findComplement(int num) {
        String result = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (char s : result.toCharArray()) {
            stringBuilder.append(s == '0' ? '1' : '0');
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    //题目要求即将num二进制各位由1变成0，0变成1，由此想到将各位与1做异或操作即可。如何找到与num二进制有效位（没有前导零位）个数相同且都是1的数呢？
    //只要找到比num最高1位的位置高一位（左边）就行了，此时该数必然大于num，如num=5（101B）时，这个数为8（1000B），将其减1，则得到与num有效二进制位数相同且各位都为1的数。如8-1=7（111B）
    //
    //作者：yannis-mcTi2ZZbHa
    //链接：https://leetcode-cn.com/problems/number-complement/solution/yi-huo-by-yannis-mcti2zzbha/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findComplement2(int num) {

        long num0 = 1;

        while (num0 <= num)
            num0 = num0 << 1;

        num0 -= 1;

        return (int) num0 ^ num;
    }

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(1));
    }
}
