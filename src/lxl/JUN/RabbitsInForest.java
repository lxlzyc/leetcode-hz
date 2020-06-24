package lxl.JUN;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * <p>
 * 返回森林中兔子的最少数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * <p>
 * 输入: answers = []
 * 输出: 0
 * <p>
 * 说明:
 * <p>
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-24 09:59
 **/
public class RabbitsInForest {
    //思路
    //
    //一个兔子只会说跟它颜色相同的兔子还有多少个，说不同数字的兔子之间颜色一定不同。因此可以分别对不同颜色的兔子进行计数。
    //
    //现在有 13 个兔子回答 5。假设其中有一只红色的兔子，在回答 5 的兔子之中还可以有五只红兔子。再假设其中还有一只蓝色的兔子，同样的道理还可以有五只蓝兔子。这时候总共就有 12 只兔子了，6 只红色，6 只蓝色。但回答 5 的还有一只额外的兔子，这只兔子只能是其他的颜色了，同时因为这只兔子回答的是 5，也一定还有同颜色的其他五只兔子。因此这种情况下森林中最少有 18 只兔子。
    //
    //算法
    //
    //假设回答 k 的兔子的数量为 v = count[k]，通过上面分析可以知道至少有 a 只兔子，其中 a 是满足 a >= count[k] 的最小 k + 1 的倍数。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/rabbits-in-forest/solution/sen-lin-zhong-de-tu-zi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : answers) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int sum = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            sum += Math.ceil((double) value / (key + 1)) * (key + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        RabbitsInForest rabbitsInForest = new RabbitsInForest();
        int key = 5;
        int value = 1;
        System.out.println(Math.ceil((double) value / (key + 1)));
        System.out.println(Math.ceil((double) value / (key + 1)) * (key + 1));
    }

}
