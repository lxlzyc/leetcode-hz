package lxl.DEC;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBE CODEB ANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 18:02
 **/
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int maxLength = s.length();
        if(maxLength<t.length()){
            return "";
        }
        if(t.length()<=0){
            return "";
        }
        if(s.contains(t)){
            return t;
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char tchar : t.toCharArray()) {
            int charCount = tmap.getOrDefault(tchar, 0);
            tmap.put(tchar, charCount+1);

        }
        int tmapSize = tmap.size();
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int length = chars.length;
        char index;
        int lastLeft=-1;
        int lastRight=-1;
        while (right < length) {
            index = chars[right];
            if(right == 11){
                System.out.println(right);
            }
            if (tmap.containsKey(index)) {
                int charCount = map.getOrDefault(chars[right], 0);
                map.put(index, charCount+1);
                if (map.size() == tmapSize && this.checkMapSame(map, tmap)) {
                    System.out.println(left+"-"+right+"-"+s.substring(left,right+1));
                    if(right-left+1 <=maxLength){
                        lastLeft = left;
                        lastRight = right;
                        maxLength = lastRight-lastLeft+1;
                    }
                    while (map.size() == tmapSize && left <= right){
                        index = chars[left];
                        System.out.println("index == "+index);
                        if(this.tryRemoveKey(map,tmap,index)){
                            left ++;
                            if(right-left+1 <=maxLength){
                                lastLeft = left;
                                lastRight = right;
                                maxLength = lastRight-lastLeft+1;
                            }
                        }else{
                            right++;
                            break;
                        }
                    }

                }else{
                    right++;
                }
            }else{
                right++;
            }
        }
        System.out.println(lastLeft+"|"+lastRight);
        return lastLeft>=0?s.substring(lastLeft,lastRight+1):"";
    }

    private boolean checkMapSame(Map<Character, Integer> map, Map<Character, Integer> tmap) {

        boolean re = true;
        for (char key : map.keySet()) {
            if (map.get(key) < tmap.get(key)) {
                return false;
            }
        }
        return re;
    }

    private boolean tryRemoveKey(Map<Character, Integer> map, Map<Character, Integer> tmap, char key) {
        if(!map.containsKey(key)){
            return true;
        }
        boolean re = true;
        int count = map.get(key);
        if (count-1 < tmap.get(key)) {
            return false;
        }else{
            if(count == 1){
                map.remove(key);
            }else{
                map.put(key,count-1);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae"));

    }
}
