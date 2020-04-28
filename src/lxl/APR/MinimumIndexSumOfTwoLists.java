package lxl.APR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * <p>
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-26 09:36
 **/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        if (len1 > len2) {
            String[] help = list1;
            list1 = list2;
            list2 = help;
            len1 = len2;
            len2 = list2.length;
        }

        Map<String, Integer> offsets = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            offsets.put(list2[i], i);
        }
        List<String> strings = new ArrayList<>();
        int min = len1 + len2;
        for (int i = 0; i < len1; i++) {
            if (i > min) {
                break;
            }
            String index = list1[i];
            if (offsets.containsKey(index)) {
                int indexMin = offsets.get(index) + offsets.get(index);
                if (indexMin < min) {
                    strings.clear();
                    strings.add(index);
                    min = indexMin;
                } else if (indexMin == min) {
                    strings.add(index);
                }
            }
        }

        return strings.toArray(new String[strings.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();

        System.out.println(minimumIndexSumOfTwoLists.findRestaurant(list1, list2));


    }

}
