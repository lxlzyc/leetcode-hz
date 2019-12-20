package lxl.DEC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-02 17:42
 **/
public class LetterCombinationsOfPhone {

    public List<String> letterCombinations(String digits) {
        List<List<String>> letters = new ArrayList<>();
        letters.add(null);
        letters.add(null);
        letters.add(Arrays.asList("a","b","c"));
        letters.add(Arrays.asList("d","e","f"));
        letters.add(Arrays.asList("g","h","i"));
        letters.add(Arrays.asList("j","k","l"));
        letters.add(Arrays.asList("m","n","o"));
        letters.add(Arrays.asList("p","q","r","s"));
        letters.add(Arrays.asList("t","u","v"));
        letters.add(Arrays.asList("w","x","y","z"));

        List<String> re = new ArrayList<>();
        for (int i = 0,l=digits.length(); i < l; i++) {
            int index = Integer.valueOf(String.valueOf(digits.charAt(i)));
            if(index < 2){
                continue;
            }
            List<String> letter = letters.get(index);
            if(re.isEmpty()){
                re = new ArrayList<>(letter);
            }else{
                List<String> indexRe = new ArrayList<>();
                for(String value:letter){
                    for (String reValue:re){
                        indexRe.add(reValue+value);
                    }
                }
                re = indexRe;
            }

        }
        return  re;

    }

    public static void main(String[] args) {
        LetterCombinationsOfPhone le = new LetterCombinationsOfPhone();
        System.out.println(le.letterCombinations("10234"));
    }

}
