package main.module_four;

import main.module_three.Quad;

import java.util.*;

public class TrueLoveCompany {
    private HashSet<TrueLoveStaff> staffList;
    private HashSet<String> productNameList;
    private HashSet<TrueLoveStaff> checkedStaffList;
    private Queue<TrueLoveStaff> registerStaffList;

    public HashSet<TrueLoveStaff> getStaffList() {
        return this.staffList;
    }

    private void setStaffList() {
        this.staffList = new HashSet<>();
    }

    public TrueLoveCompany() {
        this.setStaffList();
        this.checkedStaffList = new HashSet<>();
        this.productNameList = new HashSet<>();
        this.registerStaffList = new LinkedList<>();
    }

    public boolean add(TrueLoveStaff staff){
        return this.getStaffList().add(staff);
    }

    public void print(){
        for (TrueLoveStaff staff: this.getStaffList()){
            System.out.println(staff.getCode() + " - " + staff.getName());
        }
    }
    private String randomStaffCode(HashSet<TrueLoveStaff> hashSet){
        List<TrueLoveStaff> arrayList = new ArrayList<TrueLoveStaff>(hashSet);
        int size = arrayList.size();
        int randomNumber = new Random().nextInt(size);
        String randomStaffCode = arrayList.get(randomNumber).getCode();
        return randomStaffCode;
    }
    public TrueLoveStaff get(String code){
        for (TrueLoveStaff staff: this.getStaffList()){
            if (staff.getCode().equals(code)){
                return staff;
            }
        }
        return null;
    }
    public void receivedRandomGiftStaff(){
        TrueLoveStaff staff = this.get(this.randomStaffCode(this.getStaffList()));
        System.out.println("Ma so: " + staff.getCode() + "\n" + "Ten: " + staff.getName());
    }

    public void randomProductName(){
        boolean flag = true;
        HashSet<TrueLoveStaff> clone = (HashSet<TrueLoveStaff>) this.getStaffList().clone();
        try {
            while (flag) {
                clone.removeAll(this.checkedStaffList);
                TrueLoveStaff staff = this.get(this.randomStaffCode(clone));
                this.checkedStaffList.add(staff);
                if (!this.productNameList.contains(staff.getName()) || clone.size() <= 0) {
                    this.productNameList.add(staff.getName());
                    System.out.println("Ten san pham moi la \'" + staff.getName() + "\'");
                    flag = false;
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Khong con ten chua dung cho san pham moi.");
        }
    }
    public void popularProductName(){
        HashMap<String, Integer> nameList = new HashMap<>();
        String key;
        int max = 0;
        for (TrueLoveStaff staff: this.getStaffList()){
            key = staff.getName();
            if (nameList.containsKey(key)){
                nameList.put(key, nameList.get(key) + 1);
            } else {
                nameList.put(key, 1);
            }
            if (nameList.get(key) > max){
                max = nameList.get(key);
            }
        }
        for (String name: nameList.keySet()){
            if (nameList.get(name) >= max){
                System.out.println("- Ten pho bien cho san pham cua cong ty la \'" + name + "\'");
                return;
            }
        }
        System.out.println("- Khong tim thay ten nao cho san pham.");
    }

    public boolean register(TrueLoveStaff staff){
        return this.registerStaffList.offer(staff);
    }
    public void printRegisterStaffList(){
        int i = 0;
        for (TrueLoveStaff staff: this.registerStaffList){
            System.out.println( (i+1) + ". " + staff.getCode() + " - " + staff.getName());
            i++;
        }
    }
}
