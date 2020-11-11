package lxl.y2020.AUG;

/**
 * @program: leetcode-hz
 * @description: 984. 不含 AAA 或 BBB 的字符串
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * <p>
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A <= 100
 * 0 <= B <= 100
 * 对于给定的 A 和 B，保证存在满足要求的 S。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-27 11:38
 **/
public class StringWithoutaaaOrbbb {

    public String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        int acount = 0;
        int bcount = 0;
        while (A > 0 || B > 0) {
            if (acount == 2) {
                stringBuilder.append('b');
                B--;
                bcount++;
                acount = 0;
                continue;
            }
            if (bcount == 2) {
                stringBuilder.append('a');
                A--;
                acount++;
                bcount = 0;
                continue;
            }
            if (A >= B) {
                stringBuilder.append('a');
                acount++;
                A--;
            } else {
                stringBuilder.append('b');
                bcount++;
                B--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringWithoutaaaOrbbb stringWithoutaaaOrbbb = new StringWithoutaaaOrbbb();
        System.out.println(stringWithoutaaaOrbbb.strWithout3a3b(4, 1));
    }
}
