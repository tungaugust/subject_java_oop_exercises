package main.module_three;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillManager {
    private ArrayList<Bill> list;
    public ArrayList<Bill> getList() {
        return list;
    }

    private void setList(ArrayList<Bill> list) {
        this.list = list;
    }

    public int getCount() {
        return getList().size();
    }

    public BillManager() {
        setList(new ArrayList<Bill>());
    }

    public boolean add(Bill bill){
        for (Bill b: getList()) {
            if (!this.equals(bill)) {
                getList().add(bill);
                return true;
            }
        }
        return false;
    }

    public void printer(int month, int year){
        System.out.println(Bill.headerLine());
        if (month > 0 && year > 0) {
            for(Bill bill: getList()){
                if(year == bill.getDate().getYear() && month == bill.getDate().getMonth().getValue()){
                    System.out.println(bill);
                }
            }
        } else {
            for(Bill bill: getList()){
                System.out.println(bill);
            }
        }
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String totalRevenueFString = df.format(totalRevenue(month, year)) + "VND";
        System.out.println(">>> Tong thanh tien: " + totalRevenueFString);
    }

    public int hourlyBillCount(){
        int count = 0;
        for(Bill bill: getList()){
            if(bill instanceof  HourlyBill) {
                count++;
            }
        }
        return count;
    }
    public int dailyBillCount(){
        int count = 0;
        for(Bill bill: getList()){
            if(bill instanceof  DailyBill) {
                count++;
            }
        }
        return count;
    }
    public double totalRevenue(int month, int year){
        int sum = 0;
        for(Bill bill: getList()){
            if(year == bill.getDate().getYear() && month == bill.getDate().getMonth().getValue()){
                sum += bill.revenue();
            }
        }
        return sum;
    }
}
