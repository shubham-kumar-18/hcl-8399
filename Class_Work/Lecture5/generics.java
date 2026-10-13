package Class_Work.Lecture5;

import java.util.*;
class Box<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class generics {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.setValue(10);
        System.out.println(b1.getValue());

        Box<String> b2 = new Box<>();
        b2.setValue("String");
        System.out.println(b2.getValue());
        
    }
}
