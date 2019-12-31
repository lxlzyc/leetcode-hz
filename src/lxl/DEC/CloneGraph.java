package lxl.DEC;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 133. 克隆图
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clone-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-31 10:27
 **/
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    ;

    public Node cloneGraph(Node node) {
        Set<Integer> clones = new HashSet<>();
        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Integer, Node> mapClone = new HashMap<>();

        this.putNodeToMap(map, node);
        for (Integer key : map.keySet()) {
            Node clone = new Node();
            clone.val = key;
            mapClone.put(key, clone);
        }
        for (Integer key : map.keySet()) {
            Node index = map.get(key);
            List<Node> nodeListClone = new ArrayList<>();
            for (Node nodeListIndex : index.neighbors) {
                nodeListClone.add(mapClone.get(nodeListIndex.val));
            }
            mapClone.get(key).neighbors = nodeListClone;
        }
        return mapClone.get(node.val);
    }

    private void putNodeToMap(HashMap<Integer, Node> map, Node node) {
        map.put(node.val, node);
        for (Node index : node.neighbors) {
            if (!map.containsKey(index.val)) {
                this.putNodeToMap(map, index);
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        node1.neighbors = list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors = list2;
        List<Node> list3 = new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors = list3;
        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors = list4;
        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(node1);
    }

}
