package lxl.y2021.MAR;

import java.util.Arrays;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/8 9:56
 * @Version 1.0
 */
public class PalindromePartitioningii {
    //dp
    public int minCut(String s) {
        int n = s.length();
        //是否是回文串
        boolean[][] g = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }
        //i-j是不是回文串 = i==j && i+1和j-1是回文串
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        //已知任何字符串，一个一个分割，即满足题意
        //标识从0开始到i，是回文分割的最小次数
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            //整个都是回文串，直接返回
            if (g[0][i]) {
                f[i] = 0;
            } else {
                //当前串的前一个回文串
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        //如果j+1到i是回文串，则 f[i]可能等于 f[j]+1
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }

}