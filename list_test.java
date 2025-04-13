class Node {
    /*
     * Represents a single node - a element of the list. It has a integer value and
     * addresses of next and previous elements.
     * 
     * Developer: Pall Pandiyan.S
     */
    public int value;
    public Node previous;
    public Node next;

    public Node(int value) {
        /*
         * Initialize the node with the integer value provided. The previous and next
         * addressess should be assigned seperately.
         * 
         * Developer: Pall Pandiyan.S
         */
        this.value = value;
    }
}

class list {
    /*
     * Creating a python like list, but only for storing integer elements.
     * 
     * Developer: Pall Pandiyan.S
     */
    private Node head;
    private Node tail;
    public int size = 0;

    public void print() {
        /*
         * Prints all the elements of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        System.out.print("Printing the list: ");
        if (is_empty()) {
            System.out.print("List is empty!\n");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean is_empty() {
        /*
         * Return true if the list is empty, otherwise return false.
         * 
         * Developer: Pall Pandiyan.S
         */
        return head == null;
    }

    private void initaliaze_list(Node node) {
        System.out.println("initialize the list! item: " + node.value);
        head = tail = node;
    }

    // methods to add a new element to the list
    private void add_element(int type_id, int element_value) {
        /*
         * Get a integer value, create a new node and append it on the head (type_id: 1)
         * / tail (type_id: 2) of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        Node new_node = new Node(element_value);

        // increase the list size by one.
        size++;

        if (is_empty()) {
            initaliaze_list(new_node);
            return;
        }

        if (type_id == 1) {
            // add a new elment at the head.
            System.out.println("add a new elment at the head! item: " + element_value);
            new_node.next = head;
            head.previous = new_node;
            head = new_node;
        } else if (type_id == 2) {
            // add a new elment at the tail.
            System.out.println("add a new elment at the tail! item: " + element_value);
            tail.next = new_node;
            new_node.previous = tail;
            tail = new_node;
        }
    }

    public void push(int element_value) {
        /*
         * Get a integer value, create a new node and append it on the tail of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        add_element(2, element_value);
    }

    public void append_left(int element_value) {
        /*
         * Get a integer value, create a new node and append it on the head of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        add_element(1, element_value);
    }

    public void append(int element_value) {
        /*
         * Get a integer value, create a new node and append it on the tail of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        add_element(2, element_value);
    }

    public void add_first(int element_value) {
        /*
         * Get a integer value, create a new node and append it on the head of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        add_element(1, element_value);
    }

    public void add_last(int element_value) {
        /*
         * Get a integer value, create a new node and append it on the tail of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        add_element(2, element_value);
    }

    // methods to remove element in the list.
    private void remove_element(int type_id) {
        /*
         * Remove an element from the list, either from head (type_id: 1) / tail
         * (type_id: 2).
         * 
         * Developer: Pall Pandiyan.S
         */

        // if the list is empty, do nothing.
        if (is_empty()) {
            return;
        }

        // decrease the size by one.
        size--;

        if (head == tail) {
            head = tail = null;
            return;
        }

        if (type_id == 1) {
            // remove the element on head.
            System.out.println("remove the element on head! item: " + head.value);
            Node second_node = head.next;
            second_node.previous = null;
            head.next = null;
            head = second_node;
        } else if (type_id == 2) {
            // remove the element on tail.
            System.out.println("remove the element on tail! item: " + tail.value);
            Node prev_node = tail.previous;
            prev_node.next = null;
            tail.previous = null;
            tail = prev_node;
        }
    }

    public void pop() {
        /*
         * Remove an element from the head of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        remove_element(1);
    }

    public void remove() {
        /*
         * Remove an element from the tail of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        remove_element(2);
    }

    public void remove_left() {
        /*
         * Remove an element from the head of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        remove_element(1);
    }

    public void remove_first() {
        /*
         * Remove an element from the head of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        remove_element(1);
    }

    public void remove_last() {
        /*
         * Remove an element from the tail of the list.
         * 
         * Developer: Pall Pandiyan.S
         */
        remove_element(2);
    }
}

public class list_test {
    public static void main(String[] args) {
        list l = new list();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.push(1);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.push(2);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.push(3);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.push(4);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.push(5);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.pop();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.pop();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.add_first(10);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.add_first(50);
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.remove_first();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.remove_first();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();

        l.remove_first();
        System.out.println("size: " + l.size);
        l.print();
        System.out.println();
    }
}
