package lxl.y2020.JUN;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * <p>
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-09 14:15
 **/
public class DesignHashset {

    static class Bucket {
        private LinkedList<Integer> link;

        public Bucket() {
            link = new LinkedList<>();
        }

        public void add(int val) {
            if (!link.contains(val)) {
                link.add(val);
            }
        }

        public void remove(int val) {
            link.removeFirstOccurrence(val);
        }

        public boolean contains(int val) {
            return link.contains(val);
        }
    }

    /**
     * Initialize your data structure here.
     */
    private int keyRange;
    private Bucket[] bucketArray;

    public DesignHashset() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i) {
            this.bucketArray[i] = new Bucket();
        }
    }

    protected int indexHash(int key) {
        return (key % this.keyRange);
    }


    public void add(int key) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        bucket.add(key);
    }

    public void remove(int key) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        bucket.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        return bucket.contains(key);
    }


}
