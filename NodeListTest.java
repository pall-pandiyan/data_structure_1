import java.util.Arrays;

class NodeList {
    class Node {
        public int value;
        public Node next;

        public Node(int item) {
            value = item;
        }
    }

    public Node head;
    public Node tail;
    public int size = 0;

    public void AddFirst(int item) {
        System.out.println("Adding from head, item: " + item);

        var node = new Node(item);

        if (head == null) {
            System.out.println("NodeList is empty, creating a new head!");
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void AddLast(int item) {
        System.out.println("Adding from tail, item: " + item);

        Node node = new Node(item);
        if (head == null) {
            System.out.println("NodeList is empty, creating a new head!");
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void RemoveFirst() {
        System.out.println("remove item from head!");

        if (head == null) {
            System.out.println("No items to remove");
        }
        if (head == tail) {
            head = tail = null;
            size = 0;
            return;
        }

        var second = head.next;
        head.next = null;
        head = second;

        size--;
    }

    public void RemoveLast() {
        System.out.println("remove item from tail!");

        if (head == null) {
            System.out.println("No items to remove");
        }
        if (head == tail) {
            head = tail = null;
            size = 0;
            return;
        }

        var current = head;
        while (current != null) {
            if (current.next == tail)
                break;
            current = current.next;
        }
        current.next = null;
        tail = current;

        size--;
    }

    public int IndexOf(int item) {
        if (head == null)
            return -1;

        int result = 0;
        var current = head;
        while (current != null) {
            if (current.value == item)
                return result;
            current = current.next;
            result++;
        }
        return 1;
    }

    public boolean contains(int item) {
        return IndexOf(item) != -1;
    }

    public int[] toArray() {
        int[] result = new int[size];
        int ind = 0;
        var current = head;

        while (current != null) {
            result[ind] = current.value;
            ind++;
            current = current.next;
        }
        return result;
    }

    public void print() {
        System.out.print("Printing NodeList: ");
        if (head == null) {
            System.out.println("NodeList is empty!");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class NodeListTest {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        NodeList list = new NodeList();
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddFirst(10);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddFirst(20);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddFirst(30);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddLast(50);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddLast(60);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.AddLast(70);
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.RemoveFirst();
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        list.RemoveLast();
        list.print();
        System.out.println("size: " + list.size);
        System.out.println();

        System.out.println(Arrays.toString(list.toArray()));
    }
}
