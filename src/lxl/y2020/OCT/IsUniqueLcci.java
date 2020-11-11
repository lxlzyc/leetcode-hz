package lxl.y2020.OCT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 面试题
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-22 10:30
 **/
public class IsUniqueLcci {

    //01.01. 判定字符是否唯一
    //https://leetcode-cn.com/problems/is-unique-lcci/
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for (int i = 1, l = chars.length; i < l; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 01.02. 判定是否互为字符重排
    // https://leetcode-cn.com/problems/check-permutation-lcci/
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0, l = chars1.length; i < l; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    //01.04. 回文排列
    //https://leetcode-cn.com/problems/palindrome-permutation-lcci/
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        for (int i = 0, l = chars.length; i < l; i++) {
            if (characters.contains(chars[i])) {
                characters.remove(chars[i]);
            } else {
                characters.add(chars[i]);
            }
        }
        return characters.size() <= 1;
    }

    public static String defangIPaddr(String address) {
        System.out.println(address.replaceAll("\\.", "[\\.]"));
        return "";
    }

    public static void main(String[] args) {
        IsUniqueLcci.defangIPaddr("1.1.1.1");
    }
}
