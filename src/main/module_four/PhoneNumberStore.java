package main.module_four;

import java.util.TreeSet;

public class PhoneNumberStore {
    private TreeSet<String> store;

    public TreeSet<String> getStore() {
        return this.store;
    }

    public boolean addPhoneNumber(String phoneNumber){
        if (this.getStore().contains(phoneNumber)){
            return false;
        }
        this.getStore().add(phoneNumber);
        return true;
    }
    public boolean removePhoneNumber(String phoneNumber){
        if (!this.getStore().contains(phoneNumber)){
            return false;
        }
        this.getStore().remove(phoneNumber);
        return true;
    }
    public PhoneNumberStore() {
        this.store = new TreeSet<>();
    }
}
