package main.module_four;

import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 4 *****");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        /* ===== */
        System.out.println("\n*** Exercise 1. QUAN LY NHAN VIEN CHO CONG TY TRUE LOVE.");

        TrueLoveStaff staff1 = new TrueLoveStaff("S001", "Quoc Binh");
        TrueLoveStaff staff2 = new TrueLoveStaff("S002", "Thu Thuy");
        TrueLoveStaff staff3 = new TrueLoveStaff("S003", "Cong Lam");
        TrueLoveStaff staff4 = new TrueLoveStaff("S004", "Quoc Binh");
        TrueLoveStaff staff5 = new TrueLoveStaff("S005", "Hoang Mai");
        TrueLoveStaff staff6 = new TrueLoveStaff("S006", "Hung Thinh");
        TrueLoveStaff staff7 = new TrueLoveStaff("S007", "Mai Huong");
        TrueLoveStaff staff8 = new TrueLoveStaff("S008", "Quoc Binh");
        TrueLoveStaff staff9 = new TrueLoveStaff("S009", "Ngoc Lam");
        TrueLoveStaff staff10 = new TrueLoveStaff("S0010", "Mai Huong");
        TrueLoveStaff staff11 = new TrueLoveStaff("S0011", "Bao Thuan");

        TrueLoveCompany company = new TrueLoveCompany();
        company.add(staff1);
        company.add(staff2);
        company.add(staff3);
        company.add(staff4);
        company.add(staff5);
        company.add(staff6);
        company.add(staff7);
        company.add(staff8);
        company.add(staff9);
        company.add(staff10);

        System.out.println("- Danh sach nhan vien:");
        company.print();
        System.out.println("- Nhan vien duoc chon ngau nhien de nhan qua:");
        company.receivedRandomGiftStaff();
        company.popularProductName();
        System.out.println("- Chon ten cho san pham moi:");
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.randomProductName();
        company.add(staff11);
        company.randomProductName();
        System.out.println("- Dang ki du lich, uu tien dang ki truoc:");
        company.register(staff5);
        company.register(staff8);
        company.register(staff2);
        company.register(staff11);
        company.register(staff7);
        company.printRegisterStaffList();


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
