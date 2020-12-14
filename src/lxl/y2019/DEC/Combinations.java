package lxl.y2019.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-18 10:46
 **/
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = this.deal(n,0,k);
        return lists;
    }

    public List<List<Integer>> deal(int n,int beginI,int k) {
        if(k == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = beginI; i < n; i++) {
            List<List<Integer>> nexts = this.deal(n,++beginI,k-1);
            if(nexts.size()>0){
                for (List<Integer> next:nexts ){
                    next.add(0,i+1);
                    lists.add(next);
                }
            }else if(k == 1){
                List<Integer> integers = new ArrayList<>();
                integers.add(i+1);
                lists.add(integers);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(JSONUtil.toJson(combinations.combine(4,2)));
    }

}
