package pack1;

public class StringCalculator {

    public static void main(String[] args){
        //Task 2.
        // Given a string, find the number of words in it.
        String s1 = "Hello everyone my name is Max and I'm 18";

        System.out.println("String's lenght is " + s1.split(" ").length);

        //Task 3.
        // Given a string, show number of chars in each word

        for(String s2:s1.split("")){
            System.out.print(" " + s2.length() + " ");
        }
        System.out.println("");
        System.out.println("Number of chars in each word");

        //Task 4.
        // Create function which takes 2 parameters:
        //1st(String) – text; 2nd (int) - index of word. Function
        // should return number of chars in word by its index in text

        System.out.println("Number of chars in word by its index in text: " + stringCalculator(s1, 4));

    }
    static int stringCalculator(String s1, int i){
        return s1.split(" ")[i].length();
    }
}
