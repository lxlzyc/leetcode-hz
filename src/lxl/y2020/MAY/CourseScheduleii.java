package lxl.y2020.MAY;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * <p>
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * <p>
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * <p>
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-17 15:39
 **/
public class CourseScheduleii {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        // 建立入度表
        int[] help = new int[numCourses];
        for (int[] pre : prerequisites) {
            help[pre[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < help.length; i++) {
            if (help[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    help[p[0]]--;
                    if (help[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleii courseScheduleii = new CourseScheduleii();
        int[][] item = {{1, 0,}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(courseScheduleii.findOrder(4, item)));
    }
}
