package lxl.JUN;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-17 17:10
 **/
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] help = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0, l = chars.length; i < l; i++) {
            help[chars[i] - 'a'] = i;
        }
        int right = 0;
        int indexMax = -1;
        int pre = -1;
        List<Integer> integers = new LinkedList<>();
        while (right < chars.length) {
            indexMax = Math.max(help[chars[right] - 'a'], indexMax);
            if (right == indexMax) {
                if (pre < 0) {
                    integers.add(right + 1);
                } else {
                    integers.add(right - pre);
                }
                pre = right;
                indexMax = -1;
            }
            right++;
        }
        return integers;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(JSONUtil.toJson(partitionLabels.partitionLabels("ababcbacadefegdehijhklij")));
    }
}
