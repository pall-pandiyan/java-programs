package school;
import java.util.Scanner;

public class Student {
    String name;
    int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student() {
        this.name = "";
        this.mark = 0;
    }

    public void getDetails() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your name: ");
        name=scan.nextLine();
        System.out.println("Enter your marks: ");
        mark=scan.nextInt();
    }

    public void showDetails() {
        System.out.println("Name of the Student: "+name);
        System.out.println("Mark of "+name+" is "+mark);
    }
}
