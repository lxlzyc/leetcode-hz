package lxl.OCT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 146. LRU缓存机制
 * @author: lxl
 * @create: 2020-10-16 11:27
 **/
public class LRUCache3 {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    private Map<Integer, Node> nodes;
    private Node head, tail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node index = nodes.get(key);
            this.removeNode(index);
            this.insertToFirst(index);
            return nodes.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node index;
        if (nodes.containsKey(key)) {
            index = nodes.get(key);
            index.value = value;
            //移除index前后节点连接
            this.removeNode(index);
        } else {
            index = new Node(key, value);
        }
        nodes.put(key, index);
        //插入头结点
        this.insertToFirst(index);
        if (nodes.size() > capacity) {
            //移除尾节点
            Node last = tail.pre;
            nodes.remove(last.key);
            this.removeNode(tail.pre);
        }
    }

    private void removeNode(Node index) {
        //移除index前后节点连接
        index.pre.next = index.next;
        index.next.pre = index.pre;
    }

    private void insertToFirst(Node index) {
        //index插入到head
        head.next.pre = index;
        index.next = head.next;
        index.pre = head;
        head.next = index;
    }

    public static void main(String[] args) {
        LRUCache3 lruCache = new LRUCache3(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
