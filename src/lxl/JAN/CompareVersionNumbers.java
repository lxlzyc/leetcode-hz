package lxl.JAN;

/**
 * @program: leetcode-hz
 * @description: 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 * . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-07 15:13
 **/
public class CompareVersionNumbers {


    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        String[] help = null;
        boolean change = false;
        if (split2.length > split1.length) {
            help = split1;
            split1 = split2;
            split2 = help;
            change = true;
        }
        int compare = 0;
        for (int i = 0, l = split1.length, k = split2.length; i < l; i++) {
            if (i >= k) {
                compare = this.compareNum(split1[i], "0");
            } else {
                compare = this.compareNum(split1[i], split2[i]);
            }
            if (compare != 0) {
                break;
            }
        }
        return change ? 0 - compare : compare;
    }

    public int compareNum(String num1, String num2) {
        return Integer.compare(Integer.valueOf(num1), Integer.valueOf(num2));
    }

    public static void main(String[] args) {
        CompareVersionNumbers com = new CompareVersionNumbers();
        System.out.println(com.compareVersion("1", "1.1"));
    }
}
