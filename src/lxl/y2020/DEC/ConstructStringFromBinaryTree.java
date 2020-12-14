package lxl.y2020.DEC;

import lxl.util.TreeNode;
import lxl.util.TreeNodeUtil;

/**
 * @program: leetcode-hz
 * @description: 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-11 11:21
 **/
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        return t.val + (
                t.left == null && t.right == null ? "" : (
                        "(" + tree2str(t.left) + ")" + (t.right == null ? "" : ("(" + tree2str(t.right) + ")"))
                )
        );
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        Integer[] nodes = {1};
        System.out.println(constructStringFromBinaryTree.tree2str(TreeNodeUtil.buildTreeNode(nodes)));
    }

}
