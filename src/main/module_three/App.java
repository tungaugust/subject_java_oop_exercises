package main.module_three;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 3 *****");

        /* ===== */
        System.out.println("\n*** Exercise 1. QUAN LY CHUYEN XE.");

        ChuyenXe chuyenXe1 = new ChuyenXeNoiThanh("XE001", "Nguyen Van A", 101, 1000000.0, 5, 100);
        ChuyenXe chuyenXe2 = new ChuyenXeNoiThanh("XE002", "Nguyen Van B", 102, 1500000.0, 9, 130);
        ChuyenXe chuyenXe3 = new ChuyenXeNgoaiThanh("XE003", "Nguyen Van C", 103, 1200000.0, "D1", 20);
        ChuyenXe chuyenXe4 = new ChuyenXeNgoaiThanh("XE004", "Nguyen Van D", 104, 1700000.0, "D2", 30);

        ArrayList<ChuyenXe> congTyX = new ArrayList<ChuyenXe>();
        congTyX.add(chuyenXe1);
        congTyX.add(chuyenXe2);
        congTyX.add(chuyenXe3);
        congTyX.add(chuyenXe4);

        double tongDoanhThu = 0;
        double tongDoanhThuNoiThanh = 0;
        double tongDoanhThuNgoaiThanh = 0;
        for (ChuyenXe cx: congTyX){
            tongDoanhThu += cx.getRevenue();
            if (cx instanceof ChuyenXeNoiThanh){
                tongDoanhThuNoiThanh += cx.getRevenue();
            }
            if (cx instanceof ChuyenXeNgoaiThanh){
                tongDoanhThuNgoaiThanh += cx.getRevenue();
            }
        }
        System.out.println("- Tong doanh thu cac chuyen xe la " + tongDoanhThu);
        System.out.println("- Tong doanh thu cac chuyen xe noi thanh la " + tongDoanhThuNoiThanh);
        System.out.println("- Tong doanh thu cac chuyen xe ngoai thanh la " + tongDoanhThuNgoaiThanh);

        /* ===== */
        System.out.println("\n*** Exercise 2. QUAN LY SACH.");

        Sach sach1 = new SachGiaoKhoa("GK001", LocalDate.of(2022,10,10), 50000, 5, "NXB Giao Duc", SachGiaoKhoa.NEW);
        Sach sach2 = new SachGiaoKhoa("GK002", LocalDate.of(2022,9,10), 45000, 10, "NXB Canh Dieu", SachGiaoKhoa.OLD);
        Sach sach3 = new SachGiaoKhoa("GK003", LocalDate.of(2022,8,10), 70000, 8, "NXB Giao Duc", SachGiaoKhoa.NEW);
        Sach sach4 = new SachThamKhao("TK004", LocalDate.of(2022,7,10), 60000, 9, "NXB Kim Dong", 5000);
        Sach sach5 = new SachThamKhao("TK005", LocalDate.of(2022,6,10), 80000, 6, "NXB Giao Duc", 5000);
        Sach sach6 = new SachThamKhao("TK006", LocalDate.of(2022,5,10), 20000, 20, "NXB Tuoi Tre", 5000);

        ArrayList<Sach> danhSachSach = new ArrayList<Sach>();
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);
        danhSachSach.add(sach4);
        danhSachSach.add(sach5);
        danhSachSach.add(sach6);

        double tongThanhTienSachGK = 0;
        double tongThanhTienSachTK = 0;
        double tongDonGiaSachTK = 0;
        int soLuongSachTK = 0;
        for (Sach sach: danhSachSach){
            if (sach instanceof SachGiaoKhoa){
                tongThanhTienSachGK += sach.thanhTien();
                tongDonGiaSachTK += sach.getPrice();
                soLuongSachTK++;
            }
            if (sach instanceof SachThamKhao){
                tongThanhTienSachTK += sach.thanhTien();
            }
        }
        System.out.println("- Tong thanh tien cua sach giao khoa la " + tongThanhTienSachGK);
        System.out.println("- Tong thanh tien cua sach tham khao la " + tongThanhTienSachTK);
        System.out.println("- Trung binh cong don gia cua sach tham khao la " + tongDonGiaSachTK/soLuongSachTK);

        String nxb = "NXB Giao Duc";
        System.out.println("- Cac sach giao khoa cua " +  nxb + ":");
        for (Sach sach: danhSachSach){
            if (sach instanceof SachGiaoKhoa && sach.getPublisher().equals(nxb)){
                System.out.println(sach);
            }
        }

        /* ===== */
        System.out.println("\n*** Exercise 3. QUAN LY GIAO DICH.");

        Transaction transaction1 = new GoldTransaction("GOL001", LocalDate.of(2022,10,10), 67000000, 20, "Gold Bar");
        Transaction transaction2 = new GoldTransaction("GOL002", LocalDate.of(2022,10,10), 67000000, 10, "Gold Bar");
        Transaction transaction3 = new GoldTransaction("GOL003", LocalDate.of(2022,10,10), 67000000, 15, "Gold Bar");
        Transaction transaction4 = new CurrencyTransaction("CUR004", LocalDate.of(2022,10,10), 23500, 20,
                CurrencyTransaction.USD_TYPE, 1.003);
        Transaction transaction5 = new CurrencyTransaction("CUR004", LocalDate.of(2022,10,10), 25700, 20,
                CurrencyTransaction.EUR_TYPE, 1.003);
        Transaction transaction6 = new CurrencyTransaction("CUR004", LocalDate.of(2022,10,10), 500000, 20,
                CurrencyTransaction.VND_TYPE, 1.003);

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);


        int goldCount = 0;
        int currencyCount = 0;
        double currencyTotal = 0;
        int currencyQuantityTotal = 0;
        for (Transaction transaction: transactions){
            if (transaction instanceof GoldTransaction){
                goldCount++;
            }
            if (transaction instanceof CurrencyTransaction){
                currencyCount++;
                currencyTotal += transaction.thanhTien();
                currencyQuantityTotal += transaction.getQuantity();
            }
        }
        System.out.println("- Tong so luong cua giao dich vang mieng la " + goldCount);
        System.out.println("- Tong so luong cua giao dich tien te la " + currencyCount);
        System.out.printf("- Trung binh thanh tien cua giao dich tien te la %.3f\n", currencyTotal/currencyQuantityTotal);
        System.out.println("- Cac gia dich co tong don gia (thanh tien) tren 1 ty:");
        for (Transaction transaction: transactions){
            if (transaction.thanhTien() > 1000000000.0){
                System.out.println(transaction);
            }
        }

        /* ===== */
        System.out.println("\n*** Exercise 4. QUAN LY GIAO DICH NHA DAT.");

        GiaoDichNhaDat giaoDich1 = new GiaoDichDat("DAT001", LocalDate.of(2013,10,11), 60000000.0, GiaoDichDat.A_TYPE, 200);
        GiaoDichNhaDat giaoDich2 = new GiaoDichDat("DAT002", LocalDate.of(2013,9,10), 45000000.0, GiaoDichDat.B_TYPE, 450);
        GiaoDichNhaDat giaoDich3 = new GiaoDichDat("DAT003", LocalDate.of(2013,10,10), 50000000.0, GiaoDichDat.C_TYPE, 300);
        GiaoDichNhaDat giaoDich4 = new GiaoDichNha("NHA004", LocalDate.of(2013,9,15), 100000000.0, GiaoDichNha.REGULAR_TYPE, 250, "03, Hoang Hoa Tham");
        GiaoDichNhaDat giaoDich5 = new GiaoDichNha("NHA005", LocalDate.of(2013,9,10), 150000000.0, GiaoDichNha.LUXURY_TYPE, 500, "100A, Ly Tu Trong");
        GiaoDichNhaDat giaoDich6 = new GiaoDichNha("NHA006", LocalDate.of(2013,10,12), 95000000.0, GiaoDichNha.REGULAR_TYPE, 350, "99, Cach Mang Thang Tam");

        ArrayList<GiaoDichNhaDat> danhSachGiaoDich = new ArrayList<GiaoDichNhaDat>();
        danhSachGiaoDich.add(giaoDich1);
        danhSachGiaoDich.add(giaoDich2);
        danhSachGiaoDich.add(giaoDich3);
        danhSachGiaoDich.add(giaoDich4);
        danhSachGiaoDich.add(giaoDich5);
        danhSachGiaoDich.add(giaoDich6);
        int soLuongGDDat = 0;
        int soLuongGDNha = 0;
        double tongThanhTienGDDat = 0;
        int tongDienTichGDDat = 0;
        for (GiaoDichNhaDat giaoDich: danhSachGiaoDich){
            if (giaoDich instanceof GiaoDichDat){
                soLuongGDDat++;
                tongThanhTienGDDat += giaoDich.thanhTien();
                tongDienTichGDDat += giaoDich.getArea();
            }
            if (giaoDich instanceof GiaoDichNha){
                soLuongGDNha++;
            }
        }

        System.out.println("- Tong so luong cua giao dich dat la " + soLuongGDDat );
        System.out.println("- Tong so luong cua giao dich nha la " + soLuongGDNha);
        System.out.printf("- Trung binh thanh tien cua giao dich dat la %.3f\n tren mot met vuong.", tongThanhTienGDDat/tongDienTichGDDat);
        System.out.println("- Cac giao dich cua thang 9 nam 2013:" );
        for (GiaoDichNhaDat giaoDich: danhSachGiaoDich){
            if (giaoDich.getDate().getYear() == 2013 && giaoDich.getDate().getMonth().getValue() == 9){
                System.out.println(giaoDich);
            }
        }

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
