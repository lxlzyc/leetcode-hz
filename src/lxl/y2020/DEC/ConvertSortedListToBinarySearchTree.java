package lxl.y2020.DEC;

import lxl.util.ListNode;
import lxl.util.ListNodeTest;
import lxl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description: 109. 有序链表转换二叉搜索树
 * @author: lxl
 * @create: 2019-12-27 13:52
 **/
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> nodes = new ArrayList<>();
        nodes.add(head.val);
        ListNode next = head.next;
        while (next != null ){
            nodes.add(next.val);
            next = next.next;
        }
        int length = nodes.size();
        int mid = length/2;
        TreeNode base = new TreeNode(nodes.get(mid));
        base.left = this.buildTreeNode(nodes,0,mid);
        base.right = this.buildTreeNode(nodes,mid+1,length);
        return base;
    }

    private TreeNode buildTreeNode(List<Integer> nodes, int left, int right) {
        if(left >= right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode base = new TreeNode(nodes.get(mid));
        base.left = this.buildTreeNode(nodes,left,mid);
        base.right = this.buildTreeNode(nodes,mid+1,right);
        return base;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree searchTree = new ConvertSortedListToBinarySearchTree();
        ListNode head = ListNodeTest.getListNode4();
        System.out.println(searchTree.sortedListToBST(head));
    }

}
