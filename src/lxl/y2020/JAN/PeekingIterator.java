package lxl.y2020.JAN;

import java.util.Iterator;

/**
 * @program: leetcode-hz
 * @description: 284. 顶端迭代器
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * <p>
 * 示例:
 * <p>
 * 假设迭代器被初始化为列表 [1,2,3]。
 * <p>
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-16 11:21
 **/
public class PeekingIterator implements Iterator<Integer> {

    private Integer peek = null;
    private Iterator<Integer> iterator = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (peek == null && iterator.hasNext()) {
            peek = iterator.next();
        }
        return peek;
    }

    @Override
    public boolean hasNext() {
        if (peek != null) {
            return true;
        }
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        Integer re = null;
        if (peek != null) {
            re = peek;
            peek = null;
            return re;
        }
        if (iterator.hasNext()) {
            re = iterator.next();
        }
        return re;
    }
}
