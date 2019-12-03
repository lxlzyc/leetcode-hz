package lxl.DEC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-12-03 17:11
 **/
public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


        @Override
        public String toString() {
            return val+"-"+ (next == null ? "end":next.toString());
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        lists = this.removeArrayEmptyTextBackNewArray(lists);
        if(lists == null){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode re = new ListNode(0);
        ListNode next = re;
        lists = this.insertSort(lists);
        LinkedList<ListNode> linkedList = new LinkedList<>();

        for (int i = 0,l=lists.length; i < l; i++) {
            if(lists[i] != null){
                linkedList.add(lists[i]);
            }
        }
        int insertOffset;
        int sameVal;
        while (!linkedList.isEmpty()){
            //第一位永远最小
            ListNode innerNode = linkedList.getFirst();
            if(innerNode != null){
                next.next = innerNode;
                sameVal = innerNode.val;
                innerNode = innerNode.next;
                next = next.next;
                //value相同 一直往后遍历
                while (innerNode != null && sameVal == innerNode.val ){
                    next.next = innerNode;
                    innerNode = innerNode.next;
                    next = next.next;
                }
                //检查剩余的node，null移除，非null重新排位
                if(innerNode == null){
                    linkedList.removeFirst();
                }else{
                    linkedList.removeFirst();
                    insertOffset = linkedList.size();
                    for (int i = 0,val = innerNode.val; i < insertOffset; i++) {
                        if(linkedList.get(i).val >=  val){
                            insertOffset = i;
                            break;
                        }
                    }
                    linkedList.add(insertOffset,innerNode);
                }
            }else{
                break;
            }
        }

        return re.next;
    }


    private ListNode[] removeArrayEmptyTextBackNewArray(ListNode[] nodes) {
        List<ListNode> strList= Arrays.asList(nodes);
        List<ListNode> strListNew=new ArrayList<>();
        for (int i = 0; i <strList.size(); i++) {
            if (strList.get(i)!=null&&!strList.get(i).equals("")){
                strListNew.add(strList.get(i));            }
        }
        ListNode[] strNewArray = strListNew.toArray(new ListNode[strListNew.size()]);

        return   strNewArray;

    }

    private ListNode[] insertSort(ListNode[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            ListNode temp = arr[i];
            int indx = 0;
            for(int j=i;j>0;j--){
                if(arr[j].val<arr[j-1].val){
                    arr[j] = arr[j-1];
                    indx = j-1;
                }else{
                    break;
                }
                arr[indx]=temp;
            }
        }
        return arr;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode re = new ListNode(0);
        for (ListNode innerNode:lists){
            re.next = mergeTwoLists(re.next,innerNode);
        }
        return re.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }



    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode a1 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(6);
        ListNode e1 = new ListNode(7);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;

        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode d2 = new ListNode(8);
        ListNode e2 = new ListNode(9);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        ListNode[] innerNodes = {null,e2};

        System.out.println(mergeKSortedLists.mergeKLists(innerNodes).toString());
    }
}
