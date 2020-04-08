package lxl.APR;

/**
 * @program: leetcode-hz
 * @description: 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-08 09:43
 **/
public class MovingCount {

    private int getNum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    private boolean getNextNum(int i) {
        if (i / 10 == (i + 1) / 10) {
            return true;
        }
        return false;
    }

    private int maxm;
    private int maxn;
    private int maxk;

    private int[][] nums;
    private int sum = 0;

    public int movingCount(int m, int n, int k) {
        nums = new int[m][n];
        maxm = m;
        maxn = n;
        maxk = k;
        this.checkAt(0, 0, 0, 0);
        return sum;
    }


    private void checkAt(int i, int inum, int j, int jnum) {
        if (nums[i][j] == 1) {
            return;
        }
        nums[i][j] = 1;
        sum++;
        if (i + 1 < maxm) {
            int helpinum = this.tryAdd(i, inum);
            if (helpinum + jnum <= maxk) {
                this.checkAt(i + 1, helpinum, j, jnum);
            }
        }
        if (j + 1 < maxn) {
            int helpjnum = this.tryAdd(j, jnum);
            if (helpjnum + inum <= maxk) {
                this.checkAt(i, inum, j + 1, helpjnum);
            }
        }
    }


    private int tryAdd(int i, int inum) {
        if (this.getNextNum(i)) {
            inum++;
        } else {
            inum = this.getNum(i + 1);
        }
        return inum;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int i = 1;
        int num = 1;
        System.out.println(movingCount.movingCount(10, 15, 8));
        //System.out.println(num);
        //movingCount.test();
    }

    //private void test() {
    //    System.out.println(getNum(12));
    //    System.out.println(getNextNum(9));
    //}
}
