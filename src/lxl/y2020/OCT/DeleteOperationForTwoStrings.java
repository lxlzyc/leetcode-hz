package lxl.y2020.OCT;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-13 14:57
 **/
public class DeleteOperationForTwoStrings {
    //求最长公共子序列
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        //i-j 标识 word1的0-i位 与 word2的0-j位的最长公告子序列
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            char index = word1.charAt(i);
            for (int j = 0; j < l2; j++) {
                dp[i + 1][j + 1] = (index == word2.charAt(j)) ? (1 + dp[i][j]) : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        for (int i = 0; i <= l1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return l1 + l2 - dp[l1][l2] * 2;
    }

    //直接计算
    public int minDistance2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        System.out.println(deleteOperationForTwoStrings.minDistance2("sea", "eat"));
    }
}
