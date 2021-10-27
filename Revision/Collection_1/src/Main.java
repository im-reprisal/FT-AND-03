import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Nishant",1);
        hashMap.put("Ram",2);
        hashMap.put("Gita",3);
        hashMap.put("Rishab",4);
        hashMap.put("Nayan",5);
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
           System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("-------------------");
        for (String i : hashMap.keySet()){
            System.out.println(i);
        }
        System.out.println("-------------------");
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if (entry.getKey().length() > 5) {
                System.out.println(entry.getValue());
            }
        }

//        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
//            if (entry.getKey().length() >= 6) {
//
//            }
//        }
        System.out.println("-------------------");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getKey().length() < 6) {
                System.out.println(entry.getKey());
            }
        }
    }
}
