package main.module_three;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 3 *****");

        /* ===== */
        System.out.println("\n*** Exercise 1.");

        ChuyenXe chuyenXe1 = new ChuyenXeNoiThanh("XE001", "Nguyen Van A", 101, 1000000.0, 5, 100);
        ChuyenXe chuyenXe2 = new ChuyenXeNoiThanh("XE002", "Nguyen Van B", 102, 1500000.0, 9, 130);
        ChuyenXe chuyenXe3 = new ChuyenXeNgoaiThanh("XE003", "Nguyen Van C", 103, 1200000.0, "D1", 20);
        ChuyenXe chuyenXe4 = new ChuyenXeNgoaiThanh("XE004", "Nguyen Van D", 104, 1700000.0, "D2", 30);
        ArrayList<ChuyenXe> congTyX = new ArrayList<ChuyenXe>();

        congTyX.add(chuyenXe1);
        congTyX.add(chuyenXe2);
        congTyX.add(chuyenXe3);
        congTyX.add(chuyenXe4);

        double sumTotal = 0;
        double sumNoiThanh = 0;
        double sumNgoaiThanh = 0;
        for (ChuyenXe cx: congTyX){
            sumTotal += cx.getRevenue();
            if (cx instanceof ChuyenXeNoiThanh){
                sumNoiThanh += cx.getRevenue();
            }
            if (cx instanceof ChuyenXeNgoaiThanh){
                sumNgoaiThanh += cx.getRevenue();
            }
        }
        System.out.println("- Tong doanh thu cac chuyen xe la " + sumTotal);
        System.out.println("- Tong doanh thu cac chuyen xe noi thanh la " + sumNoiThanh);
        System.out.println("- Tong doanh thu cac chuyen xe ngoai thanh la " + sumNgoaiThanh);

        /* ===== */
        System.out.println("\n*** Exercise 2.");
        Sach sach1 = new SachGiaoKhoa("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", SachGiaoKhoa.NEW);
        Sach sach2 = new SachGiaoKhoa("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", SachGiaoKhoa.NEW);
        Sach sach3 = new SachGiaoKhoa("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", SachGiaoKhoa.NEW);
        Sach sach4 = new SachThamKhao("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", 10000);
        Sach sach5 = new SachThamKhao("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", 10000);
        Sach sach6 = new SachThamKhao("GK001", LocalDate.of(2022,10,10), 50000, 10, "NXB Giao Duc", 10000);



        /* ===== */
        System.out.println("\n*** Exercise 3.");

        /* ===== */
        System.out.println("\n*** Exercise 4.");

        /* ===== */
        System.out.println("\n*** Exercise 5.");

        /* ===== */
        System.out.println("\n*** Exercise 6.");

        /* ===== */
        System.out.println("\n*** Exercise 7.");


        /* ===== */
        System.out.println("\n*** Exercise 8.");





    }
}
