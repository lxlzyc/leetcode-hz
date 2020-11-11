package lxl.y2020.DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-31 10:00
 **/
public class PalindromePartitioning {

    private List<List<String>> lists = new ArrayList<>();
    private int length = 0;

    public List<List<String>> partition(String s) {
        length = s.length();
        this.resolvPartition(s, 0, 0);
        int begin = 0;
        int end = length - 1;
        while (begin < length) {
            int indexBegin = begin;
            List<String> index = new ArrayList<>();

            while (indexBegin < 0)

                begin++;
        }
        return lists;
    }

    private void resolvPartition(String s, int i, int i1) {

    }

    private boolean check(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

}
