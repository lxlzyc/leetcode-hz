package lxl.y2020.JAN;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-10 15:06
 **/
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return this.resolvCombinationSum3(k, n, 0);
    }

    private List<List<Integer>> resolvCombinationSum3(int k, int n, int min) {
        List<List<Integer>> re = new ArrayList<>();
        if (k == 1) {
            if (n > min && n < 10) {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                re.add(list);
            }
            return re;
        }
        for (int i = min + 1; i <= 9; i++) {
            if (i >= (n / k + 1)) {
                break;
            }
            List<List<Integer>> next = this.resolvCombinationSum3(k - 1, n - i, i);
            for (List<Integer> list : next) {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                index.addAll(list);
                re.add(index);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(1, 19));
    }

}
