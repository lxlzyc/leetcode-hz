package lxl.y2021.MAR;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/6 14:48
 * @Version 1.0
 */
public class ConvertANumberToHexadecimal {
    private char[] help = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = 0 - num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(help[num % 16]);
            num = num / 16;
        }
        if (flag) {
            return stringBuilder.reverse().toString();
        } else {
            //补码处理
            //...
            return "";
        }
    }

    //四位四位位移计算
    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int tmp = num & 15;
            stringBuilder.append(help[tmp]);
            num = num >>> 4;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal convertANumberToHexadecimal = new ConvertANumberToHexadecimal();
//        System.out.println(convertANumberToHexadecimal.toHex(0));
        System.out.println(convertANumberToHexadecimal.toHex2(-1));
//        System.out.println(convertANumberToHexadecimal.toHex(15));
//        System.out.println(convertANumberToHexadecimal.toHex(16));
//        System.out.println(convertANumberToHexadecimal.toHex(17));
//        System.out.println(convertANumberToHexadecimal.toHex(32));

    }
}