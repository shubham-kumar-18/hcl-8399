package Class_Work.Lecture6.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().filter(n -> n % 2 == 0).forEach(System.out::print);
        System.out.println();
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        List<String> l2 = Arrays.asList("Shubham","Sumit","Sameer","Siddharth","Rahul","Rohan");
        l2.stream().filter(n ->n.length()>5).forEach(System.out::print);
        System.out.println();
        l2.stream().filter(n -> n.charAt(0)=='S').forEach(System.out::print);
        System.out.println();
        //Comparator
        list.stream().sorted((a,b)->b-a).forEach(System.out::print);
        System.out.println();
        list.stream().map(n ->n*n).forEach(System.out::print);


    }
}
