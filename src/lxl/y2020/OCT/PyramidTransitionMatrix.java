package lxl.y2020.OCT;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 756. 金字塔转换矩阵
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。
 * <p>
 * 使用三元组表示金字塔的堆砌规则如下：
 * <p>
 * 对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 * <p>
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * <p>
 * 如果可以由基层一直堆到塔尖就返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * 输出：true
 * 解析：
 * 可以堆砌成这样的金字塔:
 * A
 * / \
 * G   E
 * / \ / \
 * B   C   D
 * <p>
 * 因为符合('B', 'C', 'G'), ('C', 'D', 'E') 和 ('G', 'E', 'A') 三种规则。
 * <p>
 * 示例 2：
 * <p>
 * 输入：bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * 输出：false
 * 解析：
 * 无法一直堆到塔尖。
 * 注意, 允许存在像 (A, B, C) 和 (A, B, D) 这样的三元组，其中 C != D。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-10-29 11:10
 **/
public class PyramidTransitionMatrix {
    //* bottom 的长度范围在 [2, 8]。
    //          * allowed 的长度范围在[0, 200]。
    //          * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。

    private int[][][] allows;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        allows = new int[7][7][7];
        //使用
        for (String allow : allowed) {
            allows[allow.charAt(0) - 'A'][allow.charAt(1) - 'A'][allow.charAt(2) - 'A'] = 1;
        }
        int l = bottom.length();
        int[][] main = new int[l][l];
        for (int i = 0; i < l; i++) {
            main[l - 1][i] = bottom.charAt(i) - 'A';
        }
        return checkMain(main, l - 2, 0);
    }

    //回溯
    public boolean checkMain(int[][] A, int i, int j) {
        if (i < 0) {
            return true;
        }
        //处理第i,j个节点
        int[] allow = allows[A[i + 1][j]][A[i + 1][j + 1]];
        int nexti = i;
        int nextj = j + 1;
        if (nextj > i) {
            nexti = i - 1;
            nextj = 0;
        }
        for (int k = 0; k < 7; k++) {
            if (allow[k] == 1) {
                A[i][j] = k;
                if (checkMain(A, nexti, nextj)) {
                    return true;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix pyramidTransitionMatrix = new PyramidTransitionMatrix();
        String bottom = "AABA";
        List<String> alloweds = Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC");
        System.out.println(pyramidTransitionMatrix.pyramidTransition(bottom, alloweds));
    }

}
