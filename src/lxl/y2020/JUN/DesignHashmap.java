package lxl.y2020.JUN;

import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 * @author: lxl
 * @create: 2020-06-09 14:15
 **/
public class DesignHashmap {
    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Bucket {
        private LinkedList<Node> link;

        public Bucket() {
            link = new LinkedList<>();
        }

        public void put(int key, int value) {
            for (Node node : link) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
            link.add(new Node(key, value));
        }

        public void remove(int key) {
            for (Node node : link) {
                if (node.key == key) {
                    this.link.remove(node);
                    return;
                }
            }
        }

        public int get(int key) {
            for (Node node : link) {
                if (node.key == key) {
                    return node.value;
                }
            }
            return -1;
        }
    }

    /**
     * Initialize your data structure here.
     */
    private int keyRange;
    private Bucket[] bucketArray;

    public DesignHashmap() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i) {
            this.bucketArray[i] = new Bucket();
        }
    }

    protected int indexHash(int key) {
        return (key % this.keyRange);
    }


    public void put(int key, int value) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        bucket.put(key, value);
    }

    public int get(int key) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        return bucket.get(key);
    }

    public void remove(int key) {
        Bucket bucket = this.bucketArray[this.indexHash(key)];
        bucket.remove(key);
    }

}
