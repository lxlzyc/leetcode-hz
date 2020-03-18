package lxl.MAR;

/**
 * @program: leetcode-hz
 * @description: 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-18 10:17
 **/
public class LongestPalindrome {
    //Integer.valueOf(index) - 97;
    //A-Z 65-90
    // 97-122 a-z
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[58];
        for (char index : chars) {
            counts[Integer.valueOf(index) - 65] += 1;
        }
        boolean hasSingle = false;
        int sum = 0;
        int index = 0;
        int count;
        while (index < 58) {
            count = counts[index];
            if (count > 0) {
                sum += count / 2;
                if (count % 2 == 1) {
                    hasSingle = true;
                    index++;
                    break;
                }
            }
            index++;
        }
        while (index < 58) {
            count = counts[index];
            if (count > 0) {
                sum += count / 2;
            }
            index++;
        }
        return sum * 2 + (hasSingle ? 1 : 0);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("a"));
    }

}
