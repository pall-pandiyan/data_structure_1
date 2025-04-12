import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("new array list size: " + list.size());

        System.out.println("Adding new item: 5");
        list.add(5);

        System.out.println("Adding new item: 89");
        list.add(89);

        System.out.println("Adding new item: -45");
        list.add(-45);

        System.out.println("array list: " + list);
        System.out.println("array list size: " + list.size());
    }
}
