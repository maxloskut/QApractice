package pack1;

public class StringCalculator {

    public static void main(String[] args){
        //Task 2.
        // Given a string, find the number of words in it.
        String s1 = "Find the number of words in it";

        System.out.println(s1.split(" ").length);

        //Task 3.
        // Given a string, show number of chars in each word

        for(String w:s1.split("")){
            System.out.println(w.length());
        }

        //Task 4.
        // Create function which takes 2 parameters:
        //1st(String) – text; 2nd (int) - index of word. Function
        // should return number of chars in word by its index in text

        System.out.println(stringCalculator(s1, 2));


    }
    static int stringCalculator(String s1, int i){
        return s1.split(" ")[i].length();
    }
}
