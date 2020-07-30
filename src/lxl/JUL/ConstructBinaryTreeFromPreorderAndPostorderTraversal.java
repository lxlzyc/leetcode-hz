package lxl.JUL;

/**
 * @program: leetcode-hz
 * @description: 889. 根据前序和后序遍历构造二叉树
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 1
 * 2   3
 * 4  5  6 7
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-07-30 13:43
 **/
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    //
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //前序 中 左 右
    //后续 左 右 中
    //前序遍历为：
    //
    //        (根结点) (前序遍历左分支) (前序遍历右分支)
    //
    //而后序遍历为：
    //
    //        (后序遍历左分支) (后序遍历右分支) (根结点)
    //
    //例如，如果最终的二叉树可以被序列化的表述为 [1, 2, 3, 4, 5, 6, 7]，那么其前序遍历为 [1] + [2, 4, 5] + [3, 6, 7]，而后序遍历为 [4, 5, 2] + [6, 7, 3] + [1].
    //
    //如果我们知道左分支有多少个结点，我们就可以对这些数组进行分组，并用递归生成树的每个分支。
    //
    //算法
    //
    //我们令左分支有 L 个节点。我们知道左分支的头节点为 pre[1]，但它也出现在左分支的后序表示的最后。所以 pre[1] = post[L-1]（因为结点的值具有唯一性），因此 L = post.indexOf(pre[1]) + 1。
    //
    //现在在我们的递归步骤中，左分支由 pre[1 : L+1] 和 post[0 : L] 重新分支，而右分支将由 pre[L+1 : N] 和 post[L : N-1] 重新分支。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/gen-ju-qian-xu-he-hou-xu-bian-li-gou-zao-er-cha-sh/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    int[] pre, post;

    public TreeNode constructFromPrePost2(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        TreeNode node = make(0, 0, pre.length);
        return node;
    }

    public TreeNode make(int i0, int i1, int N) {
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[i0]);
        if (N == 1) return root;

        int L = 1;
        for (; L < N; ++L)
            if (post[i1 + L - 1] == pre[i0 + 1])
                break;

        root.left = make(i0 + 1, i1, L);
        root.right = make(i0 + L + 1, i1 + L, N - 1 - L);
        return root;
    }


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode node = this.buildTree(pre, post, 0, 0, pre.length);
        return node;
    }

    private TreeNode buildTree(int[] pre, int[] post, int preleft, int postleft, int length) {
        if (length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preleft]);
        if (length == 1) {
            return node;
        }
        int L = 1;
        //获取左节点位置
        for (; L < length; ++L) {
            if (post[postleft + L - 1] == pre[preleft + 1]) {
                break;
            }
        }

        //offset 左边 是 当前节点的子节点
        node.left = this.buildTree(pre, post, preleft + 1, postleft, L);
        node.right = this.buildTree(pre, post, preleft + L + 1, postleft + L, length - 1 - L);
        return node;
    }

    private int getValueOffset(int[] post, int value, int postleft, int postright) {
        for (int i = postleft; i <= postright; i++) {
            if (post[i] == value) {
                return i;
            }
        }
        return postleft;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        ConstructBinaryTreeFromPreorderAndPostorderTraversal con = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        System.out.println(con.constructFromPrePost(pre, post));
        System.out.println(con.constructFromPrePost2(pre, post));
    }

}
