package lxl.y2020.JUL;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: leetcode-hz
 * @description: 846. 一手顺子
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-17 13:52
 **/
public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) {
            return true;
        }
        int length = hand.length;
        if (length % W > 0) {
            return false;
        }
        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        for (int num : hand) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        int size = numCount.size();
        if (size < W) {
            return false;
        }
        int firstKey;
        int firstCount;
        int indexKey;
        while (!numCount.isEmpty()) {
            Map.Entry<Integer, Integer> entry = numCount.pollFirstEntry();
            firstKey = entry.getKey();
            firstCount = entry.getValue();
            for (int j = 1; j < W; j++) {
                indexKey = firstKey + j;
                if (numCount.containsKey(indexKey)) {
                    int value = numCount.get(indexKey) - firstCount;
                    if (value < 0) {
                        return false;
                    } else if (value == 0) {
                        numCount.remove(indexKey);
                    } else {
                        numCount.put(indexKey, value);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();
        int[] hand = {2, 8};
        System.out.println(handOfStraights.isNStraightHand(hand, 2));
    }
}
