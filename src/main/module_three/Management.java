package main.module_three;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Management {
    private ArrayList<Person> personList;
    public final static String STUDENT_GROUP = "student";
    public final static String EMPLOYEE_GROUP = "employee";
    public final static String CUSTOMER_GROUP = "customer";
    public ArrayList<Person> getPersonList() {
        return this.personList;
    }
    private void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    public Management() {
        this.setPersonList(new ArrayList<>());
    }

    //
    public int size(){
        return this.getPersonList().size();
    }
    public <T> int indexOf(T person){
        boolean compare;
        if (person instanceof String){
            String personName = (String) person;
            for (int i = 0; i < this.size(); i++){
                compare = this.normalization(this.getPersonList().get(i).getName()).equals(this.normalization(personName));
                if (compare) {
                    return i;
                }
            }
        }
        if (person instanceof Person){
            Person personInstance = (Person) person;
            for (int i = 0; i < this.size(); i++){
                compare = this.normalization(this.getPersonList().get(i).getName()).equals(this.normalization(personInstance.getName()));
                if (compare) {
                    return i;
                }
            }
        }
        return -1;
    }

    //
    public boolean add(Person person){
        if (this.indexOf(person) > 0) {
            return false;
        }
        this.getPersonList().add(person);
        return true;
    }
    public boolean remove(String name) {
        int pos = this.indexOf(name);
        if (pos < 0){
            return false;
        }
        this.getPersonList().remove(pos);
        return true;
    }
    public void sortAscendingPersonName(){
        // CACH 1: Su dung Collections.sort()
        Collections.sort(this.getPersonList(), new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
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
    }

    //
    public void print(){
        this.printHeaderLine();
        for (int i = 0; i < this.size(); i++){
            System.out.printf("%6d | %s\n", i+1, this.personToString(this.getPersonList().get(i)));
        }
    }
    public void printHeaderLine(){
        String headerLine = String.format("%6s | %-30s | %-20s | %-15s"
                , "STT", "HO VA TEN", "DIA CHI", "NHOM"
        );
        String line = this.repeatString("-", 40, " ");
        System.out.println(line + "\n" + headerLine + "\n" + line);
    }
    public String repeatString(String target, int count, String separator){
        return String.join(separator, Collections.nCopies(count, target));
    }
    public String personToString(Person person){
        String personGroup = "";
        if (person instanceof StudentNeo){
            personGroup = STUDENT_GROUP;
        } else if (person instanceof Employee){
            personGroup = EMPLOYEE_GROUP;
        } else if (person instanceof Customer){
            personGroup = CUSTOMER_GROUP;
        }
        if (personGroup.equals("")){
            return personGroup;
        } else {
            return String.format("%-30s | %-20s | %-15s"
                    , person.getName()
                    , person.getAddress()
                    , personGroup
            );
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

        // Person
        String personName;
        String personAddress;
        // StudentNeo
        double firstSubjectScore;
        double secondSubjectScore;
        // Employee
        double salaryCoefficient;
        // Custonmer
        String company;
        double invoiceValue;
        String evaluate;

        while (flag){
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t1. Them mot nguoi vao danh sach.");
            System.out.println("\t2. Xoa mot nguoi khoi danh sach.");
            System.out.println("\t3. Sap xep danh sach theo ho va ten tang dan.");
            System.out.println("\t4. Xuat danh sach.");
            System.out.println("\tNhap cac so ngoai [ 1 - 4 ] de thoat menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhap tuy chon [ 1 - 4 ]: ");

            inputOpt = normalization(scanner.nextLine());
            // Kiem tra chuoi co phai la chu so nguyen hay khong (regex).
            if (inputOpt.matches("\\d")){
                opt = Integer.valueOf(inputOpt);
            } else {
                opt = 0;
            }
            switch (opt) {
                case 1:
                    System.out.println("Nhap loai nhom cua nguoi muon them vao danh sach"
                            + "\n- Sinh vien, nhap 1"
                            + "\n- Nhan vien, nhap 2"
                            + "\n- Khach hang, nhap 3"
                    );
                    System.out.print("Nhap: ");
                    inputType = Integer.valueOf(normalization(scanner.nextLine()));
                    Person sample = new StudentNeo("Student Sample", "Address Sample", 9.0, 8.5);
                    boolean valid = true;
                    switch (inputType){
                        case 1:
                            System.out.println("Nhap thong tin cua hoc sinh:");
                            try {
                                System.out.print("Ho va ten: ");
                                personName = scanner.nextLine().trim();
                                System.out.print("Dia chi: ");
                                personAddress = scanner.nextLine().trim();
                                // StudentNeo
                                System.out.print("Diem mon hoc 1: ");
                                firstSubjectScore = Double.valueOf(normalization(scanner.nextLine()));
                                System.out.print("Diem mon hoc 2: ");
                                secondSubjectScore = Double.valueOf(normalization(scanner.nextLine()));
                                sample = new StudentNeo(personName, personAddress, firstSubjectScore, secondSubjectScore);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 2:
                            System.out.println("Nhap thong tin cua nhan vien:");
                            try {
                                System.out.print("Ho va ten: ");
                                personName = scanner.nextLine().trim();
                                System.out.print("Dia chi: ");
                                personAddress = scanner.nextLine().trim();
                                // Employee
                                System.out.print("He so luong: ");
                                salaryCoefficient = Double.valueOf(normalization(scanner.nextLine()));
                                sample = new Employee(personName, personAddress, salaryCoefficient);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 3:
                            System.out.println("Nhap thong tin cua khach hang:");
                            try {
                                System.out.print("Ho va ten: ");
                                personName = scanner.nextLine().trim();
                                System.out.print("Dia chi: ");
                                personAddress = scanner.nextLine().trim();
                                // Customer
                                System.out.print("Cong ty: ");
                                company = scanner.nextLine().trim();
                                System.out.print("Gia tri hoa don: ");
                                invoiceValue = Double.valueOf(normalization(scanner.nextLine()));
                                System.out.print("Danh gia: ");
                                evaluate = scanner.nextLine().trim();
                                sample = new Customer(personName, personAddress, company, invoiceValue, evaluate);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 0:
                            System.out.println("Tao mau TEST hoc sinh.");
                            break;
                        default:
                            valid = false;
                            System.out.println("Nhom khong quan ly cua danh sach.");
                    }
                    if (valid) {
                        if (this.add(sample)){
                            System.out.println("Them vao danh sach thanh cong.");
                        } else {
                            System.out.println("Them vao danh sach khong thanh cong.");
                        }
                    } else {
                        System.out.println("Nhap thong tin nguoi khong thanh cong.");
                    }
                    break;
                case 2:
                    System.out.print("Nhap ho va ten: ");
                    personName = scanner.nextLine().trim();
                    if (this.remove(personName)){
                        System.out.println("Xoa thanh cong.");
                    }else {
                        System.out.println("Xoa khong thanh cong.");
                    }
                    break;
                case 3:
                    System.out.println("Danh sach quan ly theo ho va ten tang dan:");
                    this.sortAscendingPersonName();
                    this.print();
                    break;
                case 4:
                    System.out.println("Dach sach quan ly:");
                    this.print();
                    break;
                default:
                    System.out.println("Thoat MENU.");
                    flag = false;
                    break;
            }
        }
    }
}
