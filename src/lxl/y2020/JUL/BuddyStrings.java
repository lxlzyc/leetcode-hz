package lxl.y2020.JUL;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * <p>
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * <p>
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * <p>
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * <p>
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-24 16:31
 **/
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        int al = A.length();
        int bl = B.length();
        if (al != bl || al < 2 || bl < 2) {
            return false;
        }
        int[] dif = new int[3];
        int count = 0;
        for (int i = 0; i < al; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                dif[count] = i;
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        if (count == 0) {
            char[] chars = A.toCharArray();
            Arrays.sort(chars);
            for (int i = 1; i < al; i++) {
                if (chars[i] == chars[i - 1]) {
                    return true;
                }
            }
            return false;
        }
        if (count == 2
                && A.charAt(dif[0]) == B.charAt(dif[1])
                && B.charAt(dif[0]) == A.charAt(dif[1])
                ) {
            return true;
        }
        return false;
    }
}
