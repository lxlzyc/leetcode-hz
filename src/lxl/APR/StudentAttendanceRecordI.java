package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * <p>
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-18 15:42
 **/
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int ACOUNT = 0;
        int LCOUNT = 0;
        char[] chars = s.toCharArray();
        for (char i : chars) {
            if (i == 'A') {
                ACOUNT++;
                if (ACOUNT > 1) {
                    return false;
                }
            } else if (i == 'L') {
                LCOUNT++;
                if (LCOUNT > 2) {
                    return false;
                }
            } else {
                LCOUNT = 0;
            }
        }
        return true;
    }
}
