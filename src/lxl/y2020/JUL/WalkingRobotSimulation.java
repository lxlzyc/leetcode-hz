package lxl.y2020.JUL;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * <p>
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * <p>
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-28 15:54
 **/
public class WalkingRobotSimulation {

    //北东南西 顺时针
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obsSet.add(obstacle[0] + "_" + obstacle[1]);
        }
        //初始向上
        int dir = 0;
        int max = 0;
        int x = 0;
        int y = 0;
        for (int command : commands) {
            if (command == -2) {
                //左转
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                // 右转
                dir = (dir + 1) % 4;
            } else {
                System.out.println(dir);
                //前进
                for (int k = 0; k < command; ++k) {
                    int nx = x + directions[dir][0];
                    int ny = y + directions[dir][1];
                    if (!obsSet.contains(nx + "_" + ny)) {
                        x = nx;
                        y = ny;
                        System.out.println(x + "-" + y);
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        int[] commends = {4, -1, 3};
        int[][] obs = {};
        System.out.println(walkingRobotSimulation.robotSim(commends, obs));
    }

}
