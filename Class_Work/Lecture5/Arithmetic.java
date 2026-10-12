package Class_Work.Lecture5;
// Functional Interface
public class Arithmetic {
    interface arith{
        void calc(int a,int b);
    }
    interface square{
        void calc(int a);
    }


    public static void main(String[] args) {
        arith add = (a,b)->{
            System.out.println("Addition" +"->"+ (a+b));
        };
        add.calc(5,6);

        arith sub = (a,b)->{
            System.out.println("Subtraction" +"->"+ (a-b));
        };
        sub.calc(8,6);

        arith mul = (a,b)->{
            System.out.println("Multiply" + "->"+(a*b));
        };
        mul.calc(5,6);

        arith div = (a,b)->{
            System.out.println("Division" +"->"+ (a/b));
        };
        div.calc(12,6);

        square squ=(a)-> {
            System.out.println("Square" + "->" + (a * a));
        };
        squ.calc(3);
    }
}
