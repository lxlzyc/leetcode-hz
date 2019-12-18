package lxl.DEC;

/**
 * @program: leetcode-hz
 * @description: 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-18 17:11
 **/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int wordLength = word.length();
        if(wordLength == 0 || wordLength>m*n){
            return false;
        }
        char[] words = word.toCharArray();
        char first = words[0];
        int[][] help = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == first){
                    help[i][j] = 1;
                    if(this.checkExist(board,i,j,words,1,help,wordLength,m,n)){
                        return true;
                    }else{
                        help[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkExist(char[][] board, int i, int j, char[] words,int wordsCheckLength,int[][] help,int wordLength,int m,int n) {
        if (wordLength > wordsCheckLength){
            //上
            if(i-1>=0){
                if(board[i-1][j] == words[wordsCheckLength] && help[i-1][j] == 0){
                    help[i-1][j] = 1;
                    if(this.checkExist(board,i-1,j,words,wordsCheckLength+1,help,wordLength,m,n)){
                        return true;
                    }else{
                        help[i-1][j] = 0;
                    }
                }
            }
            //下
            if(i+1<m){
                if(board[i+1][j] == words[wordsCheckLength] && help[i+1][j] == 0){
                    help[i+1][j] = 1;
                    if(this.checkExist(board,i+1,j,words,wordsCheckLength+1,help,wordLength,m,n)){
                        return true;
                    }else{
                        help[i+1][j] = 0;
                    }
                }
            }
            //左
            if(j-1>=0){
                if(board[i][j-1] == words[wordsCheckLength] && help[i][j-1] == 0){
                    help[i][j-1] = 1;
                    if(this.checkExist(board,i,j-1,words,wordsCheckLength+1,help,wordLength,m,n)){
                        return true;
                    }else{
                        help[i][j-1] = 0;
                    }
                }
            }
            //右
            if(j+1<n){
                if(board[i][j+1] == words[wordsCheckLength] && help[i][j+1] == 0){
                    help[i][j+1] = 1;
                    if(this.checkExist(board,i,j+1,words,wordsCheckLength+1,help,wordLength,m,n)){
                        return true;
                    }else{
                        help[i][j+1] = 0;
                    }
                }
            }
            return false;
        }else{
            return true;
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board,"ABCB"));
    }

}
