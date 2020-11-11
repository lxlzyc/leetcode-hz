package lxl.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-23 16:01
 **/
public class RestoreIpAddresses {
    private int max = 255;

    //Char("50") 2
    //Char("53") 5
    public List<String> restoreIpAddresses(String s) {
        return this.restoreIpAddresses(s, 0, s.length(), 0);
    }

    public List<String> restoreIpAddresses(String s, int begin, int length, int count) {
        if (length - begin > (4 - count) * 3 || length - begin < (4 - count)) {
            return null;
        }
        List<String> re = new ArrayList<>();

        if (count == 3) {
            String last = s.substring(begin);
            if (last.startsWith("00") || Integer.valueOf(last) > 255) {
                return null;
            }
            re.add(last);
            return re;
        } else {
            char char1 = s.charAt(begin);
            List<String> char1Next = this.restoreIpAddresses(s, begin + 1, length, count + 1);
            if (char1Next != null && char1Next.size() > 0) {
                for (String index : char1Next) {
                    re.add(char1 + "." + index);
                }
            }
            char char2 = s.charAt(begin + 1);
            if (char1 != '0') {
                List<String> char2Next = this.restoreIpAddresses(s, begin + 2, length, count + 1);
                if (char2Next != null && char2Next.size() > 0) {
                    for (String index : char2Next) {
                        re.add(s.substring(begin, begin + 2) + "." + index);
                    }
                }
                //if(begin+3<length ){
                char char3 = s.charAt(begin + 2);
                String char3String = s.substring(begin, begin + 3);
                if (Integer.valueOf(char3String) <= 255) {
                    List<String> char3Next = this.restoreIpAddresses(s, begin + 2, length, count + 1);
                    if (char3Next != null && char3Next.size() > 0) {
                        for (String index : char3Next) {
                            re.add(char3String + "." + index);
                        }
                    }
                }

                //}

            }
        }
        return re;


    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }
}
