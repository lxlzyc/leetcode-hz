package lxl.y2020.AUG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode-hz
 * @description: 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 通过次数54,087
 * 提交次数101,769
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-04 11:06
 **/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立入度表
        int[] help = new int[numCourses];
        for (int[] pre : prerequisites) {
            help[pre[0]]++;
        }
        //初始化
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (help[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (int[] pre : prerequisites) {
                if (pre[1] == index) {
                    help[pre[0]]--;
                    if (help[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (help[i] > 0) {
                return false;
            }
        }
        return true;
    }

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public static void main(String[] args) {
        CourseSchedule courseScheduleii = new CourseSchedule();
        int[][] item = {{1, 0}};
        System.out.println(courseScheduleii.canFinish(2, item));
    }
}
