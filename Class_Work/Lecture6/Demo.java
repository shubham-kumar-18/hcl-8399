package Class_Work.Lecture6;

import static java.lang.System.exit;

public class Demo {
    public static void main(String[] args) {
        try{
            System.out.println("Hello World");
            exit(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Goodbye World");
        }
    }
}
