package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 423. 从英文中重建数字
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * <p>
 * 注意:
 * <p>
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "owoztneoer"
 * <p>
 * 输出: "012" (zeroonetwo)
 * <p>
 * 示例 2:
 * <p>
 * 输入: "fviefuro"
 * <p>
 * 输出: "45" (fourfive)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-23 10:44
 **/
public class ReconstructOriginalDigitsFromEnglish {
    String[] a = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // e9 o4 n4 i4 t3 r3 h2 f2 v2 s2 w1 u1 x1 g1 z1
    public String originalDigits(String s) {
        int[] out = new int[10];
        char[] count = new char[26 + (int) 'a'];
        for (char index : s.toCharArray()) {
            count[index]++;
        }

        out[0] = count['z'];
        out[2] = count['w'];
        out[4] = count['u'];
        out[6] = count['x'];
        out[8] = count['g'];
        out[3] = count['h'] - out[8];
        out[5] = count['f'] - out[4];
        out[7] = count['v'] - out[5];
        out[9] = count['i'] - out[5] - out[6] - out[8];
        out[1] = count['n'] - out[7] - 2 * out[9];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < out[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}
