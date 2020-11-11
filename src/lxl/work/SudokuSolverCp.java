package lxl.work;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 空白格用 '.' 表示。
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-06 10:17
 **/
public class SudokuSolverCp {

    private Set<Character> help = new HashSet<>(9);
    private Set<Character> help2 = new HashSet<>(9);

    public void solveSudoku(char[][] board) {
        //存储待填充位置，及位置可填充的数据
        LinkedHashMap<Integer, HashSet<Integer>> boardLimit = new LinkedHashMap<>();
        //存储待填充位置，有几个可填充的数量，按照可填充数量从1往后遍历
        ArrayList<ArrayList<Integer>> needFillLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            needFillLists.add(new ArrayList<Integer>());
        }
        boardLimit = this.initBoardLimit(board, needFillLists);

        if (boardLimit.size() <= 0) {
            return;
        }
        if (needFillLists.get(1).size() > 0) {
            ArrayList<Integer> onlyOneFillList = needFillLists.get(1);
            if (onlyOneFillList.size() > 0) {
                for (Integer integer : onlyOneFillList) {
                    for (int i = 1; i <= 9; i++) {
                        if (!boardLimit.get(integer).contains(i)) {
                            board[integer / 10][integer % 10] = (char) (i + '0');
                            break;
                        }
                    }
                }
                this.solveSudoku(board);
                return;
            }

        }
        //记录最优填充顺序，后续按此顺序填充
        List<Integer> needDeal = new ArrayList<>();
        needDeal.add(-1);
        for (int i = 1; i <= 9; i++) {
            ArrayList<Integer> index = needFillLists.get(i);
            if (index.size() > 0) {
                needDeal.addAll(index);
            }
        }
        Collections.sort(needDeal);
        int dealOffset = 1;
        int dealedSize = needDeal.size();
        //记录已填充的值，与needDeal对应，用来回溯
        Stack<Integer> hasDealStack = new Stack<>();


