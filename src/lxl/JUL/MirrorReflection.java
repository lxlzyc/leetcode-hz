package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 858. 镜面反射
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 * <p>
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * <p>
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入： p = 2, q = 1
 * 输出： 2
 * 解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= p <= 1000
 * 0 <= q <= p
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mirror-reflection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-24 16:15
 **/
public class MirrorReflection {
    //2     1
    //
    //
    //      0
    //假设上边镜面不存在 每次经过上面镜面则上下位置镜像翻转一次。
    //
    //kp = mq 时 则终止了 ，翻了奇数次 左右偶数次 则是2号，翻了奇数次 左右奇数次 则是0号。则有：
    //
    //作者：ling-1
    //链接：https://leetcode-cn.com/problems/mirror-reflection/solution/jing-mian-fan-she-ji-bai-100yong-hu-by-ling-1/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int mirrorReflection(int p, int q) {
        int k = 1, m = p * k / q;
        while (p * k % q != 0) {
            k++;
            m = p * k / q;
        }

        //翻了奇数次 左右偶数次 则是2号
        if (k % 2 == 1 && m % 2 == 0) {
            return 2;
        }
        //翻了奇数次 左右奇数次 则是0号
        if (k % 2 == 1 && m % 2 == 1) {
            return 1;
        }
        return 0;

    }
}
