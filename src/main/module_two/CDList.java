package main.module_two;

import java.util.ArrayList;
import java.util.Collections;

public class CDList {
    private long capacity;
    private long size;
    private ArrayList<CD> list;

    public CDList() {
        this.capacity = 0;
        this.size = 0;
        this.list = new ArrayList<CD>();
    }

    public CDList(long capacity) {
        this();
        setCapacity(capacity);
    }

    public long getCapacity() {
        return capacity;
    }

    public boolean setCapacity(long capacity) {
        if (capacity >= getSize()) {
            this.capacity = capacity;
            return true;
        }
        return false;
    }

    public long getSize() {
        return size;
    }

    private void setSize() {
        this.size += 1;
    }

    public ArrayList<CD> getList() {
        return list;
    }

    public boolean add(CD cd) {
        if (getSize() < getCapacity()) {
            for (CD item : getList()) {
                if (item.getCode() == cd.getCode()) {
                    return false;
                }
            }
            setSize();
            this.list.add(cd);
            return true;
        }
        return false;
    }

    public double priceTotal() {
        double total = 0.0;
        for (CD item : getList()) {
            total += item.getPrice();
        }
        return total;
    }

    public void sortDescendingPrice() {
        ArrayList<CD> cdList = getList();
        int size = (int) getSize();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                CD before = cdList.get(i);
                CD after = cdList.get(j);
                if (after.getPrice() > before.getPrice()) {
                    Collections.swap(cdList, i, j);
                }
            }
        }
    }

    public void sortAscendingTitle() {
        ArrayList<CD> cdList = getList();
        int size = (int) getSize();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                CD before = cdList.get(i);
                CD after = cdList.get(j);
                int compareResult = after.getTitle().compareTo(before.getTitle());
                if (compareResult < 0) {
                    Collections.swap(cdList, i, j);
                }
            }
        }
    }

    public void printCDList() {
        for (CD cd : getList()) {
            System.out.println(cd);
        }
    }
}
