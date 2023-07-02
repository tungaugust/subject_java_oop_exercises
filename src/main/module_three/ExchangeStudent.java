package main.module_three;

import java.time.LocalDate;

public class ExchangeStudent extends Student{
    public ExchangeStudent(String SID, String name, String sex, LocalDate birthDay, String address, String major, String faculty, int year) {
        super(SID, name, sex, birthDay, address, major, faculty, year);
        this.setLevel("Exchange");
    }
}
