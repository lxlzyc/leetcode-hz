package lxl.y2020.SEP;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-09-07 17:30
 **/
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (true) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (right > left && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else {
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        System.out.println(reverseVowelsOfAString.reverseVowels("leetcode"));
    }
}
