// import java.util.Arrays;

class Array {
    private int[] numbers;
    private int index = 0;

    public Array(int length) {
        System.out.println("Initiating a new array with length: " + length);

        // initialize the array with the given length.
        numbers = new int[length];
    }

    public void print() {
        System.out.println("Printing array:");

        // print only stored data, not the default 0s.
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
    }

    public void insert(int item) {
        System.out.println("Inserting item: " + item);

        // if the array does not have enough space, update the array size.
        if (index >= numbers.length) {
            int[] new_numbers = new int[index * 2];
            for (int i = 0; i < index; i++) {
                new_numbers[i] = numbers[i];
            }
            System.out.println(
                    "Array capacity increased! old length: " + numbers.length + " new length: " + new_numbers.length);
            numbers = new_numbers;
        }

        // add the item in the array and increase the index.
        numbers[index] = item;
        index = index + 1;
    }

    public void removed_at(int id) {
        // check if the provided index is valid.
        if (id < 0 || id >= index) {
            System.out.println("Invalid index: " + id);
            return;
        }

        // shift the remaining items to left one position.
        for (int i = id; i < index - 1; i++) {
            numbers[i] = numbers[i + 1];
        }

        // finally the last index will be reset to 0.
        numbers[index - 1] = 0;

        // update the index
        index = index - 1;
        return;
    }

    public int index_of(int item) {
        System.out.println("Searching for item: " + item);

        for (int i = 0; i < index; i++) {
            if (item == numbers[i]) {
                System.out.println("Item found at: " + i);
                return i;
            }
        }
        System.out.println("Item not found!");
        return -1;
    }
}

public class DynamicArray {
    public static void main(String[] args) {
        Array numbers = new Array(2);
        numbers.insert(10);
        numbers.insert(15);
        numbers.insert(50);
        numbers.print();
    }
}
