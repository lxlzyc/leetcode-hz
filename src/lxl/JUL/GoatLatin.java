package lxl.JUL;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 824. 山羊拉丁文
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * <p>
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * <p>
 * 山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * <p>
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * <p>
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * <p>
 * 返回将 S 转换为山羊拉丁文后的句子。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 示例 2:
 * <p>
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * 说明:
 * <p>
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-14 14:25
 **/
public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> yChars = new HashSet<>();
        yChars.add('a');
        yChars.add('e');
        yChars.add('i');
        yChars.add('o');
        yChars.add('u');
        yChars.add('A');
        yChars.add('E');
        yChars.add('I');
        yChars.add('O');
        yChars.add('U');

        StringBuffer ma = new StringBuffer("ma");
        String[] words = S.split(" ");
        StringBuffer re = new StringBuffer();
        for (int i = 0, l = words.length; i < l; i++) {
            ma.append('a');
            StringBuffer stringBuffer = new StringBuffer(words[i]);
            if (yChars.contains(stringBuffer.charAt(0))) {
                stringBuffer.append(ma).append(' ');
            } else {
                stringBuffer.append(stringBuffer.charAt(0)).append(ma).append(' ');
                stringBuffer.deleteCharAt(0);
            }
            re.append(stringBuffer);
        }
        if (re.length() > 0) {
            re.deleteCharAt(re.length() - 1);
        }
        return re.toString();
    }

}
