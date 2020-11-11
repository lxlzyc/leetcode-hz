package lxl.y2020.JUN;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-13 14:18
 **/
public class SelfDividingNumbers {
    private Set<Integer> set = new HashSet<>();

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (this.checkNum(i)) {
                set.add(i);
                list.add(i);
            }
        }
        return list;
    }

    private boolean checkNum(int i) {
        if ((i >= 1 && i <= 9) || set.contains(i)) {
            return true;
        }
        int help = i;
        //，对于 128，我们要判断 d != 0 && 128 % d == 0，且 d = 1, 2, 8。
        char[] chars = String.valueOf(i).toCharArray();
        for (int j = 0, l = chars.length; j < l; j++) {
            if (chars[j] == '0' || i % (chars[j] - '0') > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(JSONUtil.toJson(selfDividingNumbers.selfDividingNumbers(1, 100)));
    }

}
