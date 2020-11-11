package lxl.y2020.AUG;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 911. 在线选举
 * 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
 * <p>
 * 现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
 * <p>
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * <p>
 * 示例：
 * <p>
 * 输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * 输出：[null,0,1,1,0,0,1]
 * 解释：
 * 时间为 3，票数分布情况是 [0]，编号为 0 的候选人领先。
 * 时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。
 * 时间为 25，票数分布情况是 [0,1,1,0,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。
 * 在时间 15、24 和 8 处继续执行 3 个查询。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times 是严格递增的数组，所有元素都在 [0, 10^9] 范围中。
 * 每个测试用例最多调用 10000 次 TopVotedCandidate.q。
 * TopVotedCandidate.q(int t) 被调用时总是满足 t >= times[0]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-election
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-06 14:45
 **/
public class TopVotedCandidate {
    private int[] times;
    private int[] tops;
    private int l;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        l = persons.length;
        tops = new int[persons.length];
        int max = persons[0];
        int maxCount = 1;
        Map<Integer, Integer> help = new HashMap<>();
        help.put(max, 1);
        tops[0] = max;
        for (int i = 1; i < l; i++) {
            int count = help.getOrDefault(persons[i], 0);
            if (count + 1 >= maxCount) {
                max = persons[i];
                maxCount = count + 1;
            }
            help.put(persons[i], count + 1);
            tops[i] = max;
        }
    }

    //二分搜索 二分模板找到小于t的最大数字的位置，返回对应位置-1的data值即可。
    public int q(int t) {
        int left = 0, right = l;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (times[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return tops[left - 1];
    }

    //["TopVotedCandidate","q","q","q","q","q","q","q","q","q","q"]
    //        [[[0,1,0,1,1],[24,29,31,76,81]],[28],[24],[29],[77],[30],[25],[76],[75],[81],[80]]
    public static void main(String[] args) {
        int[] persions = {0, 0, 0, 0, 1};
        int[] times = {0, 6, 39, 52, 75};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persions, times);
        System.out.println(topVotedCandidate.q(78));
        //System.out.println(topVotedCandidate.q(12));
        //System.out.println(topVotedCandidate.q(25));
        //System.out.println(topVotedCandidate.q(15));
        //System.out.println(topVotedCandidate.q(24));
        //System.out.println(topVotedCandidate.q(8));

    }
}
