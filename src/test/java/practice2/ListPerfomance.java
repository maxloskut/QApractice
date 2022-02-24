package practice2;

import java.util.*;

public class ListPerfomance {
    public static void main(String[] args) {
        //4) Check performance for some List operations (get(i),
        // insertAfter(i), ..) for different collection implementations.

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        for(int i = 0; i < 1000;i++){
            list1.add(UUID.randomUUID().toString());
            list2.add(UUID.randomUUID().toString());
        }
        System.out.println("GET Array: "+checkPerfGet(list1));
        System.out.println("GET Linked: "+checkPerfGet(list1));

        System.out.println("SORT Array: "+checkPerfGet(list2));
        System.out.println("SORT Linked: "+checkPerfGet(list2));
    }

    private static long checkPerfGet(List<String> list1) {
        long start = new Date().getTime();
        Random rand = new Random();

        for (int i = 0; i<1000; i++){
            int length =
                    list1.get(rand.nextInt( list1.size()-1)).length();
        }
        return new Date().getTime()-start;
    }
    private static long checkSort(List<String> list) {
        long start = new Date().getTime();
        for (int i = 0; i < 100000; i++){
            list.add(UUID.randomUUID().toString());
        }
        return new Date().getTime() - start;
    }
}
