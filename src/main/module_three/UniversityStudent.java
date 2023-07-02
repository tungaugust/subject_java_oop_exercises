package main.module_three;

import java.time.LocalDate;

public class UniversityStudent extends Student{
    public UniversityStudent(String SID, String name, String sex, LocalDate birthDay, String address, String major, String faculty, int year) {
        super(SID, name, sex, birthDay, address, major, faculty, year);
        this.setLevel("University");
    }
}
