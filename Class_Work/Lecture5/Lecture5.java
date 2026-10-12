package Class_Work.Lecture5;

public class Lecture5 {
    interface A{
        void m1();
    }

    public static void main(String[] args) {
        A a = () -> {
            System.out.println("Hello");
        };
        a.m1();
    }
}
