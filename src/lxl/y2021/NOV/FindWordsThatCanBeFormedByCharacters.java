package lxl.y2021.NOV;

/**
 * @program: leetcode-hz
 * @description: 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-30 09:55
 **/
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] charsCount = new int[26];
        for (char c : chars.toCharArray()) {
            charsCount[c - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            if (this.checkWord(word, charsCount)) {
                sum += word.length();
            }
        }
        return sum;
    }

    private boolean checkWord(String word, int[] charsCount) {
        int[] index = new int[26];
        boolean ans = true;
        for (char c : word.toCharArray()) {
            index[c - 'a']++;
            charsCount[c - 'a']--;
            if (charsCount[c - 'a'] < 0) {
                ans = false;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            charsCount[i] += index[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters = new FindWordsThatCanBeFormedByCharacters();
        String[] words = {"hello", "world", "worldy", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(findWordsThatCanBeFormedByCharacters.countCharacters(words, chars));
    }

}
