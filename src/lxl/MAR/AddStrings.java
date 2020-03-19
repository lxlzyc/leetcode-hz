package lxl.MAR;

/**
 * @program: leetcode-hz
 * @description: 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @author: lxl
 * @create: 2020-03-19 14:49
 **/
public class AddStrings {
    //0-9 48-57
    public String addStrings(String num1, String num2) {
        if (num1.isEmpty() && num2.isEmpty()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        int help = 0;
        int n1 = 0;
        int n2 = 0;
        int sum;
        while (length1 >= 0 || length2 >= 0) {
            if (length1 >= 0) {
                n1 = num1.charAt(length1) - 48;
                length1--;
            }
            if (length2 >= 0) {
                n2 = num2.charAt(length2) - 48;
                length2--;
            }
            sum = n1 + n2 + help;
            if (sum >= 10) {
                stringBuilder.append(sum - 10);
                help = 1;
            } else {
                stringBuilder.append(sum);
                help = 0;
            }
            n1 = 0;
            n2 = 0;
        }
        if (help > 0) {
            stringBuilder.append(help);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("", ""));
    }
}
