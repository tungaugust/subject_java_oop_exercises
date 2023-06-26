package main.module_one;

import java.util.PrimitiveIterator;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 1 *****");
        System.out.println("*** Unit 1. INPUT AND OUTPUT: Scanner class; println(), print(), printf() method.");
        System.out.println("*** Unit 2. OPERATORS: Arithmetic, Concat String, Comparison, Conditional.");
        System.out.println("*** Unit 3. CONTROL STRUCTURES: Selection and Iteration.");
        System.out.println(
                "if, if ... else, if ... else if ... else statement."
                + "switch ... case statement."
                + "for, while, do ... while statement."
        );

        /* ===== */
        System.out.println("\n*** Exercise 1. CAU TRUC IF-ELSE VA SWITCH-CASE.");
        IfElseDemo.demo();
        SwitchCaseDemo.demo();

        /* ===== */
        System.out.println("\n*** Exercise 2. CAU TRUC WHILE, DO-WHILE VA FOR.");
        WhileDemo.demo();
        DoWhileDemo.demo();
        ForDemo.demo();

        /* ===== */
        System.out.println("\n*** Exercise 3. TINH TONG 1+3+5+...+(N-1) NEU N LA CHAN, VA 2+4+6+...+(N-1) NEU N LA SO LE.");
        ProgramsOfModuleOne.sumOddOrEven(8);
        ProgramsOfModuleOne.sumOddOrEven(17);

        /* ===== */
        System.out.println("\n*** Exercise 4. GIAI PHUONG TRINH BAC MOT: Ax + B = 0.");
        ProgramsOfModuleOne.linearEquationOneVariableSolution(0.0, 0.0);
        ProgramsOfModuleOne.linearEquationOneVariableSolution(0, 1);
        ProgramsOfModuleOne.linearEquationOneVariableSolution(2, 1);

        /* ===== */
        System.out.println("\n*** Exercise 5. TIM UOC SO CHUNG LON NHAT CUA HAI SO (Greatest Common Divisor).");
        ProgramsOfModuleOne.greatestCommonDivisorWithSubtraction(150, 60);
        ProgramsOfModuleOne.greatestCommonDivisorWithRecursive(150, 60);

        /* ===== */
        System.out.println("\n*** Exercise 6. KIEM TRA SO NGUYEN TO.");
        ProgramsOfModuleOne.primeNumber(173);
        ProgramsOfModuleOne.primeNumber(114);

        /* ===== */
        System.out.println("\n*** Exercise 7. TINH TONG CAC SO NGUYEN TO NHO HON SO N.");
        ProgramsOfModuleOne.sumOfPrimeNumberLessThan(10);

        /* ===== */
        System.out.println("\n*** Exercise 8. TINH TONG N SO NGUYEN TO DAU TIEN.");
        ProgramsOfModuleOne.sumOfFirstNNumbersPrimeNumber(5);

        /* ===== */
        System.out.println("\n*** Exercise 9. TIM SO LAN KY TU (CHARACTER) XUAT HIEN TRONG MOT CHUOI (STRING).");
        ProgramsOfModuleOne.countCharacterInString('l',"hello");

        /* ===== */
        System.out.println("\n*** Exercise 10. TACH CHUOI GOC THANH CAC CHUOI CON.");
        ProgramsOfModuleOne.splitStringIntoWords("TACH          CHUOI          GOC       THANH         CAC CHUOI CON");

        /* ===== */
        System.out.println("\n*** Exercise 11. DEM KY TU LA CHU SO (DIGITS) CO TRONG MOT CHUOI. SU DUNG BANG MA ASCII.");
        ProgramsOfModuleOne.countDigitsInString("Nam hai ngan 0 tram 2 muoi 3.");
        /* ===== */
        System.out.println("\n*** Exercise 12. TINH TONG 10 SO CHAN DAU TIEN.");
        ProgramsOfModuleOne.sumFirstNEvenNumbers(10);

        /* ===== */
        System.out.println("\n*** Exercise 13. IN RA SO LE TU A DEN B. VI DU: TU 1 DEN 99.");
        ProgramsOfModuleOne.printOddNumbers(1,33);
        ProgramsOfModuleOne.printOddNumbers(2,30);

        /* ===== */
        System.out.println("\n*** Exercise 14. TINH TONG CAC SO LA BOI SO CUA 7 TRONG PHAM VI TU 1 DEN 100.");
        ProgramsOfModuleOne.printMultipleFromTo(7, 1, 100);

        /* ===== */
        System.out.println("\n*** Exercise 15. TIM GIA TRI LON NHAT VA NHO NHAT TRONG DAY SO.");
        //ProgramsOfModuleOne.findMinMaxFromInput();

        /* ===== */
        System.out.println("\n*** Exercise 16. IN RA MOT GIA TRI SO NGUYEN, XAC DINH SO DO LA SO CHAN, SO LE HAY ZERO.");
        //ProgramsOfModuleOne.printIntegerOddEven();

        /* ===== */
        System.out.println("\n*** Exercise 17. TINH TONG CAC SO LA BOI SO CUA 3 TRONG PHAM VI TU 3 DEN 300.");
        ProgramsOfModuleOne.printMultipleFromTo(3, 3, 300);

        /* ===== */
        System.out.println("\n*** Exercise 18. IN RA N SO DAU TIEN CUA DAY SO FINBONACCI VOI HAI GIA TRI DAU TIEN LA 1 VA 1.");
        ProgramsOfModuleOne.printFibonacci(10);

        /* ===== */
        System.out.println("\n*** Exercise 19. IN RA CAC HINH (DUNG CAU TRUC LAP).");

        /* ===== */
        System.out.println("\n*** Exercise 20. NHAP HAI SO NGUYEN DUONG M VA N, IN RA CAC HINH (DUNG CAU TRUC LAP).");

    }
}
