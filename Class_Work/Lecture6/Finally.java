package Class_Work.Lecture6;

public class Finally {
    public static int m1(){
        try{
            return 777;
        }
        catch(Exception e){
            return 0;
        }
        finally {
            return 999;
        }
    }

    public static void main(String[] args) {
        System.out.println(m1());
    }
}
