package lxl.y2021.DEC;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 649. Dota2 参议院
 * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 * <p>
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 * <p>
 * 禁止一名参议员的权利：
 * <p>
 * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 * <p>
 * 宣布胜利：
 * <p>
 * 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
 * <p>
 * <p>
 * <p>
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * <p>
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 * <p>
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："RD"
 * 输出："Radiant"
 * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 * <p>
 * 示例 2：
 * <p>
 * 输入："RDD"
 * 输出："Dire"
 * 解释：
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定字符串的长度在 [1, 10,000] 之间.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dota2-senate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-11 10:57
 **/
public class Dota2Senate {

    static class Node {
        int status;
        char index;

    }

    public String predictPartyVictory(String senate) {
        int l = senate.length();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int rcount = 0;
        int dcount = 0;
        //第一轮遍历
        for (int i = 0; i < l; i++) {
            char index = senate.charAt(i);
            if (index == 'R') {
                if (dcount > 0) {
                    dcount--;
                } else {
                    rcount++;
                    linkedList.addLast(i);
                }
            } else {
                if (rcount > 0) {
                    rcount--;
                } else {
                    dcount++;
                    linkedList.addLast(i);
                }
            }
        }
        while (rcount < linkedList.size() && dcount < linkedList.size()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0, size = linkedList.size(); i < size; i++) {
                char index = senate.charAt(linkedList.removeFirst());
                if (index == 'R') {
                    if (dcount > 0) {
                        dcount--;
                    } else {
                        rcount++;
                        temp.addLast(i);
                    }
                } else {
                    if (rcount > 0) {
                        rcount--;
                    } else {
                        dcount++;
                        temp.addLast(i);
                    }
                }
            }
            linkedList = temp;
        }
        return rcount > dcount ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        System.out.println(dota2Senate.predictPartyVictory("DRRDDR"));
    }
}
