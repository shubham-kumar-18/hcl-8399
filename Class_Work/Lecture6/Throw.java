package Class_Work.Lecture6;

public class Throw {

    static class InvalidAgeException extends RuntimeException {
        InvalidAgeException(String s) {
            super(s);
        }
    }
    public static void main(String[] args) {
        int age =10;
        try {
            if (age < 18) {
                throw new InvalidAgeException("Invalid Age");
            }
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hello World");


    }
}
