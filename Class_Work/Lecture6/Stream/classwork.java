package Class_Work.Lecture6.Stream;
import java.util.*;
import java.util.HashMap;

public class classwork {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("F","Sneha");
        map.put("F","Shambhavi");
        map.put("M","Ram");
        map.put("M","Shubham");
        map.entrySet().stream().map(e -> e.getKey().equals("F") ? "Mrs " + e.getValue() :"Mr " + e.getValue()).forEach(System.out::println);
    }
}
