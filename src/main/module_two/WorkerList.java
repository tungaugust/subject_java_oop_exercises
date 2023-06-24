package main.module_two;

import java.util.ArrayList;
import java.util.Collections;

public class WorkerList {
    private long capacity = 0;
    private long size = 0;
    private ArrayList<Worker> list;

    public WorkerList() {
        this.capacity = 0;
        this.size = 0;
        this.list = new ArrayList<Worker>();
    }

    public WorkerList(long capacity) {
        this();
        setCapacity(capacity);
    }

    public long getCapacity() {
        return this.capacity;
    }

    public boolean setCapacity(long capacity) {
        if (capacity >= getSize()) {
            this.capacity = capacity;
            return true;
        }
        return false;
    }

    public long getSize() {
        return this.size;
    }

    private void setSize() {
        this.size += 1;
    }

    public ArrayList<Worker> getList() {
        return this.list;
    }

    public boolean add(Worker worker) {
        if (getSize() < getCapacity()) {
            for (Worker item : getList()) {
                if (item.getCode() == worker.getCode()) {
                    return false;
                }
            }
            setSize();
            this.list.add(worker);
            return true;
        }
        return false;
    }

    public void printWorkerList() {
        for (Worker wk : getList()) {
            System.out.println(wk);
        }
    }

    public void printWorkerList(int productCount, int FIND) {
        /*
         * FIND > 0 : finding all workers > productCount
         * FIND = 0 : finding all workers = productCount
         * FIND < 0 : finding all workers < productCount
         * */
        for (Worker wk : getList()) {
            if (FIND == 0 && wk.getProductCount() == productCount) {
                System.out.println(wk);
            }
            if (FIND > 0 && wk.getProductCount() > productCount) {
                System.out.println(wk);
            }
            if (FIND < 0 && wk.getProductCount() < productCount) {
                System.out.println(wk);
            }
        }
    }

    public void sortDescendingProduct() {
        ArrayList<Worker> workerList = getList();
        int size = (int) getSize();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                Worker before = workerList.get(i);
                Worker after = workerList.get(j);
                if (after.getProductCount() > before.getProductCount()) {
                    Collections.swap(workerList, i, j);
                }
            }
        }
    }
}
