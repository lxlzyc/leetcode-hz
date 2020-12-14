package lxl.y2020.DEC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-01 09:44
 **/
public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = dominoes[0].length;
        for (int[] dominoe : dominoes) {
            int sum = 0;
            Arrays.sort(dominoe);
            for (int i = 0, dl = dominoe.length; i < dl; i++) {
                sum *= 10;
                sum += dominoe[i];
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            ans += val * (val - 1) / 2;
        }
        return ans;
    }
}
