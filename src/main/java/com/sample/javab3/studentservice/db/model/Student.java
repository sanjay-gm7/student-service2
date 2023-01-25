package com.sample.javab3.studentservice.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "studentsInfoTable")
public class Student {
    @Id
    @GeneratedValue
    private int rollNum;

    private String name;
    private int age;
    private String standard;
}
