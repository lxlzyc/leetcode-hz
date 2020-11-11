package lxl.y2020.JUL;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * <p>
 * 说明:  1 <= S.length <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-14 16:13
 **/
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> re = new ArrayList<>();
        int l = S.length();
        if (l < 3) {
            return re;
        }
        char[] chars = S.toCharArray();
        int left = 0;
        char pre = chars[left];
        for (int i = 1; i < l; i++) {
            if (chars[i] != pre) {
                if (i - left >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(i - 1);
                    re.add(list);

                }
                left = i;
                pre = chars[i];
            }
        }
        if (l - left >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(l - 1);
            re.add(list);
        }
        return re;
    }

}
