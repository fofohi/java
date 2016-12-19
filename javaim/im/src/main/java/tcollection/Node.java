package tcollection;

/**
 * Created by dell on 2016/12/19.
 */
public class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {
        Node head = new Node("head");
        head.next = null;
        
        Node tNode1 = new Node("1");
        head.next = tNode1;
        Node tNode2 = new Node("2");
        tNode1.next = tNode2;

        while (head.getNext() != null){
            System.out.println(head.getData());
            head = head.getNext();
        }


    }
}
