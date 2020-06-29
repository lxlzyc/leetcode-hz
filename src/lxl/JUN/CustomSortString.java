package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 791. 自定义字符串排序
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 * <p>
 * 注意:
 * <p>
 * S的最大长度为26，其中没有重复的字符。
 * T的最大长度为200。
 * S和T只包含小写字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/custom-sort-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-29 11:33
 **/
public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] chars = new int[26];
        for (char item : T.toCharArray()) {
            chars[item - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char item : S.toCharArray()) {
            while (chars[item - 'a'] > 0) {
                stringBuilder.append(item);
                chars[item - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (chars[i] > 0) {
                stringBuilder.append((char) ('a' + i));
                chars[i]--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString("cba", "abcdbcdabc"));
    }
}
