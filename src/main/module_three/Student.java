package main.module_three;

import java.time.LocalDate;

public abstract class Student {
    private String SID; // Student ID
    private String name; // ho va ten
    private String sex; // gioi tinh
    private LocalDate birthDay; // ngay sinh
    private String address; // dia chi

    private String level; // cap bac
    private String major; // nganh
    private String faculty; // khoa
    private int year; // nam nhap hoc


    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Student(String SID, String name, String sex, LocalDate birthDay, String address, String major, String faculty, int year) {
        this.SID = SID;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.address = address;
        this.major = major;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SID='" + SID + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", major='" + major + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
