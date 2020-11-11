package lxl.y2020.OCT;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode-hz
 * @description: 1366. 通过投票对团队排名
 * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
 * <p>
 * 排名规则如下：
 * <p>
 * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 * <p>
 * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 * <p>
 * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
 * 输出："ACB"
 * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
 * B 队获得两票「排位第二」，三票「排位第三」。
 * C 队获得三票「排位第二」，两票「排位第三」。
 * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
 * <p>
 * 示例 2：
 * <p>
 * 输入：votes = ["WXYZ","XYZW"]
 * 输出："XWYZ"
 * 解释：X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
 * <p>
 * 示例 3：
 * <p>
 * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * 解释：只有一个投票者，所以排名完全按照他的意愿。
 * <p>
 * 示例 4：
 * <p>
 * 输入：votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
 * 输出："ABC"
 * 解释：
 * A 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * B 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * C 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * 完全并列，所以我们需要按照字母升序排名。
 * <p>
 * 示例 5：
 * <p>
 * 输入：votes = ["M","M","M","M"]
 * 输出："M"
 * 解释：只有 M 队参赛，所以它排名第一。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= votes.length <= 1000
 * 1 <= votes[i].length <= 26
 * votes[i].length == votes[j].length for 0 <= i, j < votes.length
 * votes[i][j] 是英文 大写 字母
 * votes[i] 中的所有字母都是唯一的
 * votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-teams-by-votes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-26 09:46
 **/
public class RankTeamsByVotes {

    static class Node {
        int[] count;
        int sum;
        char val;

        public Node(char val) {
            this.count = new int[26];
            this.val = val;
            this.sum = 0;
        }

        public void addCount(int offset) {
            count[offset]++;
            sum++;
        }
    }

    public String rankTeams(String[] votes) {
        Node[] nodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }
        int len = votes[0].length();
        for (int i = 0, l = votes.length; i < l; i++) {
            char[] index = votes[i].toCharArray();
            for (int j = 0; j < len; j++) {
                nodes[index[j] - 'A'].addCount(j);
            }
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int[] count1 = o1.count;
                int[] count2 = o2.count;
                for (int i = 0; i < 26; i++) {
                    if (count1[i] == count2[i]) {
                        continue;
                    }
                    return Integer.compare(count2[i], count1[i]);
                }
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (nodes[i].sum == 0) {
                break;
            }
            stringBuilder.append(nodes[i].val);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        String[] votes = {
                "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL", "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"
        };
        System.out.println(rankTeamsByVotes.rankTeams(votes));
    }


}
