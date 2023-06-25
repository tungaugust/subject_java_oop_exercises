package main.module_one;

public class ProgramsOfModuleOne {

    // Exercise 3
    public static void sumOddOrEven(int n){
        System.out.print(n + ": ");
        int sum = 0;
        if (n % 2 == 0) {
            for(int i = 2; i < n; i+=2){
                sum += i;
                System.out.print(i + "+");
            }
        } else {
            for(int i = 1; i < n; i+=2){
                sum += i;
                System.out.print(i + "+");
            }
        }
        sum += n;
        System.out.print(n + " = ");
        System.out.println(sum);
    }
    // Exercise 4
    public static void linearEquationOneVariableSolution(double a, double b){
        // Ax + B = 0
        double result; // x

    }
}
