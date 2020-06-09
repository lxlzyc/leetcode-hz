package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "Hello"
 * 输出: "hello"
 * <p>
 * 示例 2：
 * <p>
 * 输入: "here"
 * 输出: "here"
 * <p>
 * 示例 3：
 * <p>
 * 输入: "LOVELY"
 * 输出: "lovely"
 * @author: lxl
 * @create: 2020-06-09 14:02
 **/
public class ToLowerCase {
    //asc 65-90 A-Z
    //asc 97-122 a-z
    //private static final char[] lowChars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','','','',''}
    public String toLowerCase(String str) {
        char[] lows = str.toCharArray();
        for (int i = 0, l = lows.length; i < l; i++) {
            if (lows[i] >= 65 && lows[i] <= 90) {
                lows[i] = (char) (lows[i] + 32);
            }
        }
        return new String(lows);
    }

}
