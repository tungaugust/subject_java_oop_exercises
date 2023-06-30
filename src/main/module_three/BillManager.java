package main.module_three;


public class BillManager {
    private Bill[] list;
    private int capacity;
    private int size;

//    public Bill[] getList() {
//        return list;
//    }
//
    private void setList(Bill[] list) {
        this.list = list;
    }
//
//
//    private void setCount(int count) {
//        if (count < 0){
//            count = 0;
//        }
//        this.capacity = count;
//    }

    public BillManager(int count) {
//        setCount(count);
        setList(new Bill[count]);
    }

//    public void reSetupCount(int count){
//        if (count < 0){
//            return;
//        }
//        setCount(count);
//    }
//
//    public boolean add(Bill bill){
//        if()
//
//        return false;
//    }

}
