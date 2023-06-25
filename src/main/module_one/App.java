package main.module_one;

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

        /* ===== */
        System.out.println("\n*** Exercise 5. TIM UOC SO CHUNG LON NHAT CUA HAI SO.");

        /* ===== */
        System.out.println("\n*** Exercise 6. KIEM TRA SO NGUYEN TO.");

        /* ===== */
        System.out.println("\n*** Exercise 7. TINH TONG CAC SO NGUYEN TO NHO HON SO N.");

        /* ===== */
        System.out.println("\n*** Exercise 8. TINH TONG N SO NGUYEN TO DAU TIEN.");

        /* ===== */
        System.out.println("\n*** Exercise 9. TIM SO LAN KY TU (CHARACTER) XUAT HIEN TRONG MOT CHUOI (STRING).");

        /* ===== */
        System.out.println("\n*** Exercise 10. TACH CHUOI GOC THANH CAC CHUOI CON.");

        /* ===== */
        System.out.println("\n*** Exercise 11. DEM KY TU LA CHU SO (DIGITAL) CO TRONG MOT CHUOI. SU DUNG BANG MA ASCII.");

        /* ===== */
        System.out.println("\n*** Exercise 12. TINH TONG 10 SO CHAN DAU TIEN.");

        /* ===== */
        System.out.println("\n*** Exercise 13. IN RA SO LE TU A DEN B. VI DU: TU 1 DEN 99.");

        /* ===== */
        System.out.println("\n*** Exercise 14. TINH TONG CAC SO LA BOI SO CUA 7 TRONG PHAM VI TU 1 DEN 100.");

        /* ===== */
        System.out.println("\n*** Exercise 15. TINH TONG CAC SO LA BOI SO CUA 7 TRONG PHAM VI TU 1 DEN 100.");

        /* ===== */
        System.out.println("\n*** Exercise 16. IN RA MOT GIA TRI SO NGUYEN, XAC DINH SO DO LA SO CHAN, SO LE HAY ZERO.");

        /* ===== */
        System.out.println("\n*** Exercise 17. TINH TONG CAC SO LA BOI SO CUA 3 TRONG PHAM VI TU 300 DEN 3.");

        /* ===== */
        System.out.println("\n*** Exercise 18. IN RA N SO DAU TIEN CUA DAY SO FINBONACCI VOI HAI GIA TRI DAU TIEN LA 1 VA 1.");

        /* ===== */
        System.out.println("\n*** Exercise 19. IN RA CAC HINH (DUNG CAU TRUC LAP).");

        /* ===== */
        System.out.println("\n*** Exercise 20. NHAP HAI SO NGUYEN DUONG M VA N, IN RA CAC HINH (DUNG CAU TRUC LAP).");


    }
}
