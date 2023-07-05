package main.module_three;

import main.module_two.CD;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    private Product[] products;
    private int capacity;
    private int size;

    private final static String ALL_PRODUCTS = "all products";
    private final static String FOOD_PRODUCT = "food product";
    private final static String CROCKERY_PRODUCT = "crockery product";
    private final static String ELECTRIC_PRODUCT = "electric product";

    private Product[] getProducts() {
        return this.products;
    }

    private void setProducts(Product[] products) {
        this.products = products;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }
    private void increaseSize(){
        setSize(getSize() + 1);
    }

    private void decreaseSize(){
        setSize(getSize() - 1);
    }

    public ProductManager(int capacity) {
        this.setCapacity(capacity);
        this.setSize(0);
        this.setProducts(new Product[this.getCapacity()]);
    }

    private int index(String productCode){
        for (int i = 0; i < this.getSize(); i++){
            if (this.getProducts()[i].getCode().equals(productCode)){
                return i;
            }
        }
        return -1;
    }
    public boolean add(Product product){
        if (this.getSize() >= this.getCapacity() || this.index(product.getCode()) >= 0) {
            return false;
        }
        this.getProducts()[this.getSize()] = product;
        this.increaseSize();
        return true;
    }
    public boolean remove(String productCode) {
        int index = this.index(productCode);
        // Co 4 truong hop: phan tu khong tim thay (-1), tim thay o dau (0), cuoi (size - 1), va giua mang (1 --> size - 2)
        if (index < 0){
            return false;
        }
        for (int i = index; i < this.getSize() - 1; i++){
            this.getProducts()[i] = this.getProducts()[i+1];
        }
        this.getProducts()[getSize() - 1] = null;
        this.decreaseSize();
        return true;
    }
    private String convertToVND(double amount){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00 VND");
        return decimalFormat.format(amount);
    }
    private String convertToFormattedDate(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(dateTimeFormatter);
    }

    private String productHeaderLine(String productType){
        String headerLine = "";
        if (productType.equals(ALL_PRODUCTS)){
            headerLine = String.format("%-10s %-15s %15s %15s %-25s"
                    , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "DANH GIA MUC DO BAN BUON"
            );
        }
        if (productType.equals(FOOD_PRODUCT)){
            headerLine = headerLine = String.format("%-10s %-15s %15s %15s %-15s %15s %15s %-25s"
                    , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "NHA CUNG CAP", "NGAY SAN XUAT", "NGAY HET HAN", "DANH GIA MUC DO BAN BUON"
            );
        }
        if (productType.equals(CROCKERY_PRODUCT)){
            headerLine = String.format("%-10s %-15s %15s %15s %-15s %15s %-25s"
                    , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "NHA SAN XUAT", "NGAY NHAP KHO", "DANH GIA MUC DO BAN BUON"
            );
        }
        if (productType.equals(ELECTRIC_PRODUCT)){
            headerLine = String.format("%-10s %-15s %15s %15s %30s %15s %-25s"
                    , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "THOI GIAN BAN HANH (THANG)", "CONG SUAT", "DANH GIA MUC DO BAN BUON"
            );
        }
        return headerLine;
    }

    private String productToString(Product product){
        if (product instanceof FoodProduct) {
            FoodProduct foodProduct = (FoodProduct) product;
            return String.format("%-10s %-15s %15s %15d %-15s %15s %15s %-25s"
                    , foodProduct.getCode()
                    , foodProduct.getName()
                    , this.convertToVND(foodProduct.getPrice())
                    , foodProduct.getStoredQuantity()
                    , foodProduct.getSupplier()
                    , this.convertToFormattedDate(foodProduct.getManufactureDate())
                    , this.convertToFormattedDate(foodProduct.getExpirationDate())
                    , foodProduct.salesRating()
            );
        }
        if (product instanceof CrockeryProduct) {
            CrockeryProduct crockeryProduct = (CrockeryProduct) product;
            return String.format("%-10s %-15s %15s %15d %-15s %15s %-25s"
                    , crockeryProduct.getCode()
                    , crockeryProduct.getName()
                    , this.convertToVND(crockeryProduct.getPrice())
                    , crockeryProduct.getStoredQuantity()
                    , crockeryProduct.getManufacturer()
                    , this.convertToFormattedDate(crockeryProduct.getWarehouseDate())
                    , crockeryProduct.salesRating()
            );
        }
        if (product instanceof ElectricProduct) {
            ElectricProduct electricProduct = (ElectricProduct) product;
            return String.format("%-10s %-15s %15s %15d %30d %15d %-25s"
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
    public void printProducts(){
        System.out.println(this.productHeaderLine(ALL_PRODUCTS));
        Product product;
        for (int i = 0; i < this.getSize(); i++){
            product = this.getProducts()[i];
            System.out.println(String.format("%-10s %-15s %15s %15d %-25s"
                    , product.getCode()
                    , product.getName()
                    , this.convertToVND(product.getPrice())
                    , product.getStoredQuantity()
                    , product.salesRating()
            ));
        }
    }
    public void printFoodProducts(){
        String headerLine = String.format("%-10s %-15s %15s %15s %-15s %15s %15s %-25s"
                , "MA HANG", "TEN HANG", "DON GIA", "SO LUONG TON", "NHA CUNG CAP", "NGAY SAN XUAT", "NGAY HET HAN", "DANH GIA MUC DO BAN BUON"
        );
        System.out.println(this.productHeaderLine(FOOD_PRODUCT));
        for (int i = 0; i < this.getSize(); i++){
            if (this.getProducts()[i] instanceof FoodProduct){
                System.out.println(this.productToString((FoodProduct) this.getProducts()[i]));
            }
        }
    }
    public void printCrockeryProducts(){
        System.out.println(this.productHeaderLine(CROCKERY_PRODUCT));
        for (int i = 0; i < this.getSize(); i++){
            if (this.getProducts()[i] instanceof CrockeryProduct){
                System.out.println(this.productToString((CrockeryProduct) this.getProducts()[i]));
            }
        }
    }
    public void printElectricProducts(){
        System.out.println(this.productHeaderLine(ELECTRIC_PRODUCT));
        for (int i = 0; i < this.getSize(); i++){
            if (this.getProducts()[i] instanceof ElectricProduct){
                System.out.println(this.productToString((ElectricProduct) this.getProducts()[i]));
            }
        }
    }

    public void printWithSalesRating(String salesRating){
        System.out.println(this.productHeaderLine(ALL_PRODUCTS));
        Product product;
        for (int i = 0; i < this.getSize(); i++){
            product = this.getProducts()[i];
            if (product.salesRating().equals(salesRating)){
                System.out.println(String.format("%-10s %-15s %15s %15d %-25s"
                        , product.getCode()
                        , product.getName()
                        , this.convertToVND(product.getPrice())
                        , product.getStoredQuantity()
                        , product.salesRating()
                ));
            }
        }
    }

    public void findProduct(String productCode){
        int index = this.index(productCode);
        if (index >= 0) {
            Product product = this.getProducts()[index];
            if (product instanceof FoodProduct){
                System.out.println(this.productHeaderLine(FOOD_PRODUCT));
                System.out.println(this.productToString(product));
                return;
            }
            if (product instanceof CrockeryProduct) {
                System.out.println(this.productHeaderLine(CROCKERY_PRODUCT));
                System.out.println(this.productToString(product));
                return;
            }
            if (product instanceof ElectricProduct){
                System.out.println(this.productHeaderLine(ELECTRIC_PRODUCT));
                System.out.println(this.productToString(product));
                return;
            }
        }
        System.out.println("NOTICE!!! Khong tim thay san pham.");
    }

    public boolean fixProductPrice(String productCode, double newPrice) {
        int index = this.index(productCode);
        if (index >= 0) {
            this.getProducts()[index].setPrice(newPrice);
            return true;
        }
        return false;
    }

    private <T> void swap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public void sortAscendingProductName(){
        for (int i = 0; i < this.getSize() - 1; i++) {
            for (int j = i + 1; j < this.getSize(); j++) {
                int compareResult = this.getProducts()[j].getName().compareTo(this.getProducts()[i].getName());
                if (compareResult < 0) {
                    this.swap(this.getProducts(), i, j);
                }
            }
        }
    }
    public void sortDescendingStoredQuantity(){
        for (int i = 0; i < this.getSize() - 1; i++) {
            for (int j = i + 1; j < this.getSize(); j++) {
                boolean compareResult = this.getProducts()[i].getStoredQuantity() < this.getProducts()[j].getStoredQuantity();
                if (compareResult) {
                    this.swap(this.getProducts(), i, j);
                }
            }
        }
    }

    private static String normalization(String data){
        return data.trim().toUpperCase();
    }
    public static void runMenu(ProductManager productManager, boolean flag){
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
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

            opt = Integer.valueOf(normalization(scanner.nextLine()));
            String productCode;
            switch (opt) {
                case 1:
                    System.out.println("Nhap hang hoa muon them vao danh sach:");
                    Product product = new FoodProduct("FFI002", "Ca basa", 60000.0, 8, "VietSeafood", LocalDate.of(2023,7,5), LocalDate.of(2023,7,7));
                    if (productManager.add(product)){
                        System.out.println("Them thanh cong.");
                    }else {
                        System.out.println("Them that bai.");
                    }
                    break;
                case 2:
                    System.out.println("Dach sach tat ca hang hoa:");
                    productManager.printProducts();
                    break;
                case 3:
                    System.out.println("Nhap loai hang muon in danh sach"
                            + "\n- Hang thuc pham, nhap 1"
                            + "\n- Hang do su, nhap 2"
                            + "\n- Hang dien may, nhap 3"
                    );
                    System.out.print("Loai hang muon in: ");
                    int productType = Integer.valueOf(normalization(scanner.nextLine()));
                    switch (productType){
                        case 1:
                            System.out.println("Dach sach hang thuc pham:");
                            productManager.printFoodProducts();
                            break;
                        case 2:
                            System.out.println("Dach sach hang do su:");
                            productManager.printCrockeryProducts();
                            break;
                        case 3:
                            System.out.println("Dach sach hang dien may:");
                            productManager.printElectricProducts();
                            break;
                        default:
                            System.out.println("Loai hang khong nam trong danh sach.");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Hang hoa can tim co ma la: ");
                    productCode = normalization(scanner.nextLine());
                    System.out.println("Hang hoa tim duoc:");
                    productManager.findProduct(productCode);
                    break;
                case 5:
                    System.out.println("Danh sach hang hoa theo ten tang dan:");
                    productManager.sortAscendingProductName();
                    productManager.printProducts();
                    break;
                case 6:
                    System.out.println("Danh sach hang hoa theo so luong ton kho giam dan:");
                    productManager.sortDescendingStoredQuantity();
                    productManager.printProducts();
                    break;
                case 7:
                    System.out.println("Danh sach hang hoa thuc pham kho bann:");
                    productManager.printWithSalesRating(Product.DIFF_SALE);
                    break;
                case 8:
                    System.out.print("Hang hoa can xoa co ma la: ");
                    productCode = normalization(scanner.nextLine());
                    if (productManager.remove(productCode)){
                        System.out.println("Xoa thanh cong.");
                    }else {
                        System.out.println("Xoa that bai.");
                    }
                    break;
                case 9:
                    System.out.print("Hang hoa can sua co ma la: ");
                    productCode = normalization(scanner.nextLine());
                    System.out.print("Hang hoa can sua co ma la: ");
                    double newPrice = Double.valueOf(normalization(scanner.nextLine()));
                    if (productManager.fixProductPrice(productCode, newPrice)){
                        System.out.println("Sua don gia thanh cong.");
                    }else {
                        System.out.println("Xoa don gia that bai.");
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
