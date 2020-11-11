package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-15 10:59
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int begin = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char first = ' ';
        boolean flag = true;
        while (true) {
            for (int i = 0, l = strs.length; i < l; i++) {
                if (strs[i].length() - 1 < begin) {
                    flag = false;
                    break;
                } else {
                    if (i == 0) {
                        first = strs[i].charAt(begin);
                    } else {
                        if (strs[i].charAt(begin) != first) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                stringBuilder.append(first);
                begin++;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
