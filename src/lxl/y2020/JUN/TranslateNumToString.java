package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-09 10:47
 **/
public class TranslateNumToString {
    //动态规划
    //首先我们来通过一个例子理解一下这里「翻译」的过程：我们来尝试翻译「140214021402」。
    //
    //分成两种情况：
    //
    //首先我们可以把每一位单独翻译，即 [1,4,0,2][1, 4, 0, 2][1,4,0,2]，翻译的结果是 beac
    //然后我们考虑组合某些连续的两位：
    //        [14,0,2][14, 0, 2][14,0,2]，翻译的结果是 oac。
    //        [1,40,2][1, 40, 2][1,40,2]，这种情况是不合法的，因为 404040 不能翻译成任何字母。
    //        [1,4,02][1, 4, 02][1,4,02]，这种情况也是不合法的，含有前导零的两位数不在题目规定的翻译规则中，那么 [14,02][14, 02][14,02] 显然也是不合法的。
    //
    //那么我们可以归纳出翻译的规则，字符串的第 iii 位置：
    //
    //可以单独作为一位来翻译
    //如果第 i−1i - 1i−1 位和第 iii 位组成的数字在 101010 到 252525 之间，可以把这两位连起来翻译
    //
    //到这里，我们发现它和「198. 打家劫舍」非常相似。我们可以用 f(i)f(i)f(i) 表示以第 iii 位结尾的前缀串翻译的方案数，考虑第 iii 位单独翻译和与前一位连接起来再翻译对 f(i)f(i)f(i) 的贡献。单独翻译对 f(i)f(i)f(i) 的贡献为 f(i−1)f(i - 1)f(i−1)；如果第 i−1i - 1i−1 位存在，并且第 i−1i - 1i−1 位和第 iii 位形成的数字 xxx 满足 10≤x≤2510 \leq x \leq 2510≤x≤25，那么就可以把第 i−1i - 1i−1 位和第 iii 位连起来一起翻译，对 f(i)f(i)f(i) 的贡献为 f(i−2)f(i - 2)f(i−2)，否则为 0。我们可以列出这样的动态规划转移方程：
    //
    //f(i)=f(i−1)+f(i−2)[i−1≥0,10≤x≤25]f(i) = f(i - 1) + f(i - 2)[i - 1 \geq 0, 10 \leq x \leq 25] f(i)=f(i−1)+f(i−2)[i−1≥0,10≤x≤25]
    //
    //边界条件是 f(−1)=0f(-1) = 0f(−1)=0，f(0)=1f(0) = 1f(0)=1。方程中 [c][c][c] 的意思是 ccc 为真的时候 [c]=1[c] = 1[c]=1，否则 [c]=0[c] = 0[c]=0。
    //
    //有了这个方程我们不难给出一个时间复杂度为 O(n)O(n)O(n)，空间复杂度为 O(n)O(n)O(n) 的实现。考虑优化空间复杂度：这里的 f(i)f(i)f(i) 只和它的前两项 f(i−1)f(i - 1)f(i−1) 和 f(i−2)f(i - 2)f(i−2) 相关，我们可以运用「滚动数组」思想把 fff 数组压缩成三个变量，这样空间复杂度就变成了 O(1)O(1)O(1)。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-by-leetcode-sol/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int translateNum(int num) {
        String numString = String.valueOf(num);
        //滚动数组 0，1，2位
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0, l = numString.length(); i < l; i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i > 0) {
                String pre = numString.substring(i - 1, i + 1);
                if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                    r += p;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        TranslateNumToString translateNumToString = new TranslateNumToString();
        System.out.println(translateNumToString.translateNum(12258));
    }
}
