import java.util.Arrays;

class List {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public int size = 0;
    private Node head;
    private Node tail;

    public void print() {
        System.out.print("Printing: ");

        if (head == null) {
            System.out.print("List is empty!\n");
            return;
        }

        var current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void append(int item) {
        // append a item at the tail.
        System.out.println("append item: " + item);

        Node node = new Node(item);

        // updating the list size.
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    public void append_left(int item) {
        // append a item at the head
        System.out.println("append_left item: " + item);

        Node node = new Node(item);

        // updating the list size.
        size++;

        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int ind = 0;

        Node current = head;
        while (current != null) {
            array[ind++] = current.value;
            current = current.next;
        }
        return array;
    }
}

public class ListTest {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        List list = new List();
        list.print();
        System.out.println();

        list.append(1);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.append(19);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.append(30);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.append_left(-30);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.append_left(-20);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        System.out.println(Arrays.toString(list.toArray()));
    }
}
