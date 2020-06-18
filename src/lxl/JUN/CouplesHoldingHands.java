package lxl.JUN;

/**
 * @program: leetcode-hz
 * @description: 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * <p>
 * 示例 2:
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * <p>
 * 说明:
 * <p>
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-18 10:27
 **/
public class CouplesHoldingHands {

    public int minSwapsCouples(int[] row) {
        int count = 0;
        int index;
        for (int i = 0, l = row.length - 2; i < l; i += 2) {
            index = (row[i] ^ 1);
            if (index == row[i + 1]) {
                continue;
            }
            count++;
            for (int j = i + 2; j < l + 2; j++) {
                if (index == row[j]) {
                    row[j] = row[i + 1];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands();
        int[] rows = {0, 2, 1, 3, 4, 6, 7, 5};
        System.out.println(couplesHoldingHands.minSwapsCouples(rows));
    }
}
