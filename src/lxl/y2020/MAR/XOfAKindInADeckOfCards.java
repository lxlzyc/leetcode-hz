package lxl.y2020.MAR;

import java.util.Arrays;

/**
 * @program: leetcode-hz
 * @description: 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * <p>
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * <p>
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-27 17:06
 **/
public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        int length = deck.length;
        Arrays.sort(deck);
        if (deck[0] != deck[1]) {
            return false;
        }
        int index = 2;
        int lineCount = 2;
        int pre = deck[0];
        while (index < length && deck[index] == pre) {
            lineCount++;
            index++;
        }
        if (index >= length) {
            return true;
        }
        while (lineCount % 2 == 0) {
            lineCount = lineCount / 2;
        }
        if (lineCount == 1) {
            lineCount = 2;
        }
        if (length % lineCount != 0) {
            return false;
        }
        for (int i = index; i < length; i++) {
            pre = deck[i];
            for (int j = 1; j < lineCount; j++) {
                if (deck[i + j] != pre) {
                    return false;
                } else {
                    pre = deck[i + j];
                }
            }
            i += lineCount - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();
        int[] nums = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(nums));
    }
}
