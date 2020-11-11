package lxl.work2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，
 * 且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 * <p>
 * 输出：6
 * <p>
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 * @author: lxl
 * @create: 2020-09-12 15:05
 **/
public class BreakfastNumber {
    private int m = 1000000007;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        if (staple.length > drinks.length) {
            int[] temp = staple;
            staple = drinks;
            drinks = temp;
        }
        Arrays.sort(staple);
        Arrays.sort(drinks);
        Map<Integer, Integer> help = new HashMap<>();
        int sum = 0;
        int max = drinks.length;
        for (int s : staple) {
            if (s > x) {
                break;
            }
            if (help.containsKey(s)) {
                sum += help.get(s);
                sum = sum % m;
                continue;
            }
            int offset = Arrays.binarySearch(drinks, 0, max, x - s + 1);
            if (offset < 0) {
                offset = 0 - offset - 1;
                if (offset == 0) {
                    break;
                }
            }
            max = offset;
            sum += offset;
            sum = sum % m;
            help.put(s, offset);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 4, 5};

        BreakfastNumber breakfastNumber = new BreakfastNumber();
        System.out.println(breakfastNumber.breakfastNumber(a, b, 7));
        //int[] a = {1,2,4};
        //System.out.println(Arrays.binarySearch(a,1));
        //System.out.println(0-Arrays.binarySearch(a,3)-1);

    }

}
