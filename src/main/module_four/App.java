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
        System.out.println("\n*** Exercise 6. QUAN LY CAC PHONG TAI MOT TRUONG DAI HOC.");
        UniversityRoom room1 = new TheoryRoom("TR001", "A", 105, 10, true);
        UniversityRoom room2 = new TheoryRoom("TR002", "A", 100, 10, true);
        UniversityRoom room3 = new TheoryRoom("TR003", "B", 100, 12, false);
        UniversityRoom room4 = new TheoryRoom("TR004", "B", 100, 11, false);
        UniversityRoom room5 = new TheoryRoom("TR005", "B", 100, 12, true);
        UniversityRoom room6 = new TheoryRoom("TR006", "C", 100, 9, true);
        UniversityRoom room7 = new ComputerRoom("CR001", "A", 100, 10, 67);
        UniversityRoom room8 = new ComputerRoom("CR002", "C", 100, 10, 67);
        UniversityRoom room9 = new ComputerRoom("CR003", "B", 100, 20, 67);
        UniversityRoom room10 = new ComputerRoom("CR004", "B", 100, 9, 70);
        UniversityRoom room11 = new Laboratory("LR001", "B", 100, 12, "Ky thuat may tinh", 10, true);
        UniversityRoom room12 = new Laboratory("LR002", "A", 100, 9, "Cong nghe thong tin", 10, true);
        UniversityRoom room13 = new Laboratory("LR003", "C", 100, 10, "Ky thuat phan mem", 10, false);
        UniversityRoom room14 = new Laboratory("LR004", "C", 100, 11, "Khoa hoc may tinh", 10, true);
        UniversityRoom room15 = new Laboratory("LR005", "A", 100, 20, "Khoa hoc du lieu", 10, false);

        RoomManagement roomManagement = new RoomManagement();
        roomManagement.add(room1);
        roomManagement.add(room2);
        roomManagement.add(room3);
        roomManagement.add(room4);
        roomManagement.add(room5);
        roomManagement.add(room6);
        roomManagement.add(room7);
        roomManagement.add(room8);
        roomManagement.add(room9);
        roomManagement.add(room10);
        roomManagement.add(room11);
        roomManagement.add(room12);
        roomManagement.add(room13);
        roomManagement.add(room14);
        roomManagement.add(room15);

        flag = true;
        roomManagement.runMenu(flag);

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
