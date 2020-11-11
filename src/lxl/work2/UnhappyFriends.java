package lxl.work2;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-13 11:07
 **/
public class UnhappyFriends {

    private Map<Integer, Integer> help;

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        help = new HashMap<>();
        for (int i = 0, l = pairs.length; i < l; i++) {
            int close = 1000 - this.getClose(pairs[i][1], preferences[pairs[i][0]]);
            help.put(pairs[i][1], close);
        }
        int ans = 0;
        for (int i = 0, l = pairs.length; i < l; i++) {
            int pair1 = pairs[i][0];
            int pair2 = pairs[i][1];
        }
        return ans;
    }

    private int getClose(int pair1, int[] preference) {
        for (int i = 0, l = preference.length; i < l; i++) {
            if (preference[i] == pair1) {
                return i;
            }
        }
        return 1000;
    }

    public static void main(String[] args) {

    }
}
