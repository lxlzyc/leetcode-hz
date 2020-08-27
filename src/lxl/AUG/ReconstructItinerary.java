package lxl.AUG;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * @author: lxl
 * @create: 2020-08-27 11:02
 **/
public class ReconstructItinerary {

    private List<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {

        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        Map<String, List<String>> ticketMap = new HashMap<>();
        for (List<String> list : tickets) {
            List<String> values = ticketMap.getOrDefault(list.get(0), new LinkedList<>());
            values.add(list.get(1));
            ticketMap.put(list.get(0), values);
        }

        ans = new LinkedList<>();
        ans.add("JFK");
        this.getTickets(ticketMap, "JFK");
        return ans;

    }

    private boolean getTickets(Map<String, List<String>> ticketMap, String ticket) {
        if (ticketMap.isEmpty()) {
            return true;
        }
        if (ticketMap.containsKey(ticket)) {
            List<String> tickets = ticketMap.get(ticket);
            for (int i = 0, l = tickets.size(); i < l; i++) {
                String nextTicket = tickets.get(i);
                tickets.remove(i);
                if (tickets.isEmpty()) {
                    ticketMap.remove(ticket);
                } else {
                    ticketMap.put(ticket, tickets);
                }
                ans.add(nextTicket);
                if (this.getTickets(ticketMap, nextTicket)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
                tickets.add(i, nextTicket);
                ticketMap.put(ticket, tickets);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> list1 = reconstructItinerary.build("JFK", "SFO");
        List<String> list2 = reconstructItinerary.build("JFK", "ATL");
        List<String> list3 = reconstructItinerary.build("SFO", "ATL");
        List<String> list4 = reconstructItinerary.build("ATL", "JFK");
        List<String> list5 = reconstructItinerary.build("ATL", "SFO");
        List<List<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        System.out.println(JSONUtil.toJson(reconstructItinerary.findItinerary(lists)));
    }

    public List<String> build(String value1, String value2) {
        List<String> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        return list;
    }
}
