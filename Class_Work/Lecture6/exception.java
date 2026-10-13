package Class_Work.Lecture6;

public class exception {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }
        catch(ArithmeticException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}
