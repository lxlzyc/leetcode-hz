package lxl.AUG;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 632. 最小区间
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1:
 * <p>
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * <p>
 * 注意:
 * <p>
 * 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
 * 1 <= k <= 3500
 * -105 <= 元素的值 <= 105
 * 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-01 10:09
 **/
public class SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        int l = nums.size();
        if (l == 1) {
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        }
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            int offset = i;
            List<Integer> index = nums.get(offset);
            for (Integer num : index) {
                lists.add(new int[]{num, offset});
            }
        }
        Collections.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //滑动窗口获取
        int dirCount = 0;
        int[] dirHelp = new int[l];
        int left = 0;
        int right = 0;
        int max = lists.size();
        int[] ans = new int[]{lists.get(0)[0], lists.get(max - 1)[0]};
        int indexValue;
        while (right < max) {
            indexValue = lists.get(right)[1];
            if (dirHelp[indexValue] > 0) {
                dirHelp[indexValue]++;
            } else {
                dirHelp[indexValue]++;
                dirCount++;
                if (dirCount == l) {
                    //移动left
                    while (left <= right) {
                        if (dirHelp[lists.get(left)[1]] > 1) {
                            dirHelp[lists.get(left)[1]]--;
                            left++;
                        } else {
                            break;
                        }
                    }
                    ////比较更新ans
                    if (ans[1] - ans[0] > lists.get(right)[0] - lists.get(left)[0]) {
                        ans[0] = lists.get(left)[0];
                        ans[1] = lists.get(right)[0];
                    }
                    dirCount--;
                    dirHelp[lists.get(left)[1]]--;
                    left++;

                }
            }
            right++;
        }
        return ans;
    }

    public List<Integer> buildList(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0, l = nums.length; i < l; i++) {
            integers.add(nums[i]);
        }
        return integers;
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists sm = new SmallestRangeCoveringElementsFromKLists();


        List<List<Integer>> base = new ArrayList<>();
        base.add(sm.buildList(new int[]{11, 38, 83, 84, 84, 85, 88, 89, 89, 92}));
        base.add(sm.buildList(new int[]{28, 11, 8}));
        base.add(sm.buildList(new int[]{52, 11, 79, 80, 81}));
        //base.add(sm.buildList(new int[]{21,25,26,26,26,27}));
        //base.add(sm.buildList(new int[]{9,83,85,90}));
        //base.add(sm.buildList(new int[]{84,85,87}));
        //base.add(sm.buildList(new int[]{26,68,70,71}));
        //base.add(sm.buildList(new int[]{36,40,41,42,45}));
        //
        //base.add(sm.buildList(new int[]{-34,21}));
        //base.add(sm.buildList(new int[]{-28,-28,-23,1,13,21,28,37,37,38}));
        //base.add(sm.buildList(new int[]{-74,1,2,22,33,35,43,45}));
        //base.add(sm.buildList(new int[]{54,96,98,98,99}));
        //base.add(sm.buildList(new int[]{43,54,60,65,71,75}));
        //base.add(sm.buildList(new int[]{43,46}));
        //base.add(sm.buildList(new int[]{50,50,58,67,69}));
        //base.add(sm.buildList(new int[]{7,14,15}));
        //base.add(sm.buildList(new int[]{78,80,89,89,90}));
        //base.add(sm.buildList(new int[]{35,47,63,69,77,92,94}));

        System.out.println(Arrays.toString(sm.smallestRange(base)));

    }
}
