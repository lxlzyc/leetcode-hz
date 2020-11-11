package lxl.y2020.JAN;

/**
 * @program: leetcode-hz
 * @description: 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 16:24
 **/
public class ExcelSheetColumnNumber {
    //A-Z 65-90
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int help = 1;
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += (chars[i] - 64) * help;
            help = help * 26;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
    }

}
