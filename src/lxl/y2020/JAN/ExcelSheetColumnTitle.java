package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 15:53
 **/
public class ExcelSheetColumnTitle {
    //A-Z 65-90
    public String convertToTitle(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int index = n % 26;
            index = index == 0 ? 26 : index;
            char convert = (char) (64 + index);
            stringBuffer.append(convert);
            if (n == index) {
                break;
            }
            n = (n - 1) / 26;
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(701));
    }
}
