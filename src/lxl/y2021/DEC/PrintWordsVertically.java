package lxl.y2021.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 1324. 竖直打印单词
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "HOW ARE YOU"
 * 输出：["HAY","ORO","WEU"]
 * 解释：每个单词都应该竖直打印。
 * "HAY"
 * "ORO"
 * "WEU"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "TO BE OR NOT TO BE"
 * 输出：["TBONTB","OEROOE","   T"]
 * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "CONTEST IS COMING"
 * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 200
 * s 仅含大写英文字母。
 * 题目数据保证两个单词之间只有一个空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-words-vertically
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-04 10:33
 **/
public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int l = arr.length;
        int maxLen = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < l; i++) {
            maxLen = Math.max(arr[i].length(), maxLen);
            stringBuilder.append(arr[i].charAt(0));
        }
        List<String> ans = new ArrayList<>();
        ans.add(stringBuilder.toString());
        for (int i = 1; i < maxLen; i++) {
            stringBuilder = new StringBuilder();
            for (String a : arr) {
                if (i < a.length()) {
                    stringBuilder.append(a.charAt(i));
                } else {
                    stringBuilder.append(' ');
                }
            }
            ans.add(this.formatEmpty(stringBuilder));
        }
        return ans;
    }

    private String formatEmpty(StringBuilder stringBuilder) {
        while (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PrintWordsVertically printWordsVertically = new PrintWordsVertically();
        System.out.println(JSONUtil.listToJson(printWordsVertically.printVertically("CONTEST IS COMING")));
    }
}
