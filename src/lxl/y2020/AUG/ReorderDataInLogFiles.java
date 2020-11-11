package lxl.y2020.AUG;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode-hz
 * @description: 937. 重新排列日志文件
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 * <p>
 * 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。
 * <p>
 * 除标识符之外，所有字均由小写字母组成的，称为 字母日志
 * 除标识符之外，所有字均由数字组成的，称为 数字日志
 * <p>
 * 题目所用数据保证每个日志在其标识符后面至少有一个字。
 * <p>
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
 * 数字日志 应该按原来的顺序排列。
 * <p>
 * 返回日志的最终顺序。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 保证有一个标识符，并且标识符后面有一个字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-11 15:14
 **/
public class ReorderDataInLogFiles {

    private static String matche = "[0-9]+";


    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ");
                String[] split2 = o2.split(" ");
                boolean isNum1 = this.isNum(split1[1]);
                boolean isNum2 = this.isNum(split2[1]);
                if (isNum1 && isNum2) {
                    return 0;
                } else if (isNum1) {
                    return 1;
                } else if (isNum2) {
                    return -1;
                } else {
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(o1);
                    stringBuilder1.delete(0, split1[0].length());
                    stringBuilder1.append(split1[0]);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(o2);
                    stringBuilder2.delete(0, split2[0].length());
                    stringBuilder2.append(split2[0]);
                    System.out.println(stringBuilder1 + "-" + stringBuilder2);
                    return stringBuilder1.toString().compareTo(stringBuilder2.toString());
                }
            }

            private boolean isNum(String item) {
                return item.matches(matche);
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] strings = {
                "zo4 4 7",
                "a1 9 2 3 1",
                "g1 act car",
                "ab1 off key dog",
                "a8 act zoo"
        };
        ReorderDataInLogFiles reorderDataInLogFiles = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(reorderDataInLogFiles.reorderLogFiles(strings)));
    }


}
