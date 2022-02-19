package practice2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args){
        //3) Given: String with big text (more than 1000 words).
        //Write a method that calculates the numbers of
        //words for each letter that starts the word.

        String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and " +
                      "typesetting industry. Lorem Ipsum has been the industry's " +
                      "standard dummy text ever since the 1500s, when an unknown " +
                      "printer took a galley of type and scrambled it to make a " +
                      "type specimen book. ";
        Map<Character, Integer> res = new HashMap<>();

        for(String w: loremIpsum.split("")){
            res.putIfAbsent(w.charAt(0), 0);
            res.put(w.charAt(0), res.get(w.charAt(0)) + 1);
        }
        System.out.println(new TreeMap<>(res));
    }
}
