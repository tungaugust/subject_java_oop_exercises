package main.module_three;

import main.module_two.CD;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> list;
    private int count;

    public int getSize() {
        return this.count;
    }

    private void setCount(int i) {
        this.count += i;
    }


    public ArrayList<Student> getList() {
        return list;
    }

    private void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public StudentManager() {
        setList(new ArrayList<Student>());
        this.count = 0;
    }

    public boolean add(Student student) {
        for (Student st: getList()) {
            if (st.getSID().equals(student.getSID())) {
                return false;
            }
        }
        getList().add(student);
        setCount(1);
        return true;
    }
    public boolean remove(String sid) {
        Student temp;
        for (int i = 0; i < getSize(); i++) {
            temp = getList().get(i);
            if (temp.getSID().equals(sid)) {
                getList().remove(i);
                setCount(-1);
                return true;
            }
        }
        return false;
    }

    public void printAll(){
        for (int i = 0; i < getSize(); i++) {
            System.out.println(getList().get(i));
        }
    }
}
