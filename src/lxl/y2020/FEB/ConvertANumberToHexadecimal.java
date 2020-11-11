package lxl.y2020.FEB;

/**
 * @program: leetcode-hz
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
 * @author: lxl
 * @create: 2020-02-25 20:25
 **/
public class ConvertANumberToHexadecimal {
    //10-15 a-f
    //    负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
//
//            [+1] = [00000001]原 = [00000001]反 = [00000001]补
//
//[-1] = [10000001]原 = [11111110]反 = [11111111]补
    private char[] help = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        System.out.println(help.length);
        boolean positive = true;
        if (num < 0) {
            positive = false;
            num = 0 - num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int positiveNum = 1;
        while (num >= 16) {
            if (positive) {
                stringBuilder.append(help[num % 16]);
            } else {
                if (positiveNum > 0) {
                    if (num % 16 == 15) {
                        stringBuilder.append(help[0]);
                    } else {
                        stringBuilder.append(help[16 - num % 16]);
                        positiveNum = 0;
                    }
                } else {
                    stringBuilder.append(help[16 - num % 16]);
                }
            }
            num = num / 16;
        }

        //String re = stringBuilder.reverse().toString();
        //负数处理;
        if (!positive) {
            //stringBuilder.append(help[16-num+positiveNum]);

            if (positiveNum == 1) {
                //if(16-num+positiveNum == 16){
                //    stringBuilder.append("01");
                //}else{
                stringBuilder.append(help[16 - num + positiveNum - 1]);
                //}
            } else {
                stringBuilder.append(help[16 - num]);
            }
            while (stringBuilder.length() < 8) {
                stringBuilder.append('f');
            }
        } else {
            stringBuilder.append(help[num]);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal convertANumberToHexadecimal = new ConvertANumberToHexadecimal();
        System.out.println(convertANumberToHexadecimal.toHex(-17));
    }

}
