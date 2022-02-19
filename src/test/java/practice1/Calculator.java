package practice1;

import practice2.DivByZeroException;

public class Calculator {

    //Task 1.
    // Implement a simple calculator with 4 operations.
    // Each operation - different method. Use it in the main method.

    public static void main(String[] args){
        int a = 4;
        int b = -2;

        System.out.println("Sum is " + add(a,b));
        System.out.println("Difference is " + substract(a,b));
        System.out.println("Division is " + divide(a,b));
        System.out.println("Multiplication is " + multiply(a,b));
    }

    private static int add(int a, int b) {
        return a + b;
    }
    private static int substract(int a, int b) {
        return a - b;
    }
    public static int divide(int a, int b) {
        if(b == 0) try {
            throw new DivByZeroException("error");
        } catch (DivByZeroException e) {
            e.printStackTrace();
        }
        return a / b;
    }
    private static int multiply(int a, int b) {
        return a * b;
    }
}
