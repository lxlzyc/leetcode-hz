package lxl.y2021.MAR;

import lxl.util.TreeNode;

import java.util.Stack;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/18 9:40
 * @Version 1.0
 */
public class KthLargest {

    //中序遍历 循环获取---逆向中序遍历
    public int kthLargest(TreeNode root, int k) {
        //用一个栈来存放树中的节点
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {//只要当前节点不为空(即当前节点的左右子树没有访问完毕)或者栈中还有节点(还有节点没有访问)
            while (root != null) {
                stack.push(root);//根节点入栈
                root = root.right;//访问右子树
            }
            root = stack.pop();//取出右子树的根节点
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.left;//访问左子树
        }
        return 0;
    }
}