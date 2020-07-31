package lxl.JUL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 893. 特殊等价字符串组
 * 你将得到一个字符串数组 A。
 * <p>
 * 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
 * <p>
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
 * <p>
 * 例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy" -> "xyzz" 。
 * <p>
 * 现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：
 * <p>
 * 该组中的每一对字符串都是 特殊等价 的
 * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
 * <p>
 * 返回 A 中特殊等价字符串组的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * 输出：3
 * 解释：
 * 其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
 * 另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
 * <p>
 * 示例 2：
 * <p>
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有 A[i] 都具有相同的长度。
 * 所有 A[i] 都只由小写字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-31 15:50
 **/
public class GroupsOfSpecialEquivalentStrings {
    //思路和算法
    //
    //让我们试着表述一个特殊等价的字符串 SSS，通过找到函数 C\mathcal{C}C 使得 S≡T  ⟺  C(S)=C(T)S \equiv T \iff \mathcal{C}(S) = \mathcal{C}(T)S≡T⟺C(S)=C(T)。
    //
    //通过交换，我们可以排列偶数索引字母和奇数索引字母。这些排列的特征在于字母的数量：所有这样的排列都有相同的数量，不同的数量会产生不同的排列。
    //
    //因此，函数 C(S)=\mathcal{C}(S) =C(S)=（S 中偶数索引字母的数量，其后是 S 中奇数索引字母的数量）成功地刻画了这一等价关系。
    //
    //然后，我们统计出满足 S∈AS \in AS∈A 的 C(S)\mathcal{C}(S)C(S) 的数量。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/solution/te-shu-deng-jie-zi-fu-chuan-zu-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S : A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i) {
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }


}
