import java.util.*;

public class Main2 {
    public static void main(String[] args) {
       Set<String> set = new HashSet<String>();
        set.add("India");
        set.add("Pak");
        set.add("China");
        set.add("India");
        set.add("Aus");
        set.add("Pak");
        set.add("China");
//        Iterator<String> i = set.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
        for (String j : set){
            System.out.println(j);
        }
        System.out.println("---------------");
        set.remove("India");
        for (String j : set){
            System.out.println(j);
        }
        System.out.println("----------------");
        for (String j : set){
            if (j.length() > 3){
                System.out.println(j);
            }
        }
    }
}
