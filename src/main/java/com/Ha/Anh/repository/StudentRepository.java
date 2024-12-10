package com.Ha.Anh.repository;

import com.Ha.Anh.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    // JpaRepository sẽ cung cấp các phương thức như findAll, save, delete, v.v.
}
