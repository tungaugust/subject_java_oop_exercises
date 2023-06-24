package main.module_two;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class App {
    public static void run(String[] args) {
        System.out.println("***** Module 2 *****");
        String headerLine;

        /* ===== */
        System.out.println("\n*** Exercise 1.");
        Point pointA = new Point();
        Point pointB = new Point("B", 1.2, -6.7);
        System.out.println("Toa do A: " + pointA);
        System.out.println("Toa do B: " + pointB);

        /* ===== */
        System.out.println("\n*** Exercise 2.");
        Student sv1 = new Student(11111, "Nguyen Thanh An", 6.5, 8.5);
        Student sv2 = new Student(22222, "Le Thi Bong", 7.5, 8.0);


        Student sv3 = new Student(33333, "Nguyen Hoang Anh", 5.0, 9.0);
        // Nhap thong tin cho sv3: MaSV=33333, HoVaTen="Nguyen Hoang Anh", DiemLT= 5.0, DiemTH=9.0
//        Student sv3 = new Student();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap ma so sv3: ");
//        long sv3Code = Long.parseLong(sc.nextLine());
//        System.out.print("Nhap ho va ten sv3: ");
//        String sv3Name = sc.nextLine();
//        System.out.print("Nhap diem LT sv3: ");
//        double sv3Theory = Double.parseDouble(sc.nextLine());
//        System.out.print("Nhap diem TH sv3: ");
//        double sv3Exp = Double.parseDouble(sc.nextLine());
//        sv3.setCode(sv3Code);
//        sv3.setFullName(sv3Name);
//        sv3.setTheoryMark(sv3Theory);
//        sv3.setExperimentMark(sv3Exp);

        headerLine = String.format("%-10s %-30s %20s %20s %20s"
                , "MA SV", "HO VA TEN", "DIEM LT", "DIEM TH", "DIEM TB"
        );
        System.out.println(headerLine);
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        /* ===== */
        System.out.println("\n*** Exercise 3.");
        Triangle tg1 = new Triangle(0, 1, 5);
        Triangle tg2 = new Triangle(5, 4, -1);
        Triangle tg3 = new Triangle(3, 4, 5);
        Triangle tg4 = new Triangle(5, 3, 5);
        Triangle tg5 = new Triangle(5, 5, 5);

        headerLine = String.format("%10s %10s %10s %-20s %10s %10s"
                , "CANH A", "CANH B", "CANH C", "LOAI", "CHU VI", "DIEN TICH"
        );
        System.out.println(headerLine);
        System.out.println(tg1);
        System.out.println(tg2);
        System.out.println(tg3);
        System.out.println(tg4);
        System.out.println(tg5);

        /* ===== */
        System.out.println("\n*** Exercise 4: THEO DOI DANG KY XE CUA NGUOI DAN.");
        Vehicle xe1 = new Vehicle("Nguyen Thu Loan", "Future Neo", 35000000.0, 100);
        Vehicle xe2 = new Vehicle("Le Minh Tinh ", "Ford Ranger", 250000000.0, 3000);
        Vehicle xe3 = new Vehicle("Nguyen Minh Triet", "Landcape", 1000000000.0, 1500);

        headerLine = String.format("%-30s %-20s %15s %20s %20s"
                , "TEN CHU XE", "LOAI XE", "DUNG TICH", "TRI GIA", "THUE PHAI NOP"
        );
        System.out.println(headerLine);
        System.out.println(xe1.record());
        System.out.println(xe2.record());
        System.out.println(xe3.record());

        /* ===== */
        System.out.println("\n*** Exercise 5. MO TA MOT LOP HANG HOA TRONG KHO LUU TRU THUC PHAM."
                + "\nUsing Classes: LocalDate, DecimalFormat, DateTimeFormatter"
        );
        FoodProduct foodProduct1 = new FoodProduct("001", "Gao", 100000.0
                , LocalDate.of(2018, 7, 10)
                , LocalDate.of(2018, 7, 10));
        FoodProduct foodProduct2 = new FoodProduct("002", "Mi", 5000.0
                , LocalDate.of(2018, 3, 1)
                , LocalDate.of(2018, 9, 10));
        FoodProduct foodProduct3 = new FoodProduct("003", "Nuoc", 10000.0
                , LocalDate.of(2017, 3, 1)
                , LocalDate.of(2018, 3, 1));
        headerLine = String.format("%-15s %-20s %30s %20s %20s %25s"
                , "MA HANG", "TEN HANG", "DON GIA", "NGAY SAN XUAT", "NGAY HET HAN", "GHI CHU"
        );
        System.out.println(headerLine);
        System.out.println(foodProduct1);
        System.out.println(foodProduct2);
        System.out.println(foodProduct3);

        /* ===== */
        System.out.println("\n*** Exercise 6. XAY DUNG LOP CO QUAN HE KET TAP (AGGREGATION).");
        // Khi xây dựng lớp, trường hợp các thuộc tính của một lớp là những đối tượng của một lớp khác.
        // Hiện tượng đó gọi là kết tập (aggregation) trong Java
        Account acc1 = new Account(72354, "Ted Murphy", 102.56);
        Account acc2 = new Account(69713, "Jane Smith", 40.0);
        Account acc3 = new Account(93757, "Edward Demsey", 759.32);

        acc1.deposit(25.85);
        acc2.deposit(500.0);
        acc2.withdraw(430.75, 1.5);
        System.out.println("Tien lai cua acc3: " + acc3.addInterest());
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        acc2.transfer(acc1, 100.0);
        System.out.println(acc1);
        System.out.println(acc2);

        /* ===== */
        System.out.println("\n*** Exercise 7.");
        Point tam = new Point("O", 5, 5);
        double banKinh = 10.5;
        Circle hinhTron = new Circle(tam, banKinh);
        System.out.println(String.format("Hinh tron co tam %s voi ban kinh %.2f co dien tich va chu vi lan luot la %.3f va %.3f"
                , tam, banKinh, hinhTron.perimeter(), hinhTron.surfaceArea()
        ));

        /* ===== */
        System.out.println("\n*** Exercise 8.");
        CD cd1 = new CD(99, "Album D", 4, 30.0);
        CD cd2 = new CD(100, "Album B", 3, 50.0);
        CD cd3 = new CD(101, "Album C", 5, 20.0);
        CD cd4 = new CD(102, "Album K", 2, 50.0);
        CD cd5 = new CD(103, "Album A", 5, 40.0);
        CD cd6 = new CD(104, "Album F", 8, 10.0);
        int capacity = 5;
        CDList cdList = new CDList(capacity);
        cdList.add(cd1);
        cdList.add(cd2);
        cdList.add(cd3);
        cdList.add(cd4);
        cdList.add(cd5);
        cdList.add(cd6);
        System.out.println("So luong CD trong danh sach: " + cdList.getSize());
        System.out.println("Tong gia thanh cua cac CD: " + cdList.priceTotal());
        System.out.println("Danh sach tat ca CD:");
        cdList.printCDList();
        System.out.println("Sap xep theo ten tang dan:");
        cdList.sortAscendingTitle();
        cdList.printCDList();
        System.out.println("Sap xep theo gia giam dan:");
        cdList.sortDescendingPrice();
        cdList.printCDList();

        /* ===== */
        System.out.println("\n*** Exercise 9.");
        Worker congNhan1 = new Worker();
        Worker congNhan2 = new Worker(95, "A", "Nguyen Van", 410);
        Worker congNhan3 = new Worker(80, "B", "Nguyen Van", 200);
        Worker congNhan4 = new Worker(70, "C", "Nguyen Van", 190);
        Worker congNhan5 = new Worker(100, "D", "Nguyen Van", 250);
        Worker congNhan6 = new Worker(100, "F", "Nguyen Van", 1000);
        capacity = 5;
        WorkerList workerList = new WorkerList();
        workerList.setCapacity(capacity);
        workerList.add(congNhan1);
        workerList.add(congNhan2);
        workerList.add(congNhan3);
        workerList.add(congNhan4);
        workerList.add(congNhan5);
        workerList.add(congNhan6);
        System.out.println("So luong cong nhan co trong danh sach: " + workerList.getSize() + " " + workerList.getCapacity());
        System.out.println("Danh sach tat ca cong nhan:");
        workerList.printWorkerList();
        System.out.println("Danh sach tat ca cong nhan co so san pham lon hon 200:");
        workerList.printWorkerList(200, 1);
        System.out.println("Sap xep theo so san pham giam dan");
        workerList.sortDescendingProduct();
        workerList.printWorkerList();


        /* ===== */
        System.out.println("\n*** Exercise 10. XAY DUNG LOP CO QUAN HE HOP THANH (COMPOSITION).");
        Product product1 = new Product("sp4", "Nuoc tuong", 8000);
        Product product2 = new Product("sp1", "Gao", 18000);
        Product product3 = new Product("sp3", "Duong", 10000);
        Order order = new Order(1, LocalDate.of(2015, 9, 10));
        order.addLineItem(product1, 10);
        order.addLineItem(product2, 5);
        order.addLineItem(product3, 1);
        order.addLineItem(product2, 1);
        headerLine = String.format("%-5s | %-10s | %-20s | %15s | %15s | %20s"
                , "STT", "MA SP", "MO TA", "DON GIA", "SO LUONG", "THANH TIEN"
        );
        System.out.println("Ma HD: " + order.getOrderID());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String orderDay = order.getOrderDate().format(dtf);
        System.out.println("Ngay lap hoa don: " + orderDay);
        System.out.println(headerLine);
        System.out.println(order);
        DecimalFormat df = new DecimalFormat("#,##0");
        String totalCharge = df.format(order.calcTotalCharge()) + " VND" ;
        System.out.println("Tong tien thanh toan: " + totalCharge);

        /* ===== */
        System.out.println("\n*** Exercise 11. XAY DUNG LOP HocVien (KEM XAY DUNG LOP MonHoc).");
        HocVien hocVien1 = new HocVien("Nguyen Van A", 1990, 6, 5, 9, 5, 7);
        HocVien hocVien2 = new HocVien("Nguyen Van B", 1996, 6, 5, 4, 5, 7);
        HocVien hocVien3 = new HocVien("Nguyen Van C", 1993, 9, 5, 9, 8, 7);
        System.out.println(hocVien1);
        System.out.println(hocVien2);
        System.out.println(hocVien3);


        /* ===== */
        System.out.println("\n*** Exercise 12. XAY DUNG CAC LOP QUAN LY KHOA HOC VA HOC VIEN: Course, CStudent.");
        CStudent student1 = new CStudent("Nguyen Van A", "Ben Tre", "0123-456-789");
        CStudent student2 = new CStudent("Nguyen Van B", "Ho Chi Minh", "1123-456-789");
        CStudent student3 = new CStudent("Nguyen Van C", "Kien Giang", "2123-456-789");
        Course course1 = new Course("Lap trinh Java", LocalDate.of(2023,6,20), 3);
        Course course2 = new Course("Lap trinh Python", LocalDate.of(2023,2,20), 1);
        Course course3 = new Course("Lap trinh C++", LocalDate.of(2023,7,20), 2);
        course1.add(student1);
        course1.add(student2);
        course1.add(student3);
        System.out.println(course1);
        System.out.println(course2);

        ArrayList<Course> manager = new ArrayList<Course>();
        manager.add(course1);
        manager.add(course2);
        manager.add(course3);

        System.out.println("Cac khoa hoc chua bat dau:");
        for(Course course: manager){
            if (course.getOpenDay().isAfter(LocalDate.now())){
                System.out.println("+ Khoa hoc '" + course.getName() + "'");
            }
        }
        System.out.println("Cac khoa hoc chua ket thuc:");
        for(Course course: manager){
            if (!course.getCloseDay().isAfter(LocalDate.now())){
                System.out.println("+ Khoa hoc '" + course.getName() + "'");
            }
        }
    }
}
