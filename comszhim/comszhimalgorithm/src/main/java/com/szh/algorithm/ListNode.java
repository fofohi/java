package com.szh.algorithm;

import org.apache.zookeeper.server.DataNode;

import java.util.List;

public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode() {

    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(5);
        ListNode listNode13 = new ListNode(6);
        listNode11.setNext(listNode12);
        listNode12.setNext(listNode13);


        ListNode listNode21 = new ListNode(5);
        /*ListNode listNode22 = new ListNode(7);
        ListNode listNode23 = new ListNode(2);

        listNode21.setNext(listNode22);
        listNode22.setNext(listNode23);*/
        // 1->5->6 5->7->2
        //651 + 275  =  ===> 926  ==> 6->2->9
        ListNode r = addTwoNumbers(listNode11, listNode21);
        System.out.println(r);
        //6->5->1 2->7->5
        //651 + 275  =  ===> 926  ==> 9->2->6
        //ListNode rr = reverseListNode(r);
        //System.out.println(rr);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static ListNode reverseListNode(ListNode listNode){
        if (null == listNode || null == listNode.getNext())
            return listNode;
        ListNode pre = listNode;
        ListNode cur = listNode.getNext();
        while (null != cur.getNext()) {
            ListNode tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        cur.setNext(pre);
        listNode.setNext(null);
        return cur;


    }
}
