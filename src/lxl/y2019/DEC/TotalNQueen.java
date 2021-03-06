package lxl.y2019.DEC;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 52. N皇后 II
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-12 10:19
 **/
public class TotalNQueen {
    public int solveNQueens(int n) {
        int max = n * n;
        //HashSet<Integer> notEffect = new HashSet<>((int) (n * n * 2));
        int[] notEffect = new int[n * n];
        List<List<String>> lists = this.solveNQueensInner(notEffect, max, n, 0);
        Iterator<List<String>> it = lists.iterator();
        while (it.hasNext()) {
            List<String> str = it.next();
            if (str.size() < n) {
                it.remove();
            }
        }
        return lists.size();
    }

    private List<List<String>> solveNQueensInner(int[] notEffect, int max, int n, int i) {
        if (i == n) {
            return new ArrayList<>();
        }
        List<List<String>> re = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (notEffect[i * n + j] == 0) {
                String index = this.buildString(n, j);
                int[] notEffectClone = Arrays.copyOf(notEffect, notEffect.length);
                this.putNotEffect(notEffectClone, n, i, j);
                List<List<String>> solve = this.solveNQueensInner(notEffectClone, max, n, i + 1);
                if (solve.size() <= 0) {
                    List<String> list = new ArrayList<>();
                    list.add(index);

                    re.add(list);
                } else {
                    for (List<String> solveString : solve) {
                        List<String> list = new ArrayList<>();
                        list.add(index);
                        list.addAll(solveString);
                        re.add(list);
                    }
                }
            }
        }
        return re;
    }

    private String buildString(int n, int j) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[j] = 'Q';
        return String.valueOf(chars);
    }

    private void putNotEffect(int[] set, int n, int i, int j) {
        //set.clear();
        for (int k = 0; k < n; k++) {
            //横
            set[i * n + k] = 1;
            //竖
            set[k * n + j] = 1;
            //左斜
            if (i + k < n && j + k < n) {
                set[(i + k) * n + j + k] = 1;

            }
            if (i - k >= 0 && j - k >= 0) {
                set[(i - k) * n + j - k] = 1;

            }
            //右斜
            if (i + k < n && j - k >= 0) {
                set[(i + k) * n + j - k] = 1;

            }
            if (i - k >= 0 && j + k < n) {
                set[(i - k) * n + j + k] = 1;

            }


        }
    }

    public static void main(String[] args) {
        TotalNQueen nqueen = new TotalNQueen();
        System.out.println(JSONUtil.toJson(nqueen.solveNQueens(4)));
    }

}
