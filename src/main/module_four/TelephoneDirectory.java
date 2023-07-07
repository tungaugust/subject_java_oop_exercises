package main.module_four;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TelephoneDirectory {
    private HashMap<String, PhoneNumberStore> directory;

    public HashMap<String, PhoneNumberStore> getDirectory() {
        return this.directory;
    }
    public TelephoneDirectory() {
        this.directory = new HashMap<>();
    }
    private boolean addPhoneNumber(String address, String phoneNumber){
        return this.getDirectory().get(address).addPhoneNumber(phoneNumber);
    }
    private void createNewAccount(String address){
        this.getDirectory().put(address, new PhoneNumberStore());
    }
    private String normalization(String data){
        return data.trim().toLowerCase();
    }
    public boolean add(String address, String phoneNumber){
        // Chuan hoa du lieu dau vao.
        address = this.normalization(address);
        // Danh sach chua chua dia chi, can tao mot cap dia chi - kho so moi.
        if (!this.getDirectory().containsKey(address)) {
            this.createNewAccount(address);
        }
        // Danh sach da co dia chi, va them so dien thoai moi vao kho luu tru cua dia chi do.
        return this.addPhoneNumber(address, phoneNumber);
    }

    public void lookUpAddress(String address){
        // Chuan hoa du lieu dau vao.
        address = this.normalization(address);

        Object object = this.getDirectory().get(address);
        if (object == null){
            System.out.println("Khong tiem thay dia chi \'" +  address + "\' trong danh sach.");
        } else {
            System.out.println("Danh sach cac so dien thoai cua dia chi \'" +  address + "\':");
            PhoneNumberStore phoneNumberStore = (PhoneNumberStore) object;
            for (String phoneNumber: phoneNumberStore.getStore()) {
                System.out.println("+ " + phoneNumber);
            }
        }
    }
    public void lookUpPhoneNumber(String phoneNumber){
        System.out.println("Danh sach dia chi co so dien thoai \'" +  phoneNumber + "\':");
        boolean found = true;
        for (String address: this.getDirectory().keySet()) {
            for (String number: this.getDirectory().get(address).getStore()){
                if (number.equals(phoneNumber)){
                    System.out.println("+ " + address);
                    found = false;
                }
            }
        }
        if (found){
            System.out.println("Khong tiem thay dia chi co so dien thoai la \'" +  phoneNumber + "\' trong danh sach.");
        }
    }
}
