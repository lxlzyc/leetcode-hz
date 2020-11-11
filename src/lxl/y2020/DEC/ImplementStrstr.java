package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 当 needle 是空字符串时我们应当返回 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-04 16:14
 **/
public class ImplementStrstr {
    //具体看java源码。。。。
    public int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

    }
}
