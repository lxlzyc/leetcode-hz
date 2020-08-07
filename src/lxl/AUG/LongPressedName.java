package lxl.AUG;

/**
 * @program: leetcode-hz
 * @description: 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * <p>
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * <p>
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-07 13:55
 **/
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int namel = name.length();
        int typedl = typed.length();
        if (typedl < namel) {
            return false;
        }

        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int typedLeft = 0;
        for (int i = 0; i < namel; i++) {
            if (typedLeft >= typedl) {
                return false;
            }
            if (typedChars[typedLeft] == nameChars[i]) {
                typedLeft++;
                continue;
            } else {
                if (i > 0) {
                    while (typedLeft < typedl && typedChars[typedLeft] == nameChars[i - 1]) {
                        typedLeft++;
                    }
                    if (typedLeft < typedl && typedChars[typedLeft] == nameChars[i]) {
                        typedLeft++;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        }
        while (typedLeft < typedl - 1) {
            if (typedChars[typedLeft + 1] != typedChars[typedLeft]) {
                return false;
            }
            typedLeft++;
        }
        return true;
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex",
                "alexxr"
        ));
    }

}
