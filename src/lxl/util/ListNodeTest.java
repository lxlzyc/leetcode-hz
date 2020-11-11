package lxl.util;

/**
 * @program: leetcode-hz
 * @description:
 * listNode测试用参数
 * @author: lxl
 * @create: 2019-12-04 14:19
 **/
public class ListNodeTest {

    public static ListNode getListNode1(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        return a;
    }

    public static ListNode getListNode2(){
        ListNode a1 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(6);
        ListNode e1 = new ListNode(7);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        return a1;
    }

    public static ListNode getListNode3(){
        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode d2 = new ListNode(3);
        ListNode e2 = new ListNode(4);
        ListNode f2 = new ListNode(4);
        ListNode g2 = new ListNode(5);

        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = f2;
        f2.next = g2;
        return a2;
    }

    public static ListNode getListNode4(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode d2 = new ListNode(8);
        //ListNode e2 = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b2;
        b2.next = c2;
        c2.next = d2;
        //d2.next = e2;
        return a;
    }

    public static ListNode getListNode5() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(2);
        ListNode d2 = new ListNode(1);
        ListNode e2 = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        return a;
    }


}
