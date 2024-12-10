package com.Ha.Anh.controller;

import com.Ha.Anh.model.Student;
import com.Ha.Anh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String adminPage() {
        return "admin"; // Trang chính dành cho Admin
    }

//    @GetMapping("/manage-students")
//    public String manageStudents(Model model) {
//        List<Student> students = studentService.getAllStudents(); // Lấy danh sách sinh viên từ service
//        model.addAttribute("students", students); // Thêm danh sách vào mô hình
//        return "manage_students"; // Trả về trang quản lý sinh viên
//    }

    @GetMapping("/manage-schedule")
    public String manageSchedule() {
        return "manage_schedule"; // Quản lý thời khóa biểu
    }

    @GetMapping("/manage-subjects")
    public String manageSubjects(){
        return "manage_subjects"; // Trả về trang quản lý môn học
    }

    @GetMapping("/manage-students")
    public String manageStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        System.out.println("Students: " + students); // Debug
        model.addAttribute("students", students);
        return "manage_students";
    }



    // Thêm Sinh viên
    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student, Model model) {
        if (student.getStudentID() == null || student.getStudentID().isEmpty()) {
            model.addAttribute("message", "Mã sinh viên không được để trống!");
            return "manage_students";
        }
        studentService.saveStudent(student);
        model.addAttribute("message", "Thêm sinh viên thành công!");
        return "redirect:/admin/manage-students";
    }


    // Sửa Sinh viên
    @PostMapping("/edit-student")
    public String editStudent(@ModelAttribute Student student, Model model) {
        studentService.saveStudent(student); // Cập nhật sinh viên
        model.addAttribute("message", "Sửa sinh viên thành công!");
        return "redirect:/admin/manage-students"; // Quay lại trang quản lý sinh viên
    }

    // Xóa Sinh viên
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable String id, Model model) {
        studentService.deleteStudent(id); // Xóa sinh viên
        model.addAttribute("message", "Xóa sinh viên thành công!");
        return "redirect:/admin/manage-students"; // Quay lại trang quản lý sinh viên
    }




}
