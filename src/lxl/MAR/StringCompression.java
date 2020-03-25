package lxl.MAR;

/**
 * @program: leetcode-hz
 * @description: 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ['a','a','b','b','c','c','c']
 * <p>
 * 输出：
 * 返回6，输入数组的前6个字符应该是：['a','2','b','2','c','3']
 * <p>
 * 说明：
 * 'aa'被'a2'替代。'bb'被'b2'替代。'ccc'被'c3'替代。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ['a']
 * <p>
 * 输出：
 * 返回1，输入数组的前1个字符应该是：['a']
 * <p>
 * 说明：
 * 没有任何字符串被替代。
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * <p>
 * 输出：
 * 返回4，输入数组的前4个字符应该是：['a','b','1','2']。
 * <p>
 * 说明：
 * 由于字符'a'不重复，所以不会被压缩。'bbbbbbbbbbbb'被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * <p>
 * 注意：
 * <p>
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * @author: lxl
 * @create: 2020-03-25 09:57
 **/
public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int count = 1;
        char pre = chars[0];
        int i = 1;
        int l = chars.length;
        char index = ' ';
        int changeOffset = 0;
        while (i < l) {
            index = chars[i];
            if (index == pre) {
                count++;
            } else {
                chars[changeOffset] = pre;
                changeOffset = this.addCountToChars(chars, changeOffset, count);

                pre = index;
                if (count > 1) {
                    count = 1;
                }
            }
            i++;
        }
        if (index != ' ') {
            chars[changeOffset] = index;
            changeOffset = this.addCountToChars(chars, changeOffset, count);

        }
        return changeOffset;
    }

    private int addCountToChars(char[] chars, int changeOffset, int count) {
        if (count == 1) {
            return changeOffset + 1;
        }
        changeOffset++;
        String s = "" + count;
        for (char index : s.toCharArray()) {
            chars[changeOffset] = index;
            changeOffset++;
        }
        return changeOffset;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c'};
        System.out.println(stringCompression.compress(chars));
    }
}
