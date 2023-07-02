package main.module_three;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 3 *****");
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("- Cac giao dich trong thang 9 nam 2013:" );
        for (GiaoDichNhaDat giaoDich: danhSachGiaoDich){
            if (giaoDich.getDate().getYear() == 2013 && giaoDich.getDate().getMonth().getValue() == 9){
                System.out.println(giaoDich);
            }
        }

        /* ===== */
        System.out.println("\n*** Exercise 5. QUAN LY DANH SACH HOA DON TIEN DIEN CUA KHACH HANG.");

        KhachHang khachHang1 = new KhachHangVietNam("VN001","Nguyen Van A", LocalDate.of(2018,9,11), 100, 3000.0, KhachHangVietNam.MANUFACTURE_TYPE, 60);
        KhachHang khachHang2 = new KhachHangVietNam("VN002","Nguyen Van A", LocalDate.of(2018,9,23), 60, 3000.0, KhachHangVietNam.BUSINESS_TYPE, 60);
        KhachHang khachHang3 = new KhachHangVietNam("VN003","Nguyen Van A", LocalDate.of(2018,10,20), 85, 3000.0, KhachHangVietNam.LIVING_TYPE, 60);
        KhachHang khachHang4 = new KhachHangNuocNgoai("FR004","Hong Lee", LocalDate.of(2018,9,17), 110, 3000.0, "Han Quoc");
        KhachHang khachHang5 = new KhachHangNuocNgoai("FR005","Thomas Brown", LocalDate.of(2018,10,1), 45, 3000.0, "Anh Quoc");
        KhachHang khachHang6 = new KhachHangNuocNgoai("FR006","Xian Wang", LocalDate.of(2019,9,10), 90, 3000.0, "Trung Quoc");

        ArrayList<KhachHang> danhSachKhachHang = new ArrayList<KhachHang>();
        danhSachKhachHang.add(khachHang1);
        danhSachKhachHang.add(khachHang2);
        danhSachKhachHang.add(khachHang3);
        danhSachKhachHang.add(khachHang4);
        danhSachKhachHang.add(khachHang5);
        danhSachKhachHang.add(khachHang6);
        int soLuongKHVietNam = 0;
        int soLuongKHNuocNgoai = 0;
        double tongThanhTienKHNuocNgoai = 0;
        for (KhachHang khachHang: danhSachKhachHang){
            if (khachHang instanceof KhachHangVietNam){
                soLuongKHVietNam++;
            }
            if (khachHang instanceof KhachHangNuocNgoai){
                soLuongKHNuocNgoai++;
                tongThanhTienKHNuocNgoai += khachHang.thanhTien();
            }
        }
        System.out.println("- Tong so luong cua khach hang Viet Nam la " + soLuongKHVietNam);
        System.out.println("- Tong so luong cua khach hang nuoc ngoai la " + soLuongKHNuocNgoai);
        System.out.printf("- Trung binh thanh tien cua khach hang nuoc ngoai la %.3f\n tren mot hoa don.", tongThanhTienKHNuocNgoai/soLuongKHNuocNgoai);
        System.out.println("- Cac hoa don trong thang 9 nam 2018:" );
        for (KhachHang khachHang: danhSachKhachHang){
            if (khachHang.getDate().getYear() == 2018 && khachHang.getDate().getMonth().getValue() == 9){
                System.out.println(khachHang);
            }
        }

        /* ===== */
        System.out.println("\n*** Exercise 6. QUAN LY HOA DON CHO THUE PHONG.");
        Bill bill1 = new HourlyBill("HB001", LocalDate.of(2023, 10, 5), "Nguyen Van A", "R001X", 100000.0, 12);
        Bill bill2 = new HourlyBill("HB002", LocalDate.of(2023, 9, 5), "Nguyen Van B", "R001Y", 100000.0, 5);
        Bill bill3 = new HourlyBill("HB003", LocalDate.of(2023, 10, 5), "Nguyen Van C", "R001Z", 100000.0, 27);
        Bill bill4 = new DailyBill("DB004", LocalDate.of(2023, 10, 5), "Nguyen Van D", "R001A", 500000.0, 3);
        Bill bill5 = new DailyBill("DB005", LocalDate.of(2022, 9, 6), "Nguyen Van E", "R001Z", 500000.0, 6);
        Bill bill6 = new DailyBill("DB006", LocalDate.of(2023, 10, 5), "Nguyen Van F", "R001B", 500000.0, 2);

        BillManager billManager = new BillManager();
        billManager.add(bill1);
        billManager.add(bill2);
        billManager.add(bill3);
        billManager.add(bill4);
        billManager.add(bill5);
        billManager.add(bill6);

        int opt = 0;
        boolean flag = false;
        while (flag){
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t1. In so luong cac hoa don co trong danh sach theo tung loai va tong so luong.");
            System.out.println("\t2. Nhap mot hoa don vao danh sach hoa don.");
            System.out.println("\t3. Xuat toan bo danh sach hoa don theo thang, nam.");
            System.out.println("--------------------------");
            System.out.print("\nNhap tuy chon [ 1 - 3 ]: ");

            opt = Integer.valueOf(scanner.nextLine().trim());

            System.out.println();
            int year, month, day, amount;
            double price;
            String billCode, roomCode, customer, type;
            LocalDate date;
            switch (opt){
                case 1:
                    System.out.println("So luong hoa don theo gio: " + billManager.hourlyBillCount());
                    System.out.println("So luong hoa don theo ngay: " + billManager.dailyBillCount());
                    System.out.println("Tong so luong hoa don: " + billManager.getCount());
                    break;
                case 2:
                    System.out.print("Nhap loai hoa don [h - hourly (mac dinh theo gio), d - daily]: ");
                    type = String.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap ma hoa don: ");
                    billCode = String.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap nam: ");
                    year = Integer.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap thang: ");
                    month = Integer.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap ngay: ");
                    day = Integer.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap ten khach hang: ");
                    customer = String.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap ma phong: ");
                    roomCode = String.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap don gia: ");
                    price = Double.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap so luong: ");
                    amount = Integer.valueOf(scanner.nextLine().trim());
                    Bill newBill;
                    if(type.equals("h")){
                        newBill = new HourlyBill(billCode, LocalDate.of(year, month, day), customer, roomCode, price, amount);
                    } else {
                        newBill = new DailyBill(billCode, LocalDate.of(year, month, day), customer, roomCode, price, amount);
                    }
                    if (billManager.add(newBill)){
                        System.out.println("Them hoa don thanh cong.");
                    } else {
                        System.out.println("Them hoa don that bai.");
                    }
                    break;
                case 3:
                    System.out.print("Nhap nam: ");
                    year = Integer.valueOf(scanner.nextLine().trim());
                    System.out.print("Nhap thang: ");
                    month = Integer.valueOf(scanner.nextLine().trim());
                    billManager.printer(month, year);
                    break;
                default:
                    System.out.println("Dung MENU.");
                    flag = false;
                    break;
            }
        }

        /* ===== */
        System.out.println("\n*** Exercise 7.");


        /* ===== */
        System.out.println("\n*** Exercise 8.");

        /* ===== */
        System.out.println("\n*** Exercise 9. DA HINH, VE HINH");

        Drawing drawing = new Drawing();
        drawing.drawShape(new Triangle());
        drawing.drawShape(new Rectangle());
        drawing.drawShape(new Quad());
        drawing.drawShape(new Polygon());
        drawing.drawShape(new Circle());

        /* ===== */
        System.out.println("\n*** Exercise 10. XAY DUNG CAC LOP VE LOAI XE.");

        Vehicle vehicle1 = new Car("Ford Everest", "Ford", "FE2304", 2023,"Nguyen Van A", 1500000000.0, 7);
        Vehicle vehicle2 = new Car("Mitsubishi Pajero Sport", "Mitsubishi", "MBPS23", 2023,"Nguyen Van B", 1100000000.0, 4);
        Vehicle vehicle3 = new Truck("Hyundai New Mighty N250", "Hyundai", "N250SL", 2019,"Nguyen Van C", 480000000.0);
        Vehicle vehicle4 = new Bike("Asama RAINBOW", "Asama", "RA2701", 2020,"Nguyen Van D", 4200000.0);
        Vehicle vehicle5 = new Motorbike("Honda Vision", "Honda", "HV2306", 2023,"Nguyen Van E", 35000000.0);

        System.out.println(Vehicle.headerLine());
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(vehicle3);
        System.out.println(vehicle4);
        System.out.println(vehicle5);

        /* ===== */
        System.out.println("\n*** Exercise 11. XAY DUNG CAC LOP VE CAC SINH VIEN, HOC SINH CUA CAC CAP BAC CUA MOT TRUON DAI HOC.");

        Student student1 = new UniversityStudent("20811114","Nguyen Van Long","Nam", LocalDate.of(2000,10,9), "Vinh Phuc" ,"Ky thuat phan mem", "Cong nghe thong tin", 2018);
        Student student2 = new CollegeStudent("20810119","Hoang Thanh Tam","Nu", LocalDate.of(2001,8,10), "Long An" ,"Ky thuat phan mem", "Cong nghe thong tin", 2019);
        Student student3 = new IntermediateStudent("20800006","Pham Toan Thang","Nam", LocalDate.of(2000,5,20), "Tien Giang" ,"Ky thuat phan mem", "Cong nghe thong tin", 2018);
        Student student4 = new ExchangeStudent("20819067","Ho Bao Ngoc","Nu", LocalDate.of(2001,1,15), "Ca Mau" ,"Ky thuat phan mem", "Cong nghe thong tin", 2019);

        StudentManager studentManager = new StudentManager();
        studentManager.add(student1);
        studentManager.add(student2);
        studentManager.add(student3);
        studentManager.add(student4);

        System.out.printf("- Danh sach co %d sinh vien:\n", studentManager.getSize());
        studentManager.printAll();

        studentManager.remove("20800006");
        System.out.printf("- Danh sach con %d sinh vien, sau khi xoa sinh vien co ma so la 20800006:\n", studentManager.getSize());
        studentManager.printAll();

    }
}
