package lxl.work2;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-13 10:58
 **/
public class NumSpecial {
    private int m;
    private int n;

    public int numSpecial(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (this.check(mat, i, j)) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(int[][] mat, int i, int j) {
        int count = 0;
        for (int k = 0; k < n; k++) {
            if (mat[i][k] == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        for (int k = 0; k < m; k++) {
            if (mat[k][j] == 1) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }


}
