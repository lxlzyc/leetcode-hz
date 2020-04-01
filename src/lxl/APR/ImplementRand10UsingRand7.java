package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的 Math.random() 方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [7]
 * <p>
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [8,4]
 * <p>
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [8,1,10]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 * <p>
 * <p>
 * <p>
 * 进阶:
 * <p>
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-01 14:47
 **/
public class ImplementRand10UsingRand7 {
    private int rand7() {
        return 1;
    }

    //我们可以用拒绝采样的方法实现 Rand10()。在拒绝采样中，如果生成的随机数满足要求，
    // 那么久返回该随机数，否则会不断生成直到一个满足要求的随机数为止。若我们调用两次 Rand7()，
    // 那么可以生成 [1, 49] 之间的随机整数，我们只用到其中的 40 个，用来实现 Rand10()，
    // 而拒绝剩下的 9 个数，如下图所示。
    // 核心就是 等概率映射，映射不到的就继续调用
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
