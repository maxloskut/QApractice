package pack1;

public class Calculator {

    //Task 1.
    // Implement a simple calculator with 4 operations.
    // Each operation - different method. Use it in the main method.

    public static void main(String[] args){
        int a = 4;
        int b = -2;

        System.out.println(add(a,b));
        System.out.println(substract(a,b));
        System.out.println(divide(a,b));
        System.out.println(multiply(a,b));
    }

    private static int add(int a, int b) {
        return a + b;
    }
    private static int substract(int a, int b) {
        return a - b;
    }
    private static int divide(int a, int b) {
        return a / b;
    }
    private static int multiply(int a, int b) {
        return a * b;
    }
}
