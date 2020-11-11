package lxl.y2020.AUG;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 935. 骑士拨号器
 * 国际象棋中的骑士可以按下图所示进行移动：
 * <p>
 * .
 * <p>
 * <p>
 * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
 * <p>
 * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
 * <p>
 * 你能用这种方式拨出多少个不同的号码？
 * <p>
 * 因为答案可能很大，所以输出答案模 10^9 + 7。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：10
 * <p>
 * 示例 2：
 * <p>
 * 输入：2
 * 输出：20
 * <p>
 * 示例 3：
 * <p>
 * 输入：3
 * 输出：46
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 5000
 * @author: lxl
 * @create: 2020-08-14 10:19
 **/
public class KnightDialer {
    //1 2 3
    //4 5 6
    //7 8 9
    //  0
    private List<Integer>[] nextNums;

    public KnightDialer() {
        nextNums = new List[10];
        List<Integer> num0 = new ArrayList<>(Arrays.asList(4, 6));
        List<Integer> num1 = new ArrayList<>(Arrays.asList(6, 8));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(7, 9));
        List<Integer> num3 = new ArrayList<>(Arrays.asList(4, 8));
        List<Integer> num4 = new ArrayList<>(Arrays.asList(0, 3, 9));
        List<Integer> num5 = new ArrayList<>(Arrays.asList());
        List<Integer> num6 = new ArrayList<>(Arrays.asList(0, 1, 7));
        List<Integer> num7 = new ArrayList<>(Arrays.asList(2, 6));
        List<Integer> num8 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> num9 = new ArrayList<>(Arrays.asList(4, 2));
        nextNums[0] = num0;
        nextNums[1] = num1;
        nextNums[2] = num2;
        nextNums[3] = num3;
        nextNums[4] = num4;
        nextNums[5] = num5;
        nextNums[6] = num6;
        nextNums[7] = num7;
        nextNums[8] = num8;
        nextNums[9] = num9;
    }

    private static final int mod = 1_000_000_007;

    public int knightDialer(int N) {
        int count = 0;
        int[] nexts = new int[10];
        //初始化1
        Arrays.fill(nexts, 1);
        for (int j = 1; j < N; j++) {
            int[] nextsHelp = new int[10];
            for (int i = 0; i < 10; i++) {
                if (nexts[i] > 0) {
                    for (int next : nextNums[i]) {
                        nextsHelp[next] += nexts[i];
                        nextsHelp[next] = nextsHelp[next] % mod;
                    }
                }
            }
            nexts = nextsHelp;
        }
        long ans = 0;
        for (int item : nexts) {
            ans += item;
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(100));
    }
}
