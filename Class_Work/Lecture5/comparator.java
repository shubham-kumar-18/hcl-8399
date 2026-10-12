package Class_Work.Lecture5;
import java.util.*;
public class comparator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(10);
        list.add(50);
        list.add(40);
        list.add(30);
        list.sort((a,b) -> a-b);

        System.out.println(list);
        list.sort((a,b) -> b-a);
        System.out.println(list);
    }
}
