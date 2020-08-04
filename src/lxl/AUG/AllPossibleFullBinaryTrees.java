package lxl.AUG;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],
 * [0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-04 14:30
 **/
public class AllPossibleFullBinaryTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //令 FBT(N)\text{FBT}(N)FBT(N) 作为所有含 NNN 个结点的可能的满二叉树的列表。
    //
    //每个满二叉树 TTT 含有 3 个或更多结点，在其根结点处有 2 个子结点。这些子结点 left 和 right 本身就是满二叉树。
    //
    //因此，对于 N≥3N \geq 3N≥3，我们可以设定如下的递归策略：FBT(N)=\text{FBT}(N) =FBT(N)= [对于所有的 xxx，
    //所有的树的左子结点来自 FBT(x)\text{FBT}(x)FBT(x) 而右子结点来自 FBT(N−1−x)\text{FBT}(N-1-x)FBT(N−1−x)]。
    //
    //此外，通过简单的计数参数，没有满二叉树具有正偶数个结点。
    //
    //最后，我们应该缓存函数 FBT\text{FBT}FBT 之前的结果，这样我们就不必在递归中重新计算它们。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/suo-you-ke-neng-de-man-er-cha-shu-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    private List<TreeNode>[] nodes;

    public List<TreeNode> allPossibleFBT(int N) {
        nodes = new List[N + 1];
        return this.doFBT(N);
    }

    private List<TreeNode> doFBT(int N) {
        if (nodes[N] == null) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : doFBT(x)) {
                        for (TreeNode right : doFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            nodes[N] = ans;
        }
        return nodes[N];
    }

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees allPossibleFullBinaryTrees = new AllPossibleFullBinaryTrees();
        System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(7));
    }


}
