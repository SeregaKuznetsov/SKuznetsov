package ru.kpfu.itis.group11506.groupSort;

import java.time.LocalDate;
import java.time.Month;

public class Student {

    private String name;
    private LocalDate date;

    public Student(String name, int year, Month month, int number) {
        this.name = name;
        this.date = LocalDate.of(year, month, number);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}