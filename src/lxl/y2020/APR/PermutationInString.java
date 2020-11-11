package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-22 10:05
 **/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        if (length > s2.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        for (int i = 0; i < length; i++) {
            arr1[s1Char[i] - 'a'] += 1;
            arr2[s2Char[i] - 'a'] += 1;
        }
        if (this.checkSameArr(arr1, arr2)) {
            return true;
        }
        for (int i = length, l = s2.length(); i < l; i++) {
            arr2[s2Char[i - length] - 'a'] -= 1;
            arr2[s2Char[i] - 'a'] += 1;
            if (checkSameArr(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSameArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
