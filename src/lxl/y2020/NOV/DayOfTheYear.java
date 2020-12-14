package lxl.y2020.NOV;

/**
 * @program: leetcode-hz
 * @description: 1154. 一年中的第几天
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * <p>
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * 示例 3：
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * <p>
 * 示例 4：
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-27 10:05
 **/
public class DayOfTheYear {

    private int[] days = {
            0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334
    };

    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        int sum = days[month] + day;
        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        DayOfTheYear dayOfTheYear = new DayOfTheYear();
        System.out.println(dayOfTheYear.dayOfYear("2020-10-10"));
    }

}
