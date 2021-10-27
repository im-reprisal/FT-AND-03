import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Commercial commercial = new Commercial();
        System.out.println("Enter commercial user name");
        commercial.setName(sc.nextLine());

        Domestic domestic = new Domestic();
        System.out.println("Enter domestic user name");
        domestic.setName(sc.nextLine());
        System.out.println("Enter unit consumption");
        int unit = sc.nextInt();
        System.out.println("Customer : "+commercial.getName());
        commercial.CalculateBill(unit);
        System.out.println("Customer : "+domestic.getName());
        domestic.CalculateBill(unit);
    }
}
