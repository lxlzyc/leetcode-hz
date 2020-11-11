package lxl.WeeklyContest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-10-18 10:28
 **/
public class Test3 {

    class Person {
        int score;
        int age;

        public Person(int score, int age) {
            this.score = score;
            this.age = age;
        }

        @Override
        public String toString() {
            return age + "-" + score;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int l = scores.length;

        Person[] peoples = new Person[l];
        for (int i = 0; i < l; i++) {
            peoples[i] = new Person(scores[i], ages[i]);
        }

        Arrays.sort(peoples, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int compare = Integer.compare(o1.age, o2.age);
                if (compare == 0) {
                    compare = Integer.compare(o1.score, o2.score);
                }
                return compare;
            }
        });
        //System.out.println(Arrays.toString(peoples));

        int[] dp = new int[l];
        dp[0] = peoples[0].score;
        int max = dp[0];
        for (int i = 1; i < l; i++) {
            Person indexPerson = peoples[i];
            int indexscore = indexPerson.score;
            int indexmax = 0;
            int j = i - 1;
            while (j >= 0) {
                if (peoples[j].score <= indexscore) {
                    indexmax = Math.max(indexmax, dp[j]);
                }
                j--;
            }
            dp[i] = indexmax + indexscore;
            max = Math.max(max, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
//        [9,2,8,8,2]
//[4,1,3,3,5]
//        [4,5,6,5]
//[2,1,2,1]
        int[] s = {9, 2, 8, 8, 2};
        int[] a = {4, 1, 3, 3, 5};
        System.out.println(test3.bestTeamScore(s, a));
    }

}
