package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * <p>
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-04 14:19
 **/
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int l = chars.length;
        if (l <= 1) {
            return 0;
        }
        int count = 0;
        int right = 1;
        char pre = chars[0];
        int precount = 1;
        int indexcount = 0;
        while (right < l) {
            if (indexcount == 0) {
                if (chars[right] == pre) {
                    precount++;
                } else {
                    indexcount++;
                }
            } else {
                if (chars[right] != pre) {
                    indexcount++;
                } else {
                    count += Math.min(indexcount, precount);
                    pre = pre == '0' ? '1' : '0';
                    precount = indexcount;
                    indexcount = 1;
                }
            }
            right++;
        }
        count += Math.min(indexcount, precount);
        return count;
    }

    //s=“11000111000000” groups=[2，3，3，6]
    public int countBinarySubstrings2(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i - 1], groups[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("10101001100000001111111010100001"));
    }

}
