package lxl.NOV;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-26 15:43
 **/
public class LongestSubstringWithoutRep {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int maxLength = 0;
        int length = s.length();
        Map<Character,Integer> keys = new HashMap<>((int)(length/0.76));
        char[] chars = s.toCharArray();
        int left = 0;
        int offset = 1;
        keys.put(chars[0],0);
        while (offset < length && (length - offset + keys.size()) > maxLength){
            char index = chars[offset];
            if(!keys.containsKey(index)){
                //直接加，更新最大值
                keys.put(index,offset);
            }else{
                //更新最大长度
                maxLength = Math.max(maxLength,keys.size());
                //找到重复位置
                int sameOffset = keys.get(index);
                //丢弃重复位置及之前的数据 即left-sameOffset之间的数据
                //this.removeKey(keys,chars,left,sameOffset);
                //塞入当前位置
                keys.put(index,offset);
                //更新左边界
                left = sameOffset+1;
            }
            offset ++;
        }
        maxLength = Math.max(maxLength,keys.size());

        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRep longestSubstringWithoutRep = new LongestSubstringWithoutRep();

        System.out.println(longestSubstringWithoutRep.lengthOfLongestSubstring("abcabcbb"));
    }

}
