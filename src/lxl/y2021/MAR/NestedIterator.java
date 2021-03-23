package lxl.y2021.MAR;

import java.util.*;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/23 10:21
 * @Version 1.0
 */
public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    private int offset;
    private Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        offset = 0;
        queue = new LinkedList<>();
        this.dfs(nestedList);
        System.out.println(queue.peek());
    }

    private void dfs(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return;
        }
        for (int i = 0, l = nestedList.size(); i < l; i++) {
            this.dfs(nestedList.get(i));
        }
    }

    private void dfs(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            this.queue.offer(nestedInteger.getInteger());
        } else {
            this.dfs(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
