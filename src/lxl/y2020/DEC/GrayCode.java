package lxl.y2020.DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 14:56
 **/
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0);
        //初始化 n = 0 的解
        for (int i = 0; i < n; i++) {
            //要加的数
            int add = 1 << i;
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    public static void main(String[] args) {

    }
}
