package lxl.y2020.DEC;

import java.util.ArrayList;

/**
 * @program: leetcode-hz
 * @description: 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 *     "123" 1
 *     "132" 2
 *     "213" 3
 *     "231" 4
 *     "312"
 *     "321"
 *
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 *     给定 n 的范围是 [1, 9]。
 *     给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-16 16:44
 **/
public class PermutationSequence {
    //共有 n*n-1*n-2*... 种排列
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        int count = this.count(n);

        StringBuffer stringBuffer = new StringBuffer();
        int step ;
        int offset;
        for (int i = 0; i < n-1; i++) {
            step = count/(n-i);
            offset = (k-1)/step ;
            stringBuffer.append(list.get(offset));
            list.remove(offset);
            k = k%step == 0 ? step:k%step;
            count = step;
        }
        stringBuffer.append(list.get(0));
        return stringBuffer.toString();
    }


    private int count(int n){
        if(n == 1){
            return 1;
        }
        return n*count(n-1);
    }
    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3,3));//"2314"
    }

}
