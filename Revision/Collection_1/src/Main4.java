import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Nishant");
        arrayList.add("Nayan");
        arrayList.add("Ram");
        arrayList.add("Niket");
        arrayList.add("Rishab");
        System.out.println("Print all the array elements");
        for (String i : arrayList) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------");
        System.out.println("Print the array elements whose length is greater than 5");
        for (String i : arrayList) {
            if (i.length() > 5) System.out.println(i);
        }
        System.out.println("-------------------------------------");
        System.out.println("Remove the element at index 2 and print the remaining elements");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 2) System.out.println(arrayList.get(i));
        }
        System.out.println("-------------------------------------");
        System.out.println("Change the element at index 3 to \"Masai\" and print the array List");
        arrayList.set(3, "Masai");
        for (String i : arrayList) {
            System.out.println(i);
        }
    }
}