        int index;
        int value;
        int preIndex;
        int preValue;
        List<Integer> addKeys;
        Stack<List<Integer>> addKeysStack = new Stack<>();
        System.out.println("needDeal=" + JSONUtil.toJson(needDeal));
        int count = 0;
        String errormsg = "";
        while (dealOffset < dealedSize) {
            count++;

            //System.out.println("hasDeal="+JSONUtil.toJson(hasDeal));

            //System.out.println("hasDeal="+JSONUtil.toJson(hasDeal));

            index = needDeal.get(dealOffset);
            boolean canFill = false;
            HashSet<Integer> boardLimitValue = boardLimit.get(index);
            //System.out.println("dealOffset="+dealOffset+" index="+index);
            //for (int i = 0; i < 9; i++) {
            //    System.out.println(Arrays.toString(board[i]));
            //
            //}
            System.out.println("填充offset=" + dealOffset + " index=" + index);

            System.out.println("index=" + index + " boardLimitValue=" + JSONUtil.toJson(boardLimitValue));

            value = 0;
            for (int j = 1; j < 10; j++) {
                if (!boardLimitValue.contains(j)) {
                    //尝试填充
                    addKeys = this.tryFill(index / 10, index % 10, j, board, boardLimit);
                    if (addKeys != null) {
                        canFill = true;
                        value = j;
                        addKeysStack.push(addKeys);
                        break;
                    }
                }
            }
            this.printIndex(needDeal, boardLimit);

            if (canFill) {
                System.out.println("填充成功-填充offset=" + " index=" + index + " value=" + value + "--");
                this.printIndex(needDeal, boardLimit);

                hasDealStack.push(value);
                dealOffset++;
            } else {
                //回溯
                //记录错误路径，即上一层值不对 还原本层
                //if(dealOffset == 10 ){
                //    System.out.println("-");
                //}

                errormsg += JSONUtil.toJson(hasDealStack) + "\r\n";

                System.out.println("回溯上层" + JSONUtil.toJson(hasDealStack));
                this.printIndex2(needDeal, boardLimit);

                //移除处理位置

                //回溯上层
                dealOffset--;
                preIndex = needDeal.get(dealOffset);
                if (preIndex < 0) {
                    this.printIndex2(needDeal, boardLimit);
                    System.out.println(errormsg);
                    break;
                }
                preValue = hasDealStack.pop();
                if (preValue == 5) {
                    System.out.println("ss");
                }
                addKeys = addKeysStack.pop();
                System.out.println("addkeys=" + JSONUtil.toJson(addKeys));

                board[preIndex / 10][preIndex % 10] = '.';

                //System.out.println("remove end boardLimitValue="+JSONUtil.toJson(boardLimitValue));

                //System.out.println("设置回="+ board[preIndex/10][preIndex%10]+"--- "+ preIndex/10+"-"+preIndex%10);

                this.removeFillNotNums(board, boardLimit, addKeys, preValue);
                //System.out.println("移除完填充的key");

                //重置当前节点
                boardLimitValue = this.addKeys(board, index / 10, index % 10);
                boardLimit.put(index, boardLimitValue);
                //System.out.println("删除完不可能的地址"+index+"=not=");
                this.printIndex(needDeal, boardLimit);

                HashSet<Integer> set2 = boardLimit.get(preIndex);
                set2.add(preValue);
                boardLimit.put(preIndex, set2);
                //System.out.println("添加完不可能的地址"+preIndex );
                this.printIndex(needDeal, boardLimit);

            }

            //System.out.println("hasDealAddKeys="+JSONUtil.toJson(hasDealAddKeys));
            System.out.println("");
            //System.out.println("");
            //System.out.println("");
            //System.out.println("");

        }


    }

    private void printIndex2(List<Integer> needDeal, LinkedHashMap<Integer, HashSet<Integer>> boardLimit) {
        System.out.println("----------------------");
        for (int i = 1; i < 8; i++) {
            System.out.println(boardLimit.get(needDeal.get(i)));
        }
        System.out.println("----------------------");
    }

    private void printIndex(List<Integer> needDeal, LinkedHashMap<Integer, HashSet<Integer>> boardLimit) {
        //System.out.println("----------------------");
        //for (int i = 1; i < 8; i++) {
        //    System.out.println(boardLimit.get(needDeal.get(i)));
        //}
        System.out.println("----------------------");
    }

    private List<Integer> tryFill(int offseti, int offsetj, int value, char[][] board, LinkedHashMap<Integer, HashSet<Integer>> boardLimit) {
        board[offseti][offsetj] = (char) (value + '0');
        boolean bool = this.isValidSudoku(board, offseti, offsetj);
        List<Integer> addKeys = new ArrayList<>();
        if (bool) {
            //boardLimit 填充其他不可能的值
            int status;
            for (int i = 0; i < 9; i++) {
                if (i != offsetj) {


                    status = this.fillNotNums(board, boardLimit, offseti * 10 + i, value);

                    if (status == 1) {
                        addKeys.add(offseti * 10 + i);
                    } else if (status == -1) {
                        bool = false;
                        //System.out.println("error====="+(offseti*10+i)+"|"+value);
                        //
                        //System.out.println("error====="+JSONUtil.toJson(boardLimit));
                        break;
                    }

                }
                if (i != offseti) {
                    status = this.fillNotNums(board, boardLimit, offsetj + i * 10, value);
                    if (status == 1) {
                        addKeys.add(offsetj + i * 10);
                    } else if (status == -1) {
                        bool = false;
                        //System.out.println("error====="+(offsetj+i*10)+"|"+value);
                        //
                        //System.out.println("error====="+JSONUtil.toJson(boardLimit));
                        break;
                    }

                }
            }

            int i = (offseti / 3) * 3;
            int j = (offsetj / 3) * 3;

            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (!help.contains(board[i + k][j + l]) || board[i + k][j + l] == '.') {
                        help.add(board[i + k][j + l]);
                    }
                    if (i + k != offseti && j + l != offsetj) {
                        status = this.fillNotNums(board, boardLimit, (i + k), value);
                        if (status == 1) {
                            addKeys.add(offsetj + i * 10);
                        } else if (status == -1) {
                            bool = false;
                            break;
                        }
                    }

                }
            }


            if (bool) {
                HashSet<Integer> set = boardLimit.get(offseti * 10 + offsetj);
                set.add(value);
                boardLimit.put(offseti * 10 + offsetj, set);
            } else {
                board[offseti][offsetj] = '.';
                this.removeFillNotNums(board, boardLimit, addKeys, value);
            }
        } else {
            board[offseti][offsetj] = '.';
        }
        return bool ? addKeys : null;
    }

    private void removeFillNotNums(char[][] board, LinkedHashMap<Integer, HashSet<Integer>> boardLimit, List<Integer> addKeys, int value) {
        for (Integer key : addKeys) {
            if (boardLimit.containsKey(key)) {
                HashSet<Integer> set2 = boardLimit.get(key);
                set2.remove(value);
                //HashSet<Integer> integers = this.addKeys(board, key / 10, key % 10);

                boardLimit.put(key, set2);
            }
        }
    }

    // 0 无需填充 1填充成功 -1填充失败
    private int fillNotNums(char[][] board, LinkedHashMap<Integer, HashSet<Integer>> boardLimit, int key, int value) {
        if (!boardLimit.containsKey(key)) {
            return 0;
        }
        HashSet<Integer> set2 = boardLimit.get(key);

        if (set2.contains(value)) {
            return 0;
        } else {
            set2.add(value);
            if (set2.size() == 8) {
                if (board[key / 10][key % 10] != '.') {
                    for (int i = 1; i <= 9; i++) {
                        if (!set2.contains(i)) {

                            board[key / 10][key % 10] = (char) (i + '0');
                            boolean bool = this.isValidSudoku(board, key / 10, key % 10);
                            board[key / 10][key % 10] = '.';
                            if (!bool) {
                                return -1;
                            } else {
                                return 0;
                            }

                        }
                    }
                }

            }
            boardLimit.put(key, set2);

            return 1;

        }
    }

    private LinkedHashMap<Integer, HashSet<Integer>> initBoardLimit(char[][] board, ArrayList<ArrayList<Integer>> needFillLists) {
        LinkedHashMap<Integer, HashSet<Integer>> boardLimit = new LinkedHashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boardLimit.put(i * 10 + j, new HashSet<Integer>());
                }
            }
        }
        for (Integer integer : boardLimit.keySet()) {
            HashSet<Integer> integers = this.addKeys(board, integer / 10, integer % 10);
            int listOffset = 9 - integers.size();
            ArrayList<Integer> list = needFillLists.get(listOffset);
            list.add(integer);
            needFillLists.set(listOffset, list);
            System.out.println(integer + "=no=" + JSONUtil.toJson(integers));
            boardLimit.put(integer, integers);
        }
        return boardLimit;
    }

    public HashSet<Integer> addKeys(char[][] board, int offsetI, int offSetj) {
        HashSet<Integer> set = new HashSet<>(12);
        //行 //竖
        for (int t = 0; t < 9; t++) {
            if (board[offsetI][t] != '.') {
                set.add((int) board[offsetI][t] - 48);
            }
            if (board[t][offSetj] != '.') {
                set.add((int) board[t][offSetj] - 48);
            }
        }
        int i = (offsetI / 3) * 3;
        int j = (offSetj / 3) * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[i + k][j + l] != '.') {
                    set.add((int) board[i + k][j + l] - 48);
                }
            }
        }

        return set;
    }

    private boolean isValidSudoku(char[][] board, int offsetI, int offSetj) {
        //三种检测

        //行 //竖
        for (int i = 0; i < 9; i++) {
            if (!help.contains(board[i][offSetj]) || board[i][offSetj] == '.') {
                help.add(board[i][offSetj]);
            } else {
                return false;
            }
            if (!help2.contains(board[offsetI][i]) || board[offsetI][i] == '.') {
                help2.add(board[offsetI][i]);
            } else {
                return false;
            }
            help.clear();
            help2.clear();
        }
        int i = (offsetI / 3) * 3;
        int j = (offSetj / 3) * 3;


        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (!help.contains(board[i + k][j + l]) || board[i + k][j + l] == '.') {
                    help.add(board[i + k][j + l]);
                } else {
                    return false;
                }
            }
        }
        help.clear();
        return true;
    }


    public static void main(String[] args) {

        SudokuSolverCp sudokuSolver = new SudokuSolverCp();
        char[][] borad = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '6', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'3', '.', '7', '9', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                {'.', '.', '.', '8', '6', '3', '.', '2', '.'},
                {'.', '.', '.', '4', '9', '1', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        sudokuSolver.solveSudoku(borad);
        //for (int i = 0; i < 9; i++) {
        //    System.out.println(Arrays.toString(borad[i]));
        //
        //}
        //System.out.println("--------------------------------------------");

        System.out.println(borad);
    }
}
