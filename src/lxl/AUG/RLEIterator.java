package lxl.AUG;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 900. RLE 迭代器
 * 编写一个遍历游程编码序列的迭代器。
 * <p>
 * 迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。
 * <p>
 * 迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。
 * <p>
 * 例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。这是因为该序列可以读作 “三个八，零个九，两个五”。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
 * 输出：[null,8,8,5,-1]
 * 解释：
 * RLEIterator 由 RLEIterator([3,8,0,9,2,5]) 初始化。
 * 这映射到序列 [8,8,8,5,5]。
 * 然后调用 RLEIterator.next 4次。
 * <p>
 * .next(2) 耗去序列的 2 个项，返回 8。现在剩下的序列是 [8, 5, 5]。
 * <p>
 * .next(1) 耗去序列的 1 个项，返回 8。现在剩下的序列是 [5, 5]。
 * <p>
 * .next(1) 耗去序列的 1 个项，返回 5。现在剩下的序列是 [5]。
 * <p>
 * .next(2) 耗去序列的 2 个项，返回 -1。 这是由于第一个被耗去的项是 5，
 * 但第二个项并不存在。由于最后一个要耗去的项不存在，我们返回 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 1000
 * A.length 是偶数。
 * 0 <= A[i] <= 10^9
 * 每个测试用例最多调用 1000 次 RLEIterator.next(int n)。
 * 每次调用 RLEIterator.next(int n) 都有 1 <= n <= 10^9 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rle-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-04 15:29
 **/
public class RLEIterator {

    private LinkedList<Integer> values;
    private LinkedList<Integer> counts;

    public RLEIterator(int[] A) {
        values = new LinkedList<>();
        counts = new LinkedList<>();
        for (int i = 0, l = A.length - 1; i < l; i += 2) {
            if (A[i] > 0) {
                values.offer(A[i + 1]);
                counts.offer(A[i]);
            }
        }
    }

    public int next(int n) {
        int index = -1;
        while (!counts.isEmpty() && n > 0) {
            int indexCount = counts.removeFirst();
            if (indexCount <= n) {
                n = n - indexCount;
                index = values.getFirst();
                values.removeFirst();
            } else {
                index = values.getFirst();
                counts.addFirst(indexCount - n);
                return index;
            }
        }
        return n > 0 ? -1 : index;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 0, 9, 2, 5};
        RLEIterator rleIterator = new RLEIterator(A);
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));

    }
}
