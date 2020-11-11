package lxl.y2020.AUG;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 934. 最短的桥
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * <p>
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * <p>
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：[
 * [0,1,0],
 * [0,0,0],
 * [0,0,1]]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：[
 * [1,1,1,1,1],
 * [1,0,0,0,1],
 * [1,0,1,0,1],
 * [1,0,0,0,1],
 * [1,1,1,1,1]]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-12 15:31
 **/
public class ShortestBridge {
    //上下左右
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;

    public int shortestBridge(int[][] A) {
        m = A.length;
        n = A[0].length;
        List<int[]> firstBridge = new ArrayList<>();
        List<int[]> secondBridge = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    if (firstBridge.isEmpty()) {
                        this.buildBridge(firstBridge, A, i, j, 2);
                    } else if (secondBridge.isEmpty()) {
                        this.buildBridge(secondBridge, A, i, j, 3);
                        i = m;
                        break;
                    }
                }
            }
        }
        if (firstBridge.size() > secondBridge.size()) {
            return this.bfsBridge(secondBridge, A, 2);
        } else {
            return this.bfsBridge(firstBridge, A, 3);
        }
    }

    private int bfsBridge(List<int[]> secondBridge, int[][] A, int val) {
        Set<String> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int[] item : secondBridge) {
            queue.offer(item);
            visit.add(item[0] + "_" + item[1]);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int nextI;
            int nextJ;
            Queue<int[]> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] offset = queue.poll();
                for (int k = 0; k < 4; k++) {
                    nextI = offset[0] + directions[k][0];
                    nextJ = offset[1] + directions[k][1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                        if (!visit.contains(nextI + "_" + nextJ)) {
                            if (A[nextI][nextJ] == val) {
                                return count - 1;
                            } else {
                                nextQueue.offer(new int[]{nextI, nextJ});
                                visit.add(nextI + "_" + nextJ);
                            }
                        }

                    }
                }
            }
            queue = nextQueue;
        }
        return count;
    }

    private void buildBridge(List<int[]> bridge, int[][] A, int i, int j, int val) {
        if (A[i][j] == 1) {
            bridge.add(new int[]{i, j});
            A[i][j] = val;
            int nextI;
            int nextJ;
            for (int k = 0; k < 4; k++) {
                nextI = i + directions[k][0];
                nextJ = j + directions[k][1];
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                    this.buildBridge(bridge, A, nextI, nextJ, val);
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        int[][] A = {
                {1, 0, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        System.out.println(shortestBridge.shortestBridge(A));
    }
}
