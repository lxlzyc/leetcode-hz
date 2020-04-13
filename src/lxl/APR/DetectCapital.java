package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * <p>
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * <p>
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-13 22:33
 **/
public class DetectCapital {

    //65-90 A-Z
    public boolean detectCapitalUse(String word) {
        if (word.isEmpty()) {
            return true;
        }
        char[] chars = word.toCharArray();
        int length = chars.length;
        if (chars[0] <= 90) {
            //首字母大写
            if (chars[length - 1] <= 90) {
                //应该全是大写
                return this.check(chars, 1, length - 1, 1);
            } else {
                //应该全是小写
                return this.check(chars, 1, length - 1, 0);
            }
        } else {
            //应该全部小写
            return this.check(chars, 0, length, 0);
        }

    }

    private boolean check(char[] chars, int i, int length, int type) {
        for (int j = i; j < length; j++) {
            if (type == 1) {
                if (chars[j] > 90) {
                    return false;
                }
            } else {
                if (chars[j] <= 90) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("US"));
        System.out.println(detectCapital.detectCapitalUse("Us"));
        System.out.println(detectCapital.detectCapitalUse("uS"));
        System.out.println(detectCapital.detectCapitalUse("us"));

    }
}
