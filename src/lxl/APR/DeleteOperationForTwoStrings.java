package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符。
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
 * @create: 2020-04-23 11:10
 **/
public class DeleteOperationForTwoStrings {
    //我们可以求出串 s1s1s1 和串 s2s2s2 最长公共子序列，我们记为 lcslcslcs。
    //如果我们能求得 lcslcslcs 的值，我们可以轻易地求出答案，为 m+n−2∗lcsm + n - 2*lcsm+n−2∗lcs。
    //这里 mmm 和 nnn 分别是给定字符串 s1s1s1 和 s2s2s2 的长度。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/liang-ge-zi-fu-chuan-de-shan-chu-cao-zuo-by-leetco/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int minDistance(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }

    public int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
        }

    }

}
