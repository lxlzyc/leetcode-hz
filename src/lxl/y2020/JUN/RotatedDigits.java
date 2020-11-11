package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方
 * （在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-28 10:05
 **/
public class RotatedDigits {
    //思路
    //
    //遍历从 1 到 N 的每个数字 X，判断 X 是否为好数。
    //
    //如果 X 中存在 3、4、7 这样的无效数字，则 X 不是一个好数。
    //
    //如果 X 中不存在 2、5、6、9 这样的旋转后会变成不同的数字，则 X 不是一个好数。
    //
    //否则，X 可以旋转成一个不同的有效数字。
    //
    //算法
    //
    //判断数字 X 是否为好数，有两种实现方式。最直观的一种方法是把 X 转换成字符串然后解析；另一种方法是递归检查 X 的最后一位数字。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int rotatedDigits(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (this.checkI(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean checkI(int i) {
        String s = String.valueOf(i);
        boolean flag = false;
        for (char index : s.toCharArray()) {
            if (index == '3' || index == '4' || index == '7') {
                return false;
            } else if (index == '2' || index == '5' || index == '6' || index == '9') {
                flag = true;
            }
        }
        return flag;
    }

}
