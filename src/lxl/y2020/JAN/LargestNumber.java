package lxl.y2020.JAN;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode-hz
 * @description: 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * <p>
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-08 15:48
 **/
public class LargestNumber {

    public String largestNumber(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return "";
        }
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!o1.equals(o2)) {
                    if ("0".equals(o1)) {
                        return 1;
                    } else if ("0".equals(o2)) {
                        return -1;
                    }
                    return Long.compare(Long.valueOf(o2 + o1), Long.valueOf(o1 + o2));
                }
                return 0;
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String index : strings) {
            stringBuffer.append(index);
        }
        String re = stringBuffer.toString();
        if (re.startsWith("0")) {
            return "0";
        }
        return re;
    }

    //public String largestNumber(int[] nums) {
    //    int length = nums.length;
    //    if(length <=0){
    //        return "";
    //    }
    //    String[] strings = new String[length];
    //    for (int i = 0; i < length; i++) {
    //        strings[i] =  String.valueOf(nums[i]);
    //    }
    //    Arrays.sort(strings, new Comparator<String>() {
    //        @Override
    //        public int compare(String o1, String o2) {
    //            if(!o1.equals(o2)){
    //                if("0".equals(o1)){
    //                    return 1;
    //                }else if("0".equals(o2)){
    //                    return -1;
    //                }
    //                //return Long.compare(Long.valueOf(o2+o1),Long.valueOf(o1+o2));
    //                String o1temp;
    //                String o2temp;
    //                boolean change = false;
    //                if(o1.length()<o2.length()){
    //                    o1temp = o2;
    //                    o2temp = o1;
    //                    change = true;
    //                }else{
    //                    o1temp = o1;
    //                    o2temp = o2;
    //                }
    //                char[] chars1 = o1temp.toCharArray();
    //                char[] chars2 = o2temp.toCharArray();
    //                int compageRe = 0;
    //                for (int i = 0,j=0,l=chars1.length,l2=chars2.length; i < l; i++,j++) {
    //                    if(j>=l2){
    //                        j = j-l2;
    //                    }
    //                    if(chars1[i]>chars2[j]){
    //                        compageRe = -1;
    //                        break;
    //                    }else if(chars1[i]<chars2[j]){
    //                        compageRe = 1;
    //                        break;
    //                    }
    //                }
    //                return change?0-compageRe:compageRe;
    //            }
    //            return 0;
    //        }
    //    });
    //    StringBuffer stringBuffer = new StringBuffer();
    //    for(String index:strings){
    //        stringBuffer.append(index);
    //    }
    //    String re= stringBuffer.toString();
    //    if(re.startsWith("0")){
    //        return "0";
    //    }
    //    return re;
    //}

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {20, 1};
        System.out.println(largestNumber.largestNumber(nums));
        //String num1 = "100100123";
        //String num2 = "4";
        //System.out.println(largestNumber.compare(num1,num2));
        //
        //String num3 = "3";
        //String num4 = "4";
        //System.out.println(largestNumber.compare(num3,num4));

    }

}
