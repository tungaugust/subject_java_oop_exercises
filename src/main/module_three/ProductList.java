package main.module_three;

import main.module_two.CD;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProductList {
    private ArrayList<Product> productList;
    public final static String ALL_PRODUCTS = "all products";
    public final static String FOOD_PRODUCT = "food product";
    public final static String CROCKERY_PRODUCT = "crockery product";
    public final static String ELECTRIC_PRODUCT = "electric product";

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    private void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ProductList() {
        setProductList(new ArrayList<>());
    }

    // Cac phuong thuc ho tro:
    // size(), indexOf(), contain(),
    // convertToVND(), convertToFormattedDate(), convertStringToLocalDate()
    // repeatString()
    public int size(){
        return this.getProductList().size();
    }
    public <T> int indexOf(T product){
        if (product instanceof String){
            String productCode = (String) product;
            for (int i = 0; i < this.size(); i++){
                if (this.getProductList().get(i).getCode().equals(productCode)) {
                    return i;
                }
            }
        }
        if (product instanceof Product){
            Product productInstance = (Product) product;
            for (int i = 0; i < this.size(); i++){
                if (this.getProductList().get(i).getCode().equals(productInstance.getCode())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public <T> boolean contain(T product){
        if (this.indexOf(product) < 0){
            return false;
        }
        return true;
    }
    public String convertToVND(double amount){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00 VND");
        return decimalFormat.format(amount);
    }
    public String convertLocalDateToString(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(dateTimeFormatter);
    }
    public LocalDate convertStringToLocalDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }
    public String repeatString(String target, int count){
        String separator = "";
        return String.join(separator, Collections.nCopies(count, target));
    }
    public String repeatString(String target, int count, String separator){
        return String.join(separator, Collections.nCopies(count, target));
    }
    // Cac phuong thuc yeu cau:
    // add(), remove(), find(), fixProductPrice(),
    // sortAscendingProductName(), sortDescendingStoredQuantity()
    public boolean add(Product product){
        if (this.contain(product)) {
            return false;
        }
        this.getProductList().add(product);
        return true;
    }
    public boolean remove(String productCode) {
        int pos = this.indexOf(productCode);
        if (pos < 0){
            return false;
        }
        this.getProductList().remove(pos);
        return true;
    }
    public Product find(String productCode){
        int pos = this.indexOf(productCode);
        if (pos < 0){
            return null;
        }
        return this.getProductList().get(pos);
    }

    public boolean fixProductPrice(String productCode, double newPrice) {
        int pos = this.indexOf(productCode);
        if (pos < 0){
            return false;
        }
        this.getProductList().get(pos).setPrice(newPrice);
        return false;
    }

    public void sortAscendingProductName(){
        // CACH 1: Su dung Collections.sort()
        Collections.sort(this.getProductList(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int compareResult = o1.getName().compareTo(o2.getName());
                if (compareResult > 0){
                    return 1;
                }
                else if (compareResult < 0){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        // CACH 2: Su dung for-loop va Collections.swap()
//        ArrayList<Product> productArrayList = this.getProductList();
//        for (int i = 0; i < this.size() - 1; i++) {
//            for (int j = i + 1; j < this.size(); j++) {
//                int compareResult = productArrayList.get(i).getName().compareTo(productArrayList.get(j).getName());
//                if (compareResult > 0) {
//                    Collections.swap(productArrayList, i, j);
//                }
//            }
//        }

        // CACH 3: Su dung for-loop va phuong thuc set()
//        ArrayList<Product> productArrayList = this.getProductList();
//        for (int i = 0; i < this.size() - 1; i++) {
//            for (int j = i + 1; j < this.size(); j++) {
//                int compareResult = productArrayList.get(i).getName().compareTo(productArrayList.get(j).getName());
//                if (compareResult > 0) {
//                    Product temp = productArrayList.get(i);
//                    productArrayList.set(i, productArrayList.get(j));
//                    productArrayList.set(j, temp);
//                }
//            }
//        }
    }

    public void sortDescendingStoredQuantity(){
        Collections.sort(this.getProductList(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getStoredQuantity() < o2.getStoredQuantity()){
                    return 1;
                }
                else if (o1.getStoredQuantity() > o2.getStoredQuantity()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
    }

    // Cac phuong thuc cho viec xuat (in ra man hinh):
    // printProductHeaderLine()
    // print()
    public void printProductHeaderLine(String productType){
        System.out.println(this.productHeaderLine(productType));
    }
    public String productHeaderLine(String productType){
        String headerLine = "";
        int lineLength = 0;
        switch (productType){
            case ALL_PRODUCTS:
                headerLine = String.format("%-10s | %-15s | %15s | %15s | %-25s"
                        , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "DANH GIA MUC DO BAN BUON"
                );
                lineLength = 46; //92
                break;
            case FOOD_PRODUCT:
                headerLine = headerLine = String.format("%-10s | %-15s | %15s | %15s | %-15s | %15s | %15s | %-25s"
                        , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "NHA CUNG CAP", "NGAY SAN XUAT", "NGAY HET HAN", "DANH GIA MUC DO BAN BUON"
                );
                lineLength = 73;
                break;
            case CROCKERY_PRODUCT:
                headerLine = String.format("%-10s | %-15s | %15s | %15s | %-15s | %15s | %-25s"
                        , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "NHA SAN XUAT", "NGAY NHAP KHO", "DANH GIA MUC DO BAN BUON"
                );
                lineLength = 64;
                break;
            case ELECTRIC_PRODUCT:
                headerLine = String.format("%-10s | %-15s | %15s | %15s | %30s | %15s | %-25s"
                        , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "THOI GIAN BAN HANH (THANG)", "CONG SUAT", "DANH GIA MUC DO BAN BUON"
                );
                lineLength = 71;
                break;
            default:
                return headerLine;
        }
        return this.repeatString("-", lineLength, " ")
                + "\n" + headerLine + "\n"
                + this.repeatString("-", lineLength, " ");
    }

    public void print(){
        this.printFor(ALL_PRODUCTS);
    }
    public void printFor(String productType){
        System.out.println(this.productHeaderLine(productType));
        switch (productType){
            case ALL_PRODUCTS:
                for (Product product: this.getProductList()){
                    System.out.println(String.format("%-10s | %-15s | %15s | %15d | %-25s"
                            , product.getCode()
                            , product.getName()
                            , this.convertToVND(product.getPrice())
                            , product.getStoredQuantity()
                            , product.salesRating()
                    ));
                }
                break;
            case FOOD_PRODUCT:
                for (Product product: this.getProductList()){
                    if (product instanceof FoodProduct){
                        System.out.println(this.productToString((FoodProduct) product));
                    }
                }
                break;
            case CROCKERY_PRODUCT:
                for (Product product: this.getProductList()){
                    if (product instanceof CrockeryProduct){
                        System.out.println(this.productToString((CrockeryProduct) product));
                    }
                }
                break;
            case ELECTRIC_PRODUCT:
                for (Product product: this.getProductList()){
                    if (product instanceof ElectricProduct){
                        System.out.println(this.productToString((ElectricProduct) product));
                    }
                }
                break;
            default:
                return;
        }
    }
    public String productToString(Product product){
        if (product instanceof FoodProduct) {
            FoodProduct foodProduct = (FoodProduct) product;
            return String.format("%-10s | %-15s | %15s | %15d | %-15s | %15s | %15s | %-25s"
                    , foodProduct.getCode()
                    , foodProduct.getName()
                    , this.convertToVND(foodProduct.getPrice())
                    , foodProduct.getStoredQuantity()
                    , foodProduct.getSupplier()
                    , this.convertLocalDateToString(foodProduct.getManufactureDate())
                    , this.convertLocalDateToString(foodProduct.getExpirationDate())
                    , foodProduct.salesRating()
            );
        }
        if (product instanceof CrockeryProduct) {
            CrockeryProduct crockeryProduct = (CrockeryProduct) product;
            return String.format("%-10s | %-15s | %15s | %15d | %-15s | %15s | %-25s"
                    , crockeryProduct.getCode()
                    , crockeryProduct.getName()
                    , this.convertToVND(crockeryProduct.getPrice())
                    , crockeryProduct.getStoredQuantity()
                    , crockeryProduct.getManufacturer()
                    , this.convertLocalDateToString(crockeryProduct.getWarehouseDate())
                    , crockeryProduct.salesRating()
            );
        }
        if (product instanceof ElectricProduct) {
            ElectricProduct electricProduct = (ElectricProduct) product;
            return String.format("%-10s | %-15s | %15s | %15d | %30d | %15d | %-25s"
                    , electricProduct.getCode()
                    , electricProduct.getName()
                    , this.convertToVND(electricProduct.getPrice())
                    , product.getStoredQuantity()
                    , electricProduct.getWarrantyTime()
                    , electricProduct.getActivePower()
                    , electricProduct.salesRating()
            );
        }
        return "";
    }

    public void printWithSalesRating(String salesRating){
        System.out.println(this.productHeaderLine(ALL_PRODUCTS));
        for (Product product: this.getProductList()){
            if (product.salesRating().equals(salesRating)){
                System.out.println(String.format("%-10s | %-15s | %15s | %15d | %-25s"
                        , product.getCode()
                        , product.getName()
                        , this.convertToVND(product.getPrice())
                        , product.getStoredQuantity()
                        , product.salesRating()
                ));
            }
        }
    }

    // OPTION MENU
    public String normalization(String data){
        return data.trim().toUpperCase();
    }
    public void runMenu(boolean flag){
        Scanner scanner = new Scanner(System.in);
        String inputOpt;
        int inputType;
        int opt;

        // Product
        String productType;
        String productCode;
        String productName;
        double productPrice;
        int storedQuantity;
        // FoodProduct
        String supplier;
        LocalDate manufactureDate;
        LocalDate expirationDate;
        // CrockeryProduct
        String manufacturer;
        LocalDate warehouseDate;
        // ElectricProduct
        int warrantyTime;
        int activePower;

        while (flag){
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t1. Them hang hoa vao danh sach.");
            System.out.println("\t2. In toan bo danh sach hang hoa.");
            System.out.println("\t3. In toan bo danh sach tung loai hang hoa.");
            System.out.println("\t4. Tim kiem hang hoa.");
            System.out.println("\t5. Sap xep hang hoa theo ten tang dan.");
            System.out.println("\t6. Sap xep hang hoa theo so luong ton kho giam dan.");
            System.out.println("\t7. Xuat cac hoa hang \"kho ban\".");
            System.out.println("\t8. Xoa hang hoa.");
            System.out.println("\t9. Sua don gia.");
            System.out.println("\tNhap cac so ngoai [ 1 - 9 ] de thoat menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhap tuy chon [ 1 - 9 ]: ");

            inputOpt = normalization(scanner.nextLine());
            // Kiem tra chuoi co phai la chu so nguyen hay khong (regex).
            if (inputOpt.matches("\\d")){
                opt = Integer.valueOf(inputOpt);
            } else {
                opt = 0;
            }
            switch (opt) {
                case 1:
                    System.out.println("Nhap loai hang muon them vao danh sach"
                            + "\n- Hang thuc pham, nhap 1"
                            + "\n- Hang sanh su, nhap 2"
                            + "\n- Hang dien may, nhap 3"
                    );
                    System.out.print("Nhap: ");
                    inputType = Integer.valueOf(normalization(scanner.nextLine()));
                    Product sample = new FoodProduct("FFI002", "Ca basa", 60000.0, 8, "VietSeafood", LocalDate.of(2023,7,5), LocalDate.of(2023,7,7));;
                    boolean productValid = true;
                    switch (inputType){
                        case 1:
                            System.out.println("Nhap thong tin hang thuc pham:");
                            try {
                                System.out.print("Ma hang: ");
                                productCode = normalization(scanner.nextLine());
                                System.out.print("Ten hang: ");
                                productName = scanner.nextLine().trim();
                                System.out.print("Don gia: ");
                                productPrice = Double.valueOf(normalization(scanner.nextLine()));
                                System.out.print("So luong ton: ");
                                storedQuantity = Integer.valueOf(normalization(scanner.nextLine()));
                                // FoodProduct
                                System.out.print("Nha cung cap: ");
                                supplier = scanner.nextLine().trim();
                                System.out.print("Ngay san xuat (VD: 29/03/2023): ");
                                manufactureDate = this.convertStringToLocalDate(normalization(scanner.nextLine()));
                                System.out.print("Ngay het han (VD: 29/03/2023): ");
                                expirationDate = this.convertStringToLocalDate(normalization(scanner.nextLine()));
                                sample = new FoodProduct(productCode, productName, productPrice, storedQuantity, supplier, manufactureDate, expirationDate);
                            } catch (Exception e){
                                productValid = false;
                            }
                            break;
                        case 2:
                            System.out.println("Nhap thong tin hang sanh su:");
                            try {
                                System.out.print("Ma hang: ");
                                productCode = normalization(scanner.nextLine());
                                System.out.print("Ten hang: ");
                                productName = scanner.nextLine().trim();
                                System.out.print("Don gia: ");
                                productPrice = Double.valueOf(normalization(scanner.nextLine()));
                                System.out.print("So luong ton: ");
                                storedQuantity = Integer.valueOf(normalization(scanner.nextLine()));
                                // CrockeryProduct
                                System.out.print("Nha san xuat: ");
                                manufacturer = scanner.nextLine().trim();
                                System.out.print("Ngay nhap kho (VD: 29/03/2023): ");
                                warehouseDate = this.convertStringToLocalDate(normalization(scanner.nextLine()));
                                sample = new CrockeryProduct(productCode, productName, productPrice, storedQuantity, manufacturer, warehouseDate);
                            } catch (Exception e){
                                productValid = false;
                            }
                            break;
                        case 3:
                            System.out.println("Nhap thong tin hang dien may:");
                            try {
                                System.out.print("Ma hang: ");
                                productCode = normalization(scanner.nextLine());
                                System.out.print("Ten hang: ");
                                productName = scanner.nextLine().trim();
                                System.out.print("Don gia: ");
                                productPrice = Double.valueOf(normalization(scanner.nextLine()));
                                System.out.print("So luong ton: ");
                                storedQuantity = Integer.valueOf(normalization(scanner.nextLine()));
                                // ElectricProduct
                                System.out.print("Thoi gian bao hanh (theo thang): ");
                                warrantyTime = Integer.valueOf(normalization(scanner.nextLine()));
                                System.out.print("Cong suat (W): ");
                                activePower = Integer.valueOf(normalization(scanner.nextLine()));
                                sample = new ElectricProduct(productCode, productName, productPrice, storedQuantity, warrantyTime, activePower);
                            } catch (Exception e){
                                productValid = false;
                            }
                            break;
                        case 0:
                            System.out.println("Tao mau TEST hang hoa thuc pham.");
                            break;
                        default:
                            productValid = false;
                            System.out.println("Loai hang khong nam trong danh sach.");
                    }
                    if (productValid) {
                        if (this.add(sample)){
                            System.out.println("Hang hoa duoc them vao danh sach thanh cong.");
                        } else {
                            System.out.println("Hang hoa duoc them vao danh sach khong thanh cong.");
                        }
                    } else {
                        System.out.println("Nhap thong tin hang hoa khong thanh cong.");
                    }
                    break;
                case 2:
                    System.out.println("Dach sach tat ca hang hoa:");
                    this.print();
                    break;
                case 3:
                    System.out.println("Nhap loai hang muon xuat"
                            + "\n- Hang thuc pham, nhap 1"
                            + "\n- Hang sanh su, nhap 2"
                            + "\n- Hang dien may, nhap 3"
                    );
                    System.out.print("Nhap: ");
                    inputType = Integer.valueOf(normalization(scanner.nextLine()));
                    switch (inputType){
                        case 1:
                            System.out.println("Dach sach hang thuc pham:");
                            this.printFor(FOOD_PRODUCT);
                            break;
                        case 2:
                            System.out.println("Dach sach hang sanh su:");
                            this.printFor(CROCKERY_PRODUCT);
                            break;
                        case 3:
                            System.out.println("Dach sach hang dien may:");
                            this.printFor(ELECTRIC_PRODUCT);
                            break;
                        default:
                            System.out.println("Loai hang khong nam trong danh sach.");
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma hang hoa: ");
                    productCode = normalization(scanner.nextLine());
                    Product result = this.find(productCode);
                    if (result == null){
                        System.out.println("Khong tim duoc hang.");
                    } else {
                        if (result instanceof FoodProduct){
                            productType = FOOD_PRODUCT;
                        } else if (result instanceof CrockeryProduct) {
                            productType = CROCKERY_PRODUCT;
                        } else if (result instanceof ElectricProduct) {
                            productType = ELECTRIC_PRODUCT;
                        } else {
                            productType = "";
                        }
                        this.printProductHeaderLine(productType);
                        System.out.println(this.productToString(result));;
                    }
                    break;
                case 5:
                    System.out.println("Danh sach hang hoa theo ten tang dan:");
                    this.sortAscendingProductName();
                    this.print();
                    break;
                case 6:
                    System.out.println("Danh sach hang hoa theo so luong ton kho giam dan:");
                    this.sortDescendingStoredQuantity();
                    this.print();
                    break;
                case 7:
                    System.out.println("Danh sach hang hoa thuc pham kho ban:");
                    this.printWithSalesRating(Product.DIFF_SALE);
                    break;
                case 8:
                    System.out.print("Nhap ma hang hoa: ");
                    productCode = normalization(scanner.nextLine());
                    if (this.remove(productCode)){
                        System.out.println("Hang hoa duoc xoa thanh cong.");
                    }else {
                        System.out.println("Hang hoa duoc xoa khong thanh cong.");
                    }
                    break;
                case 9:
                    System.out.print("Nhap ma hang hoa: ");
                    productCode = normalization(scanner.nextLine());
                    System.out.print("Nhap don gia moi: ");
                    double newPrice = Double.valueOf(normalization(scanner.nextLine()));
                    if (this.fixProductPrice(productCode, newPrice)){
                        System.out.println("Don gia duoc sua thanh cong.");
                    } else {
                        System.out.println("Don gia duoc sua khong thanh cong.");
                    }
                    break;
                default:
                    System.out.println("Thoat MENU.");
                    flag = false;
                    break;
            }
        }
    }
}
