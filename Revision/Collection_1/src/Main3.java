public class Main3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("The element inside array are : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Remove the element at index = 0");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Remove the element at index = n-1");
        for (int i = 0; i < arr.length; i++) {
            if (i != (arr.length - 1)) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Remove the element at index = 3");
        for (int i = 0; i < arr.length; i++) {
            if (i != 3) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
