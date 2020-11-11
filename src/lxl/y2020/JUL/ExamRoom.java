package lxl.y2020.JUL;

import java.util.TreeSet;

/**
 * @program: leetcode-hz
 * @description: 855. 考场就座
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-23 16:33
 **/
public class ExamRoom {

    private TreeSet<Integer> seats;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        this.seats = new TreeSet<>();
    }

    public int seat() {
        int seat = 0;
        if (seats.size() > 0) {
            Integer pre = null;
            int dist = seats.first();
            for (Integer s : seats) {
                if (pre != null) {
                    int d = (s - pre) / 2;
                    if (d > dist) {
                        dist = d;
                        seat = pre + dist;
                    }
                }
                pre = s;
            }
            if (N - 1 - seats.last() > dist) {
                seat = N - 1;
            }
        }
        seats.add(seat);
        return seat;
    }

    public void leave(int p) {
        seats.remove(p);
    }

}
