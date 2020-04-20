package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-20 09:30
 **/
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] re = s.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0, l = chars.length; i < l; i++) {
            if (chars[i] == ' ') {
                result.append(stringBuilder.reverse()).append(' ');
                stringBuilder.delete(0, stringBuilder.length());
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        if (stringBuilder.length() > 0) {
            result.append(stringBuilder.reverse());
        }

        return result.toString();
    }

}
