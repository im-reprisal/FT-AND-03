import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KFC kfc = new KFC();
        System.out.println("Enter KFC Token");
        int kfc_token = sc.nextInt();
        FiveStarChicken fiveStarChicken = new FiveStarChicken();
        System.out.println("Enter Five Star Chicken Token");
        int fvc_token = sc.nextInt();
        kfc.friedChickenRecipe();
        kfc.display(kfc_token);
        System.out.println();
        fiveStarChicken.display(fvc_token);
    }
}
