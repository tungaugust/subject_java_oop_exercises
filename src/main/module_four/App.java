package main.module_four;

import java.util.Scanner;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 4 *****");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        /* ===== */
        System.out.println("\n*** Exercise 1.");

        /* ===== */
        System.out.println("\n*** Exercise 2. LAM QUEN VOI HashMap.");
        flag = false;
        ProgramsOfModuleFour.inputString(flag);

        /* ===== */
        System.out.println("\n*** Exercise 3. SU DUNG TreeSet.");
        ProgramsOfModuleFour.useTreeSet();

        /* ===== */
        System.out.println("\n*** Exercise 4. SKIP.");

        /* ===== */
        System.out.println("\n*** Exercise 5. SKIP.");

        /* ===== */
        System.out.println("\n*** Exercise 6. ");

        /* ===== */
        System.out.println("\n*** Exercise 7. ");

        /* ===== */
        System.out.println("\n*** Exercise 8. ");

        /* ===== */
        System.out.println("\n*** Exercise 9. KHONG RO YEU CAU.");

        /* ===== */
        System.out.println("\n*** Exercise 10. CHUONG TRINH TRA CUU DANH BA DIEN THOAI CO DINH THEO DIA CHI.");
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Ben Tre", "123001");
        telephoneDirectory.add("Ben Tre", "123002");
        telephoneDirectory.add("Ben", "123005");
        telephoneDirectory.add("Ben Tre", "123001");
        telephoneDirectory.add("Ben", "123006");
        telephoneDirectory.add("Ben Tre", "123003");
        telephoneDirectory.add("Tre", "123001");
        telephoneDirectory.add("Tre", "123002");

        telephoneDirectory.lookUpAddress("Ben TREE");
        telephoneDirectory.lookUpAddress("Ben");
        telephoneDirectory.lookUpPhoneNumber("123000");
        telephoneDirectory.lookUpPhoneNumber("123002");

        /* ===== */
        System.out.println("\n*** Exercise 11. QUAN LY KHACH HANG XEP HANG MUA VE TAI NHA GA.");

    }
}
