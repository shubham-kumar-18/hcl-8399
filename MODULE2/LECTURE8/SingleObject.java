package MODULE2.LECTURE8;

public class SingleObject {
    private SingleObject() {
        System.out.println("SingleObject");
    }
//    public SingleObjectCreateInstance()
//    {
//        return obj;
//    }
    static final SingleObject obj = new SingleObject();
    public static SingleObject createInstance(){
        return obj;
    }

}
