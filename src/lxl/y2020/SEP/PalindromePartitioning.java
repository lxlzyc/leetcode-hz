package lxl.y2020.SEP;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @create: 2020-09-10 14:01
 **/
public class PalindromePartitioning {
    private Map<String, List<List<String>>> help = new HashMap<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        if (help.containsKey(s)) {
            return help.get(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0, l = s.length(); i < l; i++) {
            String sub = s.substring(0, i + 1);
            if (this.isPalindrome(sub)) {
                List<List<String>> next = this.partition(s.substring(i + 1));
                if (next.isEmpty()) {
                    List<String> index = new ArrayList<>();
                    index.add(sub);
                    ans.add(index);
                } else {
                    for (List<String> nextItem : next) {
                        List<String> index = new ArrayList<>();
                        index.add(sub);
                        index.addAll(nextItem);
                        ans.add(index);
                    }
                }
            }
        }
        help.put(s, ans);
        return ans;
    }

    private boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(
                JSONUtil.toJson(palindromePartitioning.partition("aba"))
        );
    }
}
