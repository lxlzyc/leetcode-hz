package lxl.y2020.DEC;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-17 14:01
 **/
public class TextJustTification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = 0;
        List<String> re = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        for (String word : words) {
            if (length + lineWords.size() + word.length() > maxWidth) {
                re.add(this.buildLine(lineWords, length, maxWidth));
                lineWords.clear();
                length = 0;
            }
            lineWords.add(word);
            length += word.length();
        }
        if (!lineWords.isEmpty()) {
            re.add(this.buildLast(lineWords, maxWidth));
        }
        return re;
    }

    private String buildLast(List<String> lineWords, int maxWidth) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String word : lineWords) {
            stringBuffer.append(word).append(' ');
        }
        if (stringBuffer.length() < maxWidth) {
            stringBuffer.append(this.getSpace(maxWidth - stringBuffer.length()));
        } else if (stringBuffer.length() > maxWidth) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        return stringBuffer.toString();
    }

    private String buildLine(List<String> lineWords, int length, int maxWidth) {
        if (lineWords.size() == 1) {
            return lineWords.get(0) + this.getSpace(maxWidth - length);
        }
        int spaceLength = maxWidth - length;
        int spaceCount = lineWords.size() - 1;
        int step = spaceLength / spaceCount;
        int other = spaceLength % spaceCount;
        StringBuffer stringBuffer = new StringBuffer();
        String stepSpace;

        for (String word : lineWords) {
            if (other > 0) {
                stepSpace = this.getSpace(step + 1);
                other--;
            } else {
                stepSpace = this.getSpace(step);
            }
            stringBuffer.append(word).append(stepSpace);
        }
        stringBuffer.delete(stringBuffer.length() - step, stringBuffer.length());

        return stringBuffer.toString();
    }

    private String getSpace(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < i; j++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        String[] strs = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        TextJustTification textJustTification = new TextJustTification();
        System.out.println(JSONUtil.toJson(textJustTification.fullJustify(strs, 16)));
        //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
        //["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
        //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
    }

}
