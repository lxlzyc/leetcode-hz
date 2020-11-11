package lxl.y2020.JUN;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 773. 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * <p>
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * <p>
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * <p>
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * <p>
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-30 11:23
 **/
public class SlidingPuzzle {
//    方法一： 广度优先搜索 【通过】
//
//    思路
//
//    可以把这道题看成一个找出图中最短路径的问题。每个节点都是棋盘的一个状态，如果两个状态之间可以通过一步操作来完成转换，就用一条边将这两个节点相连。用 广度优先搜索 来解决最短路径问题。
//
//    算法
//
//    在广度优先搜索实现中，需要将节点表示成可以哈希的数据结构，同时还需要找到每个节点的邻居节点。之后套一个下面这样的广度优先搜索模板就可以了。
//
//    queue = collections.deque([(start, 0)])
//    seen = {start}
//while queue:
//    node, depth = queue.popleft()
//            if node == target: return depth
//    for nei in neighbors(node):
//            if nei not in seen:
//            seen.add(nei)
//            queue.append((nei, depth+1))
//
//    为了将节点表示成可以哈希的数据结构，在 Python 实现中，将棋盘转化成一维 tuple。在 Java 实现中，可以将棋盘转化成一个整数或者直接用 Arrays.deepToString。
//
//    为了枚举节点的邻居，需要记住 0 的位置。对于每个节点，最多有 4 个的邻居，将棋盘用一维数组表示，当前节点的邻居距离当前节点 (1, -1, C, -C) 距离，其中 C 是棋盘的列数。
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/sliding-puzzle/solution/hua-dong-mi-ti-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int zero_x = -1;
        int zero_y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    zero_x = i;
                    zero_y = j;
                    break;
                }
            }
            if (zero_x >= 0) {
                break;
            }
        }
        Node base = new Node(board, zero_x, zero_y, 0);
        String target = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 0}});
        if (base.boardString.equals(target)) {
            return 0;
        }
        Set<String> seen = new HashSet<>();
        seen.add(base.boardString);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(base);
        //上下左右
        int[][] help = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int depth;
        while (!queue.isEmpty()) {
            Node index = queue.remove();
            zero_x = index.x;
            zero_y = index.y;
            depth = index.depth;
            for (int[] item : help) {
                int next_x = zero_x + item[0];
                int next_y = zero_y + item[1];
                if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
                    int[][] boardClone = new int[m][n];
                    for (int i = 0; i < m; i++) {
                        boardClone[i] = index.board[i].clone();
                    }
                    boardClone[zero_x][zero_y] = boardClone[next_x][next_y];
                    boardClone[next_x][next_y] = 0;
                    Node next = new Node(boardClone, next_x, next_y, depth + 1);
                    if (!seen.contains(next.boardString)) {
                        if (next.boardString.equals(target)) {
                            return next.depth;
                        } else {
                            queue.offer(next);
                            seen.add(next.boardString);
                        }
                    }
                }
            }
        }
        return -1;
    }

    class Node {
        int[][] board;
        String boardString;
        int x;
        int y;
        int depth;

        public Node(int[][] board, int x, int y, int depth) {
            this.board = board;
            this.x = x;
            this.y = y;
            this.boardString = Arrays.deepToString(board);
            this.depth = depth;
        }
    }


    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(slidingPuzzle.slidingPuzzle(board));
    }
}
