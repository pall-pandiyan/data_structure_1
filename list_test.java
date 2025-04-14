import java.util.Scanner;

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
        System.out.print("\t*  Printing the list: ");
        if (is_empty()) {
            System.out.println("\t*  List is empty!\n");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void print_detailed() {
        /*
         * Print detailed information, head and tail and previous and next reference on
         * every element.
         * 
         * Developer: Pall Pandiyan.S
         */
        System.out.print("\t*  Printing detailed info:");
        if (is_empty()) {
            System.out.print("\t*  Empty list!\n");
            return;
        }
        System.out.print("head: " + head.value + " ");
        System.out.print("tail: " + tail.value + "\n");

        Node current = head;
        while (current != null) {
            if (current.previous != null) {
                System.out.print("\t*  previous: " + current.previous.value + " ");
            } else {
                System.out.print("\t*  previous: null ");
            }

            System.out.print("value: " + current.value + " ");

            if (current.next != null) {
                System.out.print("next: " + current.next.value + "\n");
            } else {
                System.out.print("next: null\n");
            }

            current = current.next;
        }
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
        System.out.println("\t*  initialize the list! item: " + node.value);
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
            System.out.println("\t*  add a new elment at the head! item: " + element_value);
            new_node.next = head;
            head.previous = new_node;
            head = new_node;
        } else if (type_id == 2) {
            // add a new elment at the tail.
            System.out.println("\t*  add a new elment at the tail! item: " + element_value);
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
            System.out.println("\t*  remove the element on head! item: " + head.value);
            Node second_node = head.next;
            second_node.previous = null;
            head.next = null;
            head = second_node;
        } else if (type_id == 2) {
            // remove the element on tail.
            System.out.println("\t*  remove the element on tail! item: " + tail.value);
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

    public int search_first(int target_value) {
        /*
         * Linearly search through the list from head to tail for the target_value, if
         * the target found on the list return the index of the element, otherwise
         * return -1.
         * 
         * Developer: Pall Pandiyan.S
         */
        Node current = head;
        int ind = -1;

        while (current != null) {
            ind++;
            if (target_value == current.value) {
                return ind;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int target_value) {
        /*
         * Check if the target_value is found on the list, if it is exists return true,
         * otherwise return false.
         * 
         * Developer: Pall Pandiyan.S
         */
        return search_first(target_value) != -1;
    }

    public int sum() {
        /*
         * Calculate the sum of the values in the list and return it.
         * 
         * Developer: Pall Pandiyan.S
         */
        Node current = head;
        int sum = 0;

        while (current != null) {
            sum += current.value;
            current = current.next;
        }
        return sum;
    }

    public float average() {
        /*
         * Calculate the average value of the list and return it (as float).
         * 
         * Developer: Pall Pandiyan.S
         */
        int sum = sum();
        return sum / size;
    }

    public void reverse() {
        /*
         * Reverse the current function inplace (just update the address references).
         * 
         * Developer: Pall Pandiyan.S
         */

        Node current = head;
        while (current != null) {
            Node next = current.next;
            Node previous = current.previous;
            current.previous = next;
            current.next = previous;

            current = current.previous;
        }
        // make sure to update head, tail references
        Node old_tail = tail;
        tail = head;
        head = old_tail;
    }
}

public class list_test {
    public static void main(String[] args) {
        // creating the user interface:
        System.out.println();
        System.out.println("\t*------------------------------------------------*");
        System.out.println("\t*                 list functions:                *");
        System.out.println("\t*------------------------------------------------*");
        System.out.println("\t*  1) add an element from head.                  *");
        System.out.println("\t*  2) add an element from tail.                  *");
        System.out.println("\t*  3) remove an element from head.               *");
        System.out.println("\t*  4) remove an element from tail.               *");
        System.out.println("\t*  5) search for an element.                     *");
        System.out.println("\t*  6) check if an element exists in the list.    *");
        System.out.println("\t*  7) sum of all the elements in the list.       *");
        System.out.println("\t*  8) average of all the elements in the list.   *");
        System.out.println("\t*  9) reverse the list.                          *");
        System.out.println("\t*------------------------------------------------*");
        System.out.println("\t* -3) print detailed list.                       *");
        System.out.println("\t* -2) print list.                                *");
        System.out.println("\t* -1) print size.                                *");
        System.out.println("\t*  0) EXIT.                                      *");
        System.out.println("\t*------------------------------------------------*");

        // declaring varriables:
        list l = new list();
        Scanner scanner = new Scanner(System.in);
        int choice, new_value;
        boolean repeat = true;

        // get a user input and process repeatedly unless user quites.
        outside: while (repeat) {
            System.out.println();
            System.out.println("\t*------------------------------------------------*");
            System.out.print("\t*  enter your choice: ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                // make sure to catch the user input to avoid infinite loop.
                scanner.next();
                System.out.println("\t*  Invalid choice!                               *");
                System.out.println("\t*------------------------------------------------*");
                continue outside;
            }

            switch (choice) {
                case -3:
                    l.print_detailed();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case -2:
                    l.print();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case -1:
                    System.out.println("\t*  Size: " + l.size);
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case 0:
                    System.out.println("\t*  Goodbye!                                      *");
                    System.out.println("\t*------------------------------------------------*");
                    repeat = false;
                    break;
                case 1:
                    System.out.print("\t*  enter the new number: ");
                    new_value = scanner.nextInt();
                    l.add_first(new_value);
                    System.out.println("\t*  Size: " + l.size);
                    l.print();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case 2:
                    System.out.print("\t*  enter the new number: ");
                    new_value = scanner.nextInt();
                    l.add_last(new_value);
                    System.out.println("\t*  Size: " + l.size);
                    l.print();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case 3:
                    l.remove_first();
                    System.out.println("\t*  Size: " + l.size);
                    l.print();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case 4:
                    l.remove_last();
                    System.out.println("\t*  Size: " + l.size);
                    l.print();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                case 5:
                    System.out.print("\t*  enter the number to search: ");
                    new_value = scanner.nextInt();
                    System.out.println("\t*  Index: " + l.search_first(new_value));
                    break;
                case 6:
                    System.out.print("\t*  enter the number to check: ");
                    new_value = scanner.nextInt();
                    System.out.println("\t*  list contains " + new_value + "? " + l.contains(new_value));
                    break;
                case 7:
                    System.out.println("\t*  Sum: " + l.sum());
                    break;
                case 8:
                    System.out.println("\t*  Average: " + l.average());
                    break;
                case 9:
                    l.reverse();
                    System.out.println("\t*  Size: " + l.size);
                    l.print();
                    l.print_detailed();
                    System.out.println("\t*------------------------------------------------*");
                    break;
                default:
                    System.out.println("\t*  Invalid choice!                               *");
                    System.out.println("\t*------------------------------------------------*");
                    System.out.println();
            }
        }

        // saftely close the scanner.
        scanner.close();
    }
}
