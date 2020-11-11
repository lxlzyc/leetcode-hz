package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 478. 在圆内随机生成点
 * 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 * <p>
 * 说明:
 * <p>
 * 输入值和输出值都将是浮点数。
 * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 * 圆周上的点也认为是在圆中。
 * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * 输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * 输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-random-point-in-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-04-03 14:32
 **/
public class GenerateRandomPointInACircle {

    private double radius;
    private double x_center;
    private double y_center;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;

    }
    // 1. 随机生成距离圆心长度
    // 2. 随机生成 角度
    // 3.根据长度和角度 返回 x | y

    //一开始的想法，我们在[0, radius]中等概率取r，在[0, 2π)中等概率取angle即可实现圆内的随机分布。
    //
    //事实上，这是不对的。
    //
    //在[0, 2π)中等概率取angle，相对于把一个圆分成了无数个扇形，点落在每个扇形上的概率均相等。
    //
    //假设某个扇形的圆心角是theta，那么该扇形的面积是0.5 * theta * radius ^ 2，分布在该扇形区域上的概率是theta / 2π，
    // 只要每个扇形的圆心角相等，扇形面积就是相等的，点在扇形中也是等概率的。
    //
    //在[0, radius]中等概率取r，相当于把一个圆分成了无数个环形，点落在每个环形上的概率均相等。
    //
    //假设某个环形的内径是r1，外径是r2，那么该环形的面积是π * (r2 ^ 2 - r1 ^ 2)。可见每个环形的面积是不一样的，
    // 显然每个环形上的点密度是不一样的。这样做会造成靠近圆心的点分布比较密集，远离圆心的点分布比较稀疏。
    //
    //那么，如何取r使得点落在圆内任意区域的概率均相等呢？
    // 这样做显然会使得落在每个环形上的概率均不同，且环形面积较大的概率高，环形面积较小的概率小。
    //
    //根据环形面积的计算公式：π * (r2 ^ 2 - r1 ^ 2)，落在该环形面积上的概率应为(r2 ^ 2 - r1 ^ 2) / (radius ^ 2)。
    //在[0, radius]中如何分布概率密度函数f(x)，可以使得f(x)其在[r1, r2]上的积分值为(r2 ^ 2 - r1 ^ 2) / (radius ^ 2)呢？
    //
    //取f(x) = 2x / (radius ^ 2)可以满足上述条件，即半径r在[0, radius]上的概率密度函数应为f(x) = 2x / (radius ^ 2)，
    // 故只需要在[0, radius ^ 2]范围内等概率取r ^ 2，再开根号即得r值。（求一下导数即可，x ^ 2的导数是2x）

    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x_center, d * Math.sin(theta) + y_center};
    }

}
