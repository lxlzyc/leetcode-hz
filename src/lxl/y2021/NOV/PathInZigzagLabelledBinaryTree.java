package lxl.y2021.NOV;

import lxl.util.JSONUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-11-26 09:52
 **/
public class PathInZigzagLabelledBinaryTree {

    private List<Integer> ans;

    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
        int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
        while (label > 1) {//5.循环直到遇到特殊情况1
            integers.add(label);//3.将label的结果添加到数组中
            //4.计算下一个label的值
            //方法1（公式）
            //label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);
            //公式解析
            //获取对称位置
            //1.最小值
            int min = (int) Math.pow(2, a--);
            //2.下一层最小值 = 当前最小值*2
            //3.计算对称位置
            label = (2 * min - label - 1) + min;
            //4.计算父层
            label = label / 2;
        }
        integers.add(1);//6.添加特殊情况 1
        Collections.reverse(integers); //7.翻转数组
        return integers;//1.返回结果
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree pathInZigzagLabelledBinaryTree = new PathInZigzagLabelledBinaryTree();
        System.out.println(JSONUtil.listToJson(pathInZigzagLabelledBinaryTree.pathInZigZagTree(26)));
    }

}
