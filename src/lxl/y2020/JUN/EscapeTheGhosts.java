package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 789. 逃脱阻碍者
 * 你在进行一个简化版的吃豆人游戏。你从 (0, 0) 点开始出发，你的目的地是 (target[0], target[1]) 。地图上有一些阻碍者，第 i 个阻碍者从 (ghosts[i][0], ghosts[i][1]) 出发。
 * <p>
 * 每一回合，你和阻碍者们*可以*同时向东，西，南，北四个方向移动，每次可以移动到距离原位置1个单位的新位置。
 * <p>
 * 如果你可以在任何阻碍者抓住你之前到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
 * <p>
 * 当且仅当你有可能成功逃脱时，输出 True。
 * <p>
 * 示例 1:
 * 输入：
 * ghosts = [[1, 0], [0, 3]]
 * target = [0, 1]
 * 输出：true
 * 解释：
 * 你可以直接一步到达目的地(0,1)，在(1, 0)或者(0, 3)位置的阻碍者都不可能抓住你。
 * <p>
 * 示例 2:
 * 输入：
 * ghosts = [[1, 0]]
 * target = [2, 0]
 * 输出：false
 * 解释：
 * 你需要走到位于(2, 0)的目的地，但是在(1, 0)的阻碍者位于你和目的地之间。
 * <p>
 * 示例 3:
 * 输入：
 * ghosts = [[2, 0]]
 * target = [1, 0]
 * 输出：false
 * 解释：
 * 阻碍者可以和你同时达到目的地。
 * <p>
 * 说明：
 * <p>
 * 所有的点的坐标值的绝对值 <= 10000。
 * 阻碍者的数量不会超过 100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-the-ghosts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-28 10:24
 **/
public class EscapeTheGhosts {
    //方法一：曼哈顿距离【通过】
    //
    //思想
    //
    //曼哈顿距离是指网格中从 A 点到 B 点的距离，计算公式为 dist(A, B) = abs(A.x - B.x) + abs(A.y - B.y)。
    //
    //假设我们的起点是 S，阻碍者的起点是 G，目的地是 T。如果我们与阻碍者在 X 点相遇，则有 dist(G, X) <= dist(S, X)，表示阻碍者要么和我们同时到达 X 点，要么比我们更早到 X 点。
    //
    //如果阻碍者从 G 出发先到达 X 再到达 T，与直接到达 T 相比有 dist(G, T) <= dist(G, X) + dist(X, T) <= dist(S, X) + dist(X, T)。因为三角形两边之和大于第三边，所以 dist(G, T) <= dist(G, X) + dist(X, T) 一定成立。
    //
    //以上分析表明，让阻碍者直接到达目的地 T，与让阻碍者先到某个点 X 再到达目的地 T 的结果是一样的。如果阻碍者直接到达目的地会阻碍我们，那么阻碍者也一定会先于我们到达某一点 X ，在此与我们相遇；如果阻碍者直接到达目的地不会阻碍我们，那么阻碍者无论怎么走也无法阻碍我们。
    //
    //因此，这个问题可以简化为我们与所有阻碍者都在最短时间内直接到达目的地是否会与阻碍者相遇。
    //
    //算法
    //
    //计算我们到目的地的曼哈顿距离是否小于所有阻碍者到达目的地的曼哈顿距离。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/escape-the-ghosts/solution/tao-tuo-zu-ai-zhe-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] begin = {0, 0};
        int length = this.taxi(begin, target);
        for (int[] item : ghosts) {
            if (this.taxi(item, target) <= length) {
                return false;
            }
        }
        return true;
    }

    public int taxi(int[] P, int[] Q) {
        return Math.abs(P[0] - Q[0]) + Math.abs(P[1] - Q[1]);
    }

}
