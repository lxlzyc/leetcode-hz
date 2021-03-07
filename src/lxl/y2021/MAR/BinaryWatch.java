package lxl.y2021.MAR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/6 14:48
 * @Version 1.0
 */
public class BinaryWatch {
    //纯暴力
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                //Integer.bitCount(i)进制中1的个数
                int cnt = Integer.bitCount(i) + Integer.bitCount(j);
                if (cnt == num) {
                    // res.add(String.format("%d:%02d", i, j));
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(':');
                    if (j < 10) {
                        sb.append('0');
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }

    private int[] times = {1, 2, 4, 8, 16, 32};

    List<Integer> mins;
    List<String> res;

    public List<String> readBinaryWatch2(int num) {
        res = new ArrayList<>();
        mins = new ArrayList<>();
        //设分钟使用的亮灯数为x；则 x<=6 && num-x<=4;

        for (int i = 0; i < 6 && num >= i; i++) {
            dfs(0, 0, i, true);
            dfs(0, 0, num - i, false);
            mins.clear();
        }

        return res;
    }

    private void dfs(int st, int sum, int cnt, boolean flag) {
        if (cnt == 0) {
            if (flag) {
                mins.add(sum);
            } else {
                if (!mins.isEmpty()) {
                    for (int m : mins) {
                        // res.add(String.format("%d:%02d", sum, m));
                        StringBuilder sb = new StringBuilder();
                        sb.append(sum).append(':');
                        if (m < 10) {
                            sb.append('0');
                        }
                        sb.append(m);
                        res.add(sb.toString());
                    }
                }
            }
            return;
        }

        for (int i = st; i < (flag ? 6 : 4); i++) {
            int temp = (int) Math.pow(2, i);
            if (flag && sum + temp >= 60 || !flag && sum + temp >= 12) {
                break;
            }
            dfs(i + 1, sum + temp, cnt - 1, flag);
        }
    }
}