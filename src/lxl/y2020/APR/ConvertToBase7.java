package lxl.y2020.APR;

/**
 * @program: leetcode-hz
 * @description: 504. 七进制数
 * @author: lxl
 * @create: 2020-04-10 16:17
 **/
public class ConvertToBase7 {

    public String convertToBase7(int num) {

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = 0 - num;
        }
        while (true) {

            if (num < 7) {
                stringBuilder.append(num);
                break;
            }
            stringBuilder.append(num % 7);
            num = num / 7;
        }
        return (flag ? "" : "-") + stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToBase7 convertToBase7 = new ConvertToBase7();
        System.out.println(convertToBase7.convertToBase7(-7));
    }
}
