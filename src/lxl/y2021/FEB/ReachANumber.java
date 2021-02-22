package lxl.y2021.FEB;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * <p>
 * 返回到达终点需要的最小移动次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 * <p>
 * 示例 2:
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * <p>
 * 注意:
 * <p>
 * target是在[-10^9, 10^9]范围中的非零整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reach-a-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/22 11:10
 * @Version 1.0
 */
public class ReachANumber {
    //    首先， 由于坐标轴是对称的，往左往右走的几率相等，因此可以只考虑右半轴。先递推一下可以知道:
//
//    步数        能到达的位置
//1:          1
//        2:          3, 1
//        3:          6, 4, 2, 0
//        4:          10, 8, 6, 4, 0
//        5:          15, 13, 11, 9, 7, 5, 3, 1
//        ...
//
//    可以看出来，每一步能到达的最大位置是上一步最大位置加上步数，而每一步所能达到的位置之间间隔都为2。
//    记f(n)为第n步能到达的位置，那么有：
//
//    max(f(n)) = max(f(n-1)) + n
//    f(n) = [max(f(n)),  max(f(n)) - 2, max(f(n)) - 4, ....]
//
//    如果target可以在第n步达到，那么target一定小于等于max(f(n))且max(f(n))与taget同奇同偶。
//
//    根据以上分析就可以轻松写出代码:
//
//    class Solution:
//    def reachNumber(self, target: int) -> int:
//    target = abs(target)
//    p, i = 0, 0
//            while p < target or (p + target) % 2 != 0:
//    i += 1
//    p = p + i
//        return i
//
//    其中，p保存max(f(n))， i保存步数
//
//    作者：zhengkang
//    链接：https://leetcode-cn.com/problems/reach-a-number/solution/pythonchao-ji-jian-ji-de-jie-fa-by-zhengkang/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int reachNumber(int target) {
        target = Math.abs(target);
        int help = target % 2;
        int max = 0;
        int step = 0;
        while (max < target || max % 2 != help) {
            step += 1;
            max += step;
        }
        return step;
    }
}