package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 838. 推多米诺
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 * <p>
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 * <p>
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 * <p>
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * <p>
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 * <p>
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，
 * 则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 * <p>
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * <p>
 * 示例 2：
 * <p>
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10^5
 * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 * <p>
 * 通过次数3,644
 * 提交次数7,967
 * 在真实的面试中遇到过这道题？
 * 贡献者
 * LeetCode
 * 838/1715
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-16 09:45
 **/
public class PushDominoes {

    // 计算受力
    //我们可以对每个多米诺骨牌计算净受力。我们关心的受力取决于一个多米诺骨牌和最近的左侧 'R' 右侧 'L' 的距离：哪边近，就受哪边力更多。
    //
    //算法
    //
    //从左向右扫描，我们的力每轮迭代减少 1.重置为 N 当我们遇到一个 'R' 时，所以 force[i] 比 force[j] 大当且仅当 dominoes[i] 比 dominoes[j] 离最左边的 'R' 近。
    //
    //类似的，从右向左搜啊秒，可以找到向左侧的力，离 L 的远近。
    //
    //对于骨牌的结果 answer[i]，如果左右两侧力相等，答案是 '.'。否则，哪边力大答案就是哪边。
    //
    //样例
    //
    //下面是对字符串 S = 'R.R...L' 的模拟：我们从左向右暴力得到的结果为 [7, 6, 7, 6, 5, 4, 0]，从右向左扫描的结果为 [0, 0, 0, -4, -5, -6, -7]。合并之后，合力为 [7, 6, 7, 2, 0, -2, -7] 所以最近结果为 RRRR.LL。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/push-dominoes/solution/tui-duo-mi-nuo-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String pushDominoes(String dominoes) {

        //计算左侧受力
        int pre = 0;
        char[] chars = dominoes.toCharArray();
        int l = chars.length;
        int[] forces = new int[l];
        int force = 0;
        //左侧受力
        for (int i = 0; i < l; i++) {
            if (chars[i] == 'R') {
                force = l;
            } else if (chars[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = force;
        }
        //右侧受力 加
        force = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (chars[i] == 'L') {
                force = l;
            } else if (chars[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < l; i++) {
            stringBuilder.append(forces[i] > 0 ? 'R' : (forces[i] == 0 ? '.' : 'L'));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes.pushDominoes("RR.L"));

    }

}
