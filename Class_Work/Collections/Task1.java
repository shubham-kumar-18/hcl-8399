package Class_Work.Collections;
import java.util.*;
public class Task1 {
    static class Student implements Comparable<Student>{
        String name;
        int roll;
        int age;
        int marks;

        public Student(String name ,int roll,int age,int marks)
        {
            this.name=name;
            this.roll=roll;
            this.age=age;
            this.marks=marks;
        }
        public String toString(){
            return name + " " + roll +" " + age + " "+ marks;
        }
        @Override
        public int compareTo(Student o) {
            return this.age - o.age;
        }


    }
   static class MyComparator implements Comparator<Student>{
        public int compare(Student s1,Student s2) {
            return Integer.compare(s1.roll, s2.roll);
        }
   }
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Shubham",1,20,98));
        list.add(new Student("Sameer",2,18,96));
        list.add(new Student("Sumit",3,25,99));
        list.add(new Student("Kapil",4,22,92));
        System.out.println(list);
//        Collections.sort(list,(x,y)->Integer.compare(x.age,y.age));
        Collections.sort(list);
        for(Student s : list)
        {
            System.out.println(s);
        }
        Collections.sort(list,new MyComparator());
        System.out.println("After comparable");
        for(Student s : list)
        {
            System.out.println(s);
        }

    }
}
