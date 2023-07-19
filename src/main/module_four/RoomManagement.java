package main.module_four;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomManagement {
    private ArrayList<UniversityRoom> roomList;

    public ArrayList<UniversityRoom> getRoomList() {
        return this.roomList;
    }

    public RoomManagement() {
        this.roomList = new ArrayList<>();
    }

    public int index(String roomCode){
        for (int i = 0; i < this.getRoomList().size(); i++){
            if (this.getRoomList().get(i).getRoomCode().toUpperCase().equals(roomCode.toUpperCase())){
                return i;
            }
        }
        return -1;
    }
    public boolean add(UniversityRoom room){
        if (this.index(room.getRoomCode()) > 0){
            return false;
        }
        this.getRoomList().add(room);
        return true;
    }

    public void printList(){
        for (UniversityRoom room: this.getRoomList()){
            System.out.println(room);
        }
    }
    public void findRoom(String roomCode){
        int index = this.index(roomCode);
        if (index >= 0){
            System.out.println("Thong tin phong co ma '" + roomCode + "':");
            System.out.println(this.getRoomList().get(index));
        }else {
            System.out.println("Khong tim thay phong co ma '" + roomCode + "'.");
        }
    }
    public void printStandardRooms(){
        for (UniversityRoom room: this.getRoomList()){
            if (room.isStandardRoom()){
                System.out.println(room);
            }
        }
    }
    public void runMenu(boolean flag){
        Scanner scanner = new Scanner(System.in);
        String inputOpt;
        int inputType;
        int opt;

        // Room
        String roomCode;
        String buildingCode;
        double area;
        int lightCount;
        // Computer Room
        int computerCount;
        // Theory Room
        boolean projector;
        // Laboratory
        boolean sink;
        String major;
        int capacity;

        while (flag){
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t1. Them mot phong vao danh sach.");
            System.out.println("\t2. Tim kiem phong trong danh sach.");
            System.out.println("\t3. Xuat thong tin toan bo phong trong danh sach.");

            System.out.println("\t4. Xuat danh sach.");
            System.out.println("\tNhap cac so ngoai [ 1 - 4 ] de thoat menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhap tuy chon [ 1 - 4 ]: ");

            inputOpt = scanner.nextLine().trim();
            // Kiem tra chuoi co phai la chu so nguyen hay khong (regex).
            if (inputOpt.matches("\\d")){
                opt = Integer.valueOf(inputOpt);
            } else {
                opt = 0;
            }
            switch (opt) {
                case 1:
                    System.out.println("Nhap loai phong muon them vao danh sach"
                            + "\n- Phong Hoc Ly Thuyet, nhap 1"
                            + "\n- Phong May Tinh, nhap 2"
                            + "\n- Phong Thi Nghiem, nhap 3"
                    );
                    System.out.print("Nhap: ");
                    inputType = Integer.valueOf(scanner.nextLine().trim());
                    UniversityRoom sample = new TheoryRoom("TR000", "X", 0, 0, false);
                    boolean valid = true;
                    switch (inputType){
                        case 1:
                            try {
                                System.out.println("Nhap thong tin cua phong hoc ly thuyet:");
                                System.out.print("Ma phong: ");
                                roomCode = scanner.nextLine().trim();
                                System.out.print("Ma toan nha: ");
                                buildingCode = scanner.nextLine().trim();
                                System.out.print("Dien tich: ");
                                area = Double.valueOf(scanner.nextLine().trim());
                                System.out.print("So luong bong den: ");
                                lightCount = Integer.valueOf(scanner.nextLine().trim());
                                // Phong Hoc Ly Thuyet
                                System.out.print("Phong co may chieu hay khong (Co: Y - Khong: N - Mac dinh: N): ");
                                projector = scanner.nextLine().trim().toUpperCase().equals("Y") ? true : false;
                                sample = new TheoryRoom(roomCode, buildingCode, area, lightCount, projector);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Nhap thong tin cua phong may tinh:");
                                System.out.print("Ma phong: ");
                                roomCode = scanner.nextLine().trim();
                                System.out.print("Ma toan nha: ");
                                buildingCode = scanner.nextLine().trim();
                                System.out.print("Dien tich: ");
                                area = Double.valueOf(scanner.nextLine().trim());
                                System.out.print("So luong bong den: ");
                                lightCount = Integer.valueOf(scanner.nextLine().trim());
                                // Phong May Tinh
                                System.out.print("So luong may tinh: ");
                                computerCount = Integer.valueOf(scanner.nextLine().trim());
                                sample = new ComputerRoom(roomCode, buildingCode, area, lightCount, computerCount);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Nhap thong tin cua phong thi nghiem:");
                                System.out.print("Ma phong: ");
                                roomCode = scanner.nextLine().trim();
                                System.out.print("Ma toan nha: ");
                                buildingCode = scanner.nextLine().trim();
                                System.out.print("Dien tich: ");
                                area = Double.valueOf(scanner.nextLine().trim());
                                System.out.print("So luong bong den: ");
                                lightCount = Integer.valueOf(scanner.nextLine().trim());
                                // Phong Thi Nghiem
                                System.out.print("Nganh hoc: ");
                                major = scanner.nextLine().trim();
                                System.out.print("Suc chua toi da: ");
                                capacity = Integer.valueOf(scanner.nextLine().trim());
                                System.out.print("Phong co bon rua tay hay khong (Co: Y - Khong: N - Mac dinh: N): ");
                                sink = scanner.nextLine().trim().toUpperCase().equals("Y") ? true : false;
                                sample = new Laboratory(roomCode, buildingCode, area, lightCount, major, capacity, sink);
                            } catch (Exception e){
                                valid = false;
                            }
                            break;
                        case 0:
                            System.out.println("Tao mau TEST room.");
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
                        System.out.println("Nhap thong tin phong khong thanh cong.");
                    }
                    break;
                case 2:
                    System.out.print("Nhap ma phong can tim (Khong phan biet hoa - thuong): ");
                    roomCode = scanner.nextLine().trim();
                    this.findRoom(roomCode);
                    break;
                case 3:
                    System.out.println("Thong tin cua tat ca cac phong co trong danh sach:");
                    this.printList();
                    break;
                case 4:
                    System.out.println("Thong tin cua tat ca cac phong dat chuan:");
                    this.printStandardRooms();
                    break;
                default:
                    System.out.println("Thoat MENU.");
                    flag = false;
                    break;
            }
        }
    }
}
