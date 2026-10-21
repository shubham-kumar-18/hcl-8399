package MODULE2.LECTURE8;

import static MODULE2.LECTURE8.SingleObject.obj;

public class SingleMain {
    public static void main(String[] args) {
        SingleObject obj1 = obj.createInstance();
        SingleObject obj2 = obj.createInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 == obj2);
    }
}
