package main.module_three;

import java.time.LocalDate;

public class IntermediateStudent extends Student{
    public IntermediateStudent(String SID, String name, String sex, LocalDate birthDay, String address, String major, String faculty, int year) {
        super(SID, name, sex, birthDay, address, major, faculty, year);
        this.setLevel("Intermediate");
    }
}
