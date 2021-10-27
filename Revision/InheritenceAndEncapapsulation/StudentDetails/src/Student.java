import java.util.Scanner;
import java.util.SortedMap;

public class Student {
    private String name;
    private String DOB;
    private String blood_group;

    public Student(String name, String DOB, String blood_group) {
        this.name = name;
        this.DOB = DOB;
        this.blood_group = blood_group;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name");
        String name = sc.nextLine();
        System.out.println("Enter date of birth");
        String DOB = sc.nextLine();
        System.out.println("Enter blood group");
        String blood_group = sc.nextLine();
        System.out.println("Enter current year");
        int current_year = sc.nextInt();
        Student student = new Student(name,DOB,blood_group);
        System.out.println("Student name is "+student.getName());
        System.out.println("Student date of birth is "+student.getDOB());
        System.out.println("Student blood group is "+student.getBlood_group());

        String[] year = DOB.split("-");
        String year_DOB = year[2];
        int year_birth = Integer.parseInt(year_DOB);
        int age = current_year - year_birth;
        System.out.println("Student age is "+age);
    }
}
