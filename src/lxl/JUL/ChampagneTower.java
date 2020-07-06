package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 799. 香槟塔
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
 * <p>
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 * <p>
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 * <p>
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.0
 * 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
 * <p>
 * 示例 2:
 * 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.5
 * 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
 * <p>
 * 注意:
 * <p>
 * poured 的范围[0, 10 ^ 9]。
 * query_glass 和query_row 的范围 [0, 99]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/champagne-tower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-06 20:15
 **/
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] towers = new double[102][102];
        towers[0][0] = poured;
        for (int i = 1; i < 102; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j > 0) {
                    towers[i][j] = (towers[i - 1][j] > 1 ?
                            (towers[i - 1][j] - 1) / 2
                            : 0) + (towers[i - 1][j - 1] > 1 ?
                            (towers[i - 1][j - 1] - 1) / 2
                            : 0);
                } else {
                    towers[i][j] = towers[i - 1][j] > 1 ?
                            (towers[i - 1][j] - 1) / 2
                            : 0;
                }
            }
            if (i == query_row) {
                break;
            }
        }
        return towers[query_row][query_glass] > 1 ? 1 : towers[query_row][query_glass];
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        System.out.println(champagneTower.champagneTower(2, 1, 1));
    }
}
