package com.szh.algorithm.datastruct;

public class LinkedListTest {


    public static void main(String[] args) {

        NodeCase n1 = new NodeCase(1);
        NodeCase n2 = new NodeCase(2);
        NodeCase n3 = new NodeCase(3);
        NodeCase n4 = new NodeCase(4);
        NodeCase n5 = new NodeCase(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);


        NodeCase x = reverseWhile(n1);
        System.out.println(x);
    }


    private static NodeCase reverseWhile(NodeCase n){
        //保存现在的next引用
        NodeCase next = n.getNext();
        n.setNext(null);
        //n1 null
        while (next != null){
            NodeCase n1 = next.getNext();
            NodeCase n3 = next;
            n3.setNext(n);
            n = n3;
            next = n1;
        }

        return n;
    }










    private static NodeCase reverse(NodeCase nodeCase){
        if(nodeCase.getNext() == null){
            return nodeCase;
        }
        NodeCase prev = reverse(nodeCase.next);
        nodeCase.next.next = nodeCase;
        nodeCase.next = null;



        return prev;
    }



    private static class NodeCase{
        private int value = 0;


        private NodeCase next = null;


        public NodeCase(int value) {
            this.value = value;
        }
        public NodeCase getNext() {
            return next;
        }

        public void setNext(NodeCase next) {
            this.next = next;
        }
    }
}
