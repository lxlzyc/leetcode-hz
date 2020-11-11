package lxl.y2020.MAR;

/**
 * @program: leetcode-hz
 * @description: 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-24 11:11
 **/
public class NumberOfSegmentsInAString {
    //
    //
    public int countSegments(String s) {
        if (s.trim().isEmpty()) {
            return 0;
        }
        int sum = 1;
        char[] chars = s.trim().toCharArray();

        int i = 0;
        int l = chars.length;
        while (i < l) {
            if (chars[i] == ' ') {
                sum++;
                i++;
                while (i < l) {
                    if (chars[i] != ' ') {
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "hellp lld.asd sd  ";
        NumberOfSegmentsInAString numberOfSegmentsInAString = new NumberOfSegmentsInAString();
        System.out.println(numberOfSegmentsInAString.countSegments(s));
    }
}
