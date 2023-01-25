package com.sample.javab3.studentservice.db.repository;

import com.sample.javab3.studentservice.db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
