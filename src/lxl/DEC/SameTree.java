package lxl.DEC;

import lxl.util.TreeNode;

/**
 * @program: leetcode-hz
 * @description: 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-24 16:39
 **/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p!=null&& q!=null){
            if(p.val == q.val){
                if(this.isSameTree(p.left,q.left)){
                    if(this.isSameTree(p.right,q.right)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
