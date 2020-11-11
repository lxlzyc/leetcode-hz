package lxl.y2020.JUN;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * <p>
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * <p>
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * <p>
 * 例子 1:
 * <p>
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * 第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 * 我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 * <p>
 * 注意：
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-11 10:57
 **/
public class AccountsMerge {

    //算法：
    //对于每个帐户，从第一个电子邮件到所有其他电子邮件画一条边。另外，我们会记录一张从电子邮件到名字的哈希表。然后使用深度优先搜索合并相同的账户。
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    //并查集
    class EmailBc {
        int[] bc;

        public EmailBc(int n) {
            bc = new int[n];
            init();
        }

        public void init() {
            for (int i = 0; i < bc.length; i++) {
                bc[i] = -1;
            }
        }

        public int find(int x) {
            if (bc[x] < 0) {
                return x;
            } else {
                bc[x] = find(bc[x]);
            }
            return bc[x];
        }

        public void combine(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) {
                bc[yy] = xx;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        EmailBc bc = new EmailBc(n);
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {
                    int flag = map.get(email);
                    bc.combine(flag, i);
                }
                map.put(email, i);
            }
        }
        Map<Integer, Set<String>> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index = bc.find(i);
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            if (map2.containsKey(index)) {
                map2.get(index).addAll(emails);
            } else {
                map2.put(index, new TreeSet<>(emails));
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, Set<String>> entry : map2.entrySet()) {
            List<String> tmp = new LinkedList<>();
            int index = entry.getKey();
            String name = accounts.get(index).get(0);
            tmp.add(name);
            tmp.addAll(entry.getValue());
            ans.add(tmp);
        }

        return ans;
    }

    public static void main(String[] args) {

        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        List<String> list2 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));
        List<String> list3 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        List<String> list4 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(accountsMerge.accountsMerge(lists));
    }
}
