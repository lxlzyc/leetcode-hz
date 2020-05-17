package lxl.MAY;

/**
 * @program: leetcode-hz
 * @description: 657. 机器人能否返回原点
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-return-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-05-17 16:26
 **/
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int length = moves.length();
        if (length == 0) {
            return true;
        }
        length = length / 2;
        int[] help = new int[4];
        char[] chars = moves.toCharArray();
        for (char index : chars) {
            if (index == 'D') {
                help[0]++;
                if (help[0] > length) {
                    break;
                } else {
                    continue;
                }
            }
            if (index == 'U') {
                help[1]++;
                if (help[1] > length) {
                    break;
                } else {
                    continue;
                }
            }
            if (index == 'R') {
                help[2]++;
                if (help[2] > length) {
                    break;
                } else {
                    continue;
                }
            }
            if (index == 'L') {
                help[3]++;
                if (help[3] > length) {
                    break;
                } else {
                    continue;
                }
            }
        }
        return help[0] == help[1] && help[2] == help[3];
    }

    public static void main(String[] args) {
        RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();
        System.out.println(robotReturnToOrigin.judgeCircle("UD"));
    }


}
