package main.module_two;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {
    private String name;
    private LocalDate openDay;
    private int duration;   //months
    private ArrayList<CStudent> studentList;
    private final static int CAPACITY = 20;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) throws RuntimeException{
        if (name.equals("")){
            throw new RuntimeException("Course needs have a name.");
        }
        this.name = name;
    }

    public LocalDate getOpenDay() {
        return openDay;
    }

    public void setOpenDay(LocalDate openDay) {
        this.openDay = openDay;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws RuntimeException {
        if(duration < 1){
            throw new RuntimeException("Duration is allowed less than 1 (month).");
        }
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size += 1;
    }

    public Course(String name, LocalDate openDay, int duration) {
        setName(name);
        setOpenDay(openDay);
        setDuration(duration);
        this.studentList = new ArrayList<CStudent>();
        this.size = 0;
    }
    public boolean contains(String name){
        for (CStudent s: this.studentList){
            if (s.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean add(CStudent student){
        if (getSize() < this.CAPACITY && !contains(student.getName())){
            this.studentList.add(student);
            return true;
        }
        return false;
    }

    public LocalDate getCloseDay(){
        LocalDate closeDay = getOpenDay().plusMonths(getDuration()).minusDays(1);
        return closeDay;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", openDay=" + openDay +
                ", closeDay=" + getCloseDay() +
                ", duration=" + duration +
                ", studentCount=" + studentList.size() +
                '}';
    }
}
