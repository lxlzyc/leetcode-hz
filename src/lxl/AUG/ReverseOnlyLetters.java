package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-07 13:44
 **/
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        int l = S.length();
        if (l <= 2) {
            return S;
        }
        char[] chars = S.toCharArray();
        int left = 0;
        int right = l - 1;
        while (true) {
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            } else {
                break;
            }
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
