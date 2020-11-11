package lxl.y2020.DEC;

/**
 * @program: leetcode-hz
 * @description: 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 11:33
 **/
public class AddBinary {

    public String addBinary(String a, String b) {
        if(a.isEmpty()){
            return b;
        }
        if(b.isEmpty()){
            return a;
        }
        int help = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int alength = a.length()-1;
        int blength = b.length()-1;
        char aChar;
        char bChar;
        char sumChar;
        for (int i = 0,l=Math.max(alength,blength); i <= l; i++) {
            aChar = alength-i>=0?a.charAt(alength-i):'0';
            bChar = blength-i>=0?b.charAt(blength-i):'0';
            if(aChar == '1' && bChar == '1'){
                if(help == 0){
                    sumChar = '0';
                    help ++;
                }else{
                    sumChar = '1';
                }
            }else if(aChar == '0' && bChar == '0'){
                if(help>0){
                    sumChar = '1';
                    help --;
                }else{
                    sumChar = '0';
                }
            }else {
                if(help>0){
                    sumChar = '0';
                }else{
                    sumChar = '1';
                }
            }
            stringBuffer.insert(0,sumChar);

        }
        if(help > 0){
            stringBuffer.insert(0,'1');
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1010","1011"));
    }
}
