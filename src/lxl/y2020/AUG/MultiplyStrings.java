package lxl.y2020.AUG;

/**
 * @program: leetcode-hz
 * @description: 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-13 09:45
 **/
public class MultiplyStrings {
    //模拟
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] nums1 = new int[l1];
        int[] nums2 = new int[l2];
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            nums1[l1 - 1 - i] = num1.charAt(i) - '0';
        }
        for (int i = l2 - 1; i >= 0; i--) {
            nums2[l2 - 1 - i] = num2.charAt(i) - '0';
        }
        int index;
        int big;
        int value;
        for (int i = 0; i < l1; i++) {
            index = nums1[i];
            big = 0;
            for (int j = 0; j < l2; j++) {
                value = index * nums2[j] + big;
                big = value / 10;
                ans[i + j] += value % 10;
                if (ans[i + j] >= 10) {
                    ans[i + j] -= 10;
                    big++;
                }
            }
            if (big > 0) {
                ans[i + l2] += big;
            }
        }

        return this.getValue(ans);
    }

    private String getValue(int[] ans) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean begin = false;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (begin) {
                stringBuilder.append(ans[i]);
            } else {
                if (ans[i] > 0) {
                    stringBuilder.append(ans[i]);
                    begin = true;
                }
            }
        }
        return stringBuilder.toString().isEmpty() ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("9", "9"));
    }
}
