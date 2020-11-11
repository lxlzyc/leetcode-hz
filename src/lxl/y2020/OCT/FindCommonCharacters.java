package lxl.y2020.OCT;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-14 17:44
 **/
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        int len = A.length;
        int[][] counts = new int[len][26];
        for (int i = 0; i < len; i++) {
            int[] count = counts[i];
            for (char c : A[i].toCharArray()) {
                count[c - 'a']++;

            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = len;
            for (int j = 0; j < len; j++) {
                min = Math.min(counts[j][i], min);
            }
            while (min > 0) {
                ans.add(String.valueOf((char) ('a' + i)));
                min--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] value = {"bella", "label", "roller"};
        System.out.println(findCommonCharacters.commonChars(value));
    }

}
