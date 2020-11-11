package lxl.y2020.JUL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 821. 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * 说明:
 * <p>
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-13 15:50
 **/
public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String S, char C) {
        List<Integer> offsets = new ArrayList<>();
        char[] chars = S.toCharArray();
        int l = chars.length;
        for (int i = 0; i < l; i++) {
            if (chars[i] == C) {
                offsets.add(i);
            }
        }
        int[] re = new int[chars.length];
        int index = 0;
        int max = offsets.size();
        int offset;
        int nextOffset;
        int i = 0;
        while (i < l) {
            offset = offsets.get(index);
            if (index + 1 < max) {
                nextOffset = offsets.get(index + 1);
            } else {
                nextOffset = -1;
            }
            while (offset >= i && i < l) {
                re[i] = offset - i;
                i++;
            }
            if (nextOffset >= 0) {
                while (i <= (offset + nextOffset) / 2 && i < l) {
                    re[i] = i - offset;
                    i++;
                }
                index++;
            } else {
                while (i < l) {
                    re[i] = i - offset;
                    i++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        ShortestDistanceToACharacter shortestDistanceToACharacter = new ShortestDistanceToACharacter();
        System.out.println(Arrays.toString(shortestDistanceToACharacter.shortestToChar("aaba", 'a')));
    }
}
