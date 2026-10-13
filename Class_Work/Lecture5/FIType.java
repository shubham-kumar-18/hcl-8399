package Class_Work.Lecture5;
import java.util.*;
import java.util.function.*;

public class FIType {
    public static void main(String[] args) {
        Predicate<Integer> p = n -> n%2==0;
        System.out.println(p.test(2));

        Function<Integer,Integer> f = n -> n*n;
        System.out.println(f.apply(4));

        Supplier<Double> s = () -> Math.random()*10;
        System.out.println(s.get());

        Consumer<String> c = name -> System.out.println(name);
        c.accept("Shubham");

        BiFunction<Integer,Integer,Integer> bf = (a,b) -> a*b;
        System.out.println(bf.apply(2,3));


    }
}
