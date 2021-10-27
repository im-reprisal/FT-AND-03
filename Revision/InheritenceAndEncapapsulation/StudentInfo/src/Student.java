import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter test case");
        int testCase = sc.nextInt();
        sc.nextLine();
        while (testCase != 0) {

            System.out.println("Enter student name");
            student.setName(sc.nextLine());
            System.out.println("Enter student age");
            student.setAge(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter student address");
            student.setAddress(sc.nextLine());
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddress());
            testCase--;
        }
    }
}
