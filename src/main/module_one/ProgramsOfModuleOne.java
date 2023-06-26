package main.module_one;

import java.util.ArrayList;
import java.util.Scanner;

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
        // Form  of Linear Equation in One Variable: Ax + B = 0
        // Case 1: A = 0, B = 0 => Phuong trinh vo so nghiem.
        // Case 2: A = 0, B != 0 => Phuong trinh vo nghiem.
        // Case 3: A != 0 => Phuong trinh co mot nghiem la x = -B/A.
        if (a == 0) {
            if (b == 0){
                System.out.printf("Phuong trinh %.2fX + %.2f = 0 la phuong trinh vo so nghiem.\n", a, b);
            } else {
                System.out.printf("Phuong trinh %.2fX + %.2f = 0 la phuong trinh vo nghiem.\n", a, b);
            }
        } else {
            System.out.printf("Phuong trinh %.2fX + %.2f = 0 co mot nghiem: X = %.2f\n", a, b, -b/a);
        }
    }
    // Exercise 5: Dung giai thuat Giai thuat Euclid.
    public static void greatestCommonDivisorWithDivision(int a, int b){
//        if (a >= b)
        return;
    }
    public static void greatestCommonDivisorWithSubtraction(int a, int b){
        int x = a;
        int y = b;
        while(x!= y){
            if (x > y){
                x = x - y;
            } else {
                y = y - x;
            }
        }
        System.out.printf("Uoc so chung lon nhat cua %d va %d la %d.\n", a, b, x);
    }
    private static int _greatestCommonDivisorWithRecursive(int a, int b){
        if (b == 0){
            return a;
        } else {
            return _greatestCommonDivisorWithRecursive(b, a % b);
        }
    }
    public static void greatestCommonDivisorWithRecursive(int a, int b){
        System.out.printf("Uoc so chung lon nhat cua %d va %d la %d.\n", a, b, _greatestCommonDivisorWithRecursive(a, b));
    }

    // Exercise 6
    public static boolean isPrimeNumber(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void primeNumber(int n){
        if (isPrimeNumber(n)){
            System.out.println("So " + n + " la so nguyen to.");
        } else {
            System.out.println("So " + n + " khong la so nguyen to.");
        }
    }
    // Exercise 7
    public static void sumOfPrimeNumberLessThan(int n){
        int sum = 0;
        for (int i = 2; i < n; i++){
            if (isPrimeNumber(i)){
                sum += i;
            }
        }
        System.out.println("Tong cac so nguyen to nho hon so " + n + " la " + sum);
    }
    // Exercise 8
    public static void sumOfFirstNNumbersPrimeNumber(int n){
        int sum = 0;
        int k = 0;
        int i = 2;
        while(k < n){
            if (isPrimeNumber(i)){
                k += 1;
                sum += i;
            }
            i++;
        }
        System.out.println("Tong cua " + n + " so nguyen to dau tien la " + sum);
    }
    // Exercise 9
    public static void countCharacterInString(char c, String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if( s.charAt(i) == c){
                count++;
            }
        }
        System.out.println("So lan xuat hien cua ky tu '" + c + "' trong chuoi '" + s + "' la " + count + " lan.");
    }
    // Exercise 10
    public static void splitStringIntoWords(String s){
        int size = s.length();
        String sub;
        ArrayList<String> strArray = new ArrayList<String>();
        for (int i = 0; i < size; i++){
            if (s.charAt(i) != ' '){
                // starting a word
                sub = "";
                for (int j = i; j < size; j++){
                    i = j;
                    if (s.charAt(j) != ' '){
                        sub += s.charAt(j);
                    } else {
                        // ending a word
                        break;
                    }
                }
                strArray.add(sub);
            }
        }
        for (String str: strArray){
            System.out.println(str);
        }
    }
    // Exercise 11
    public static void countDigitsInString(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                count++;
            }
        }
        System.out.println("So ky tu chu so co trong chuoi '" + s +  "' la " + count + " ky tu.");
    }
    // Exercise 12
    public static void sumFirstNEvenNumbers(int n){
        int sum  = 0;
        int k = 0;
        int i = 0;
        while(k < n){
            i += 2;
            sum += i;
            k++;
        }
        System.out.println("Tong cua " + n + " so chan dau tien (khong tinh so 0) la " + sum);
    }
    // Exercise 13
    public static void printOddNumbers(int start, int end){
        System.out.print(start + "->" + end + ": ");
        for (int i = start; i < end; i++){
            if (i %2 != 0){
                System.out.print(i + " ");
            }
        }
        if (end % 2 != 0){
            System.out.println(end);
        } else {
            System.out.println();
        }
    }
    // Exercise 14 + 17
    public static void printMultipleFromTo(int num, int start, int end){
        System.out.println("Boi so cua " + num + " trong pham vi tu " + start + " den  " + end + ":");
        int multiple = num;
        int k = 1;
        int sum = 0;
        while(multiple <= end) {
            multiple = num * k;
            if (multiple >= start && multiple <= end){
                sum += multiple;
                System.out.print(multiple + " ");
            }
            if (multiple > end){
                break;
            }
            k++;
        }
        System.out.println("\nTong cua cac boi so la " +  sum);
    }
    // Exercise 15
    public static void findMinMaxFromInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("So chu so can nhap la: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }
        int min = numbers[0];
        int max = numbers[0];
        for(int i = 0; i < n - 1; i++){
            if (min > numbers[i + 1]){
                min  = numbers[i + 1];
            }
            if (max < numbers[i + 1]){
                max  = numbers[i + 1];
            }
        }
        System.out.println("Min: " + min + " -- Max: " + max);
    }
    // Exercise 16
    public static void printIntegerOddEven(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        int n = sc.nextInt();
        if (n % 2 == 0){
            System.out.println("So n = " + n + " la so chan.");
        } else {
            System.out.println("So n = " + n + " la so le.");
        }
    }
    // Exercise 18
    public static int fibonacci(int n){
        if (n <= 0) {
            return -1;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void printFibonacci(int n){
        System.out.print("Day so Fibonacci voi " + n + " so dau tien: ");
        if (n <= 0){
            System.out.println(".");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    // Exercise 19

    // Exercise 20
}
