
class NodeList {
    class Node {
        public int value;
        public Node previous;
        public Node next;

        public Node(int item) {
            value = item;
        }
    }

    public Node head;
    public Node tail;

    public NodeList() {
    }

    public void add_at_head(int item) {
        System.out.println("Adding from head, item: " + item);

        var node = new Node(item);

        if (head == null) {
            System.out.println("NodeList is empty, creating a new head!");
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void print() {
        System.out.println("Printing NodeList:");

        Node current = head;
        while (current.next != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);
    }
}

public class NodeListTest {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        NodeList list = new NodeList();
        list.add_at_head(10);
        list.add_at_head(20);
        list.print();
    }
}
