package lxl.y2019.DEC;

/**
 * @program: leetcode-hz
 * @description: 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-24 15:51
 **/
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        char[] char3 = s3.toCharArray();
        if (char3.length != char1.length + char2.length) {
            return false;
        }
        return this.checkInterleave(char3, char2, char1, char3.length - 1, char2.length - 1, char1.length - 1);
    }

    public boolean checkInterleave(char[] char3, char[] char2, char[] char1, int offset3, int offset2, int offset1) {
        if (offset1 == -1 && offset2 == -1 && offset3 == -1) {
            return true;
        }

        boolean re = false;
        if (offset1 >= 0 && char1[offset1] == char3[offset3]) {
            re = this.checkInterleave(char3, char2, char1, offset3 - 1, offset2, offset1 - 1);
            if (re == true) {
                return re;
            }
        }
        if (offset2 >= 0 && char2[offset2] == char3[offset3]) {
            re = this.checkInterleave(char3, char2, char1, offset3 - 1, offset2 - 1, offset1);
            if (re == true) {
                return re;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}
