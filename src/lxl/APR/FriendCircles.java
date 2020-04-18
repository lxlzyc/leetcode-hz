package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * <p>
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-18 15:48
 **/
public class FriendCircles {

    //n 个学生，最多n个朋友圈
    //每次尝试一个朋友圈，塞满
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    //查找右上部分连通图-------会漏
    private int m = 0;
    private int n = 0;

    public int findCircleNum2(int[][] M) {
        m = M.length;
        if (m <= 1) {
            return m;
        }
        n = M[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                if (M[i][j] == 1) {
                    M[i][j] = 0;
                    count++;
                    this.bfs(M, i, j);
                }
            }
        }

        return count;
    }

    //往右下探索
    private void bfs(int[][] M, int i, int j) {
        if (i + 1 < m && i + 1 <= j) {
            if (M[i + 1][j] == 1) {
                M[i + 1][j] = 0;
                this.bfs(M, i + 1, j);
            }
        }
        if (j + 1 < n) {
            if (M[i][j + 1] == 1) {
                M[i][j + 1] = 0;
                this.bfs(M, i, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        FriendCircles friendCircles = new FriendCircles();
        System.out.println(friendCircles.findCircleNum(nums));
    }

}
