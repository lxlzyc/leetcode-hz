package lxl.work;

/**
 * @program: leetcode-hz
 * @description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-27 17:54
 **/
public class RegularExpressionMatching {

    // * '.' 匹配任意单个字符
    // * '*' 匹配零个或多个前面的那一个元素
    // s 可能为空，且只包含从 a-z 的小写字母。
    // p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
    // a-z asc码为 97-122 .asc码为 46 *asc码为42
    public boolean isMatch(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        if (slength == 0) {
            if (plength == 0) {
                return true;
            } else {
                return false;
            }
        } else if (plength == 0) {
            return false;
        } else if (p.startsWith("*")) {
            return false;
        }
        //else if (p.contains()){
        //
        //}

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int sOffset = 0;
        int pOffset = 0;
        char sChar;
        char pChar;
        char preChar;
        while (sOffset < slength && pOffset < plength) {
            pChar = pChars[pOffset];
            sChar = sChars[sOffset];
            if (pChar >= 97) {
                if (pChar != sChar) {
                    return false;
                } else {
                    pOffset++;
                    sOffset++;
                }
            } else if (pChar == '.') {
                pChars[pOffset] = sChar;
                pOffset++;
                sOffset++;
            } else {
                //*号匹配的处理
                preChar = pChars[pOffset - 1];
                //寻找 s 字符串offset后，第一个不等于preChar的位置
                //寻找 p 字符串offset后，第一个不等于preChar的位置
                //移动offset
                while (sOffset < slength) {
                    if (preChar != sChars[sOffset]) {
                        break;
                    }
                    sOffset++;
                }
                while (pOffset < slength) {
                    if (preChar != pChars[pOffset]) {
                        break;
                    }
                    pOffset++;
                }
            }
        }

        if (sOffset < slength) {
            return false;
        }

        if (pOffset == plength) {
            return true;
        }
        while (pOffset < plength) {
            if (pChars[pOffset] != '*') {
                return false;
            }
            pOffset++;
        }
        return true;

    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
        System.out.println(regularExpressionMatching.isMatch("aab", "c*a*b"));
        System.out.println(regularExpressionMatching.isMatch("ab", ".*"));

    }

}
