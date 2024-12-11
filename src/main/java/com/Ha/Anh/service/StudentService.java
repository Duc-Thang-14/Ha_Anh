package com.Ha.Anh.service;

import com.Ha.Anh.model.Student;
import com.Ha.Anh.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Lấy tất cả sinh viên từ cơ sở dữ liệu
    }

    public void saveStudent(Student student) {
        studentRepository.save(student); // Lưu hoặc cập nhật sinh viên
    }

    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId); // Xóa sinh viên theo ID
    }

    public boolean isStudentIDExists(String studentID) {
        return studentRepository.existsById(studentID);
    }

    public Student save(Student student) {
        // Lưu hoặc cập nhật sinh viên
        return studentRepository.save(student);
    }
}
