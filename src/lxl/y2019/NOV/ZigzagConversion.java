package lxl.y2019.NOV;

/**
 * @program: leetcode-hz
 * @description: 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * LDREOEIIECIHNTSG
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-26 17:12
 **/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 1) {
            return s;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int zlengh = numRows + numRows - 2;
        int zCount = length / zlengh + 1;//构建成z的数
        int index;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < zCount; j++) {
                if (i < numRows - 1) {
                    index = zlengh * j + i;
                    if (index >= 0 && index < length) {
                        stringBuffer.append(chars[index]);
                    }
                }
                if (i > 0) {
                    index = zlengh * (j + 1) - i;
                    if (index > 0 && index < length) {
                        stringBuffer.append(chars[index]);
                    }
                }

            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("LEETCODEISHIRING", 3));
    }

}
