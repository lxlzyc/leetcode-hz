package lxl.WeeklyContest;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-10-18 10:28
 **/
public class Test1 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int l = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < l; i++) {
            char index = chars[i];
            int r = l - 1;
            while (r > i) {
                if (chars[r] == index) {
                    break;
                }
                r--;
            }
            max = Math.max(max, r - i - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
    }

}
