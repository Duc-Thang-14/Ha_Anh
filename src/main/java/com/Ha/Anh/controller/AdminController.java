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


    // Xóa Sinh viên
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable String id, Model model) {
        studentService.deleteStudent(id); // Xóa sinh viên
        model.addAttribute("message", "Xóa sinh viên thành công!");
        return "redirect:/admin/manage-students"; // Quay lại trang quản lý sinh viên
    }

    @PostMapping("/edit-student")
    public String editStudent(@ModelAttribute Student student, Model model) {
        studentService.saveStudent(student); // Lưu cập nhật
        return "redirect:/admin/manage-students"; // Cập nhật danh sách
    }

    // Hiển thị form để sửa thông tin sinh viên
    @GetMapping("/edit-student/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student); // Thêm đối tượng student vào model
            return "edit_student";  // Trả về trang edit_student.html
        } else {
            model.addAttribute("message", "Sinh viên không tồn tại!");
            return "redirect:/admin/manage-students"; // Nếu không tìm thấy sinh viên, quay lại trang quản lý sinh viên
        }
    }

    // Cập nhật thông tin sinh viên
    @PostMapping("/update-student")
    public String updateStudent(@ModelAttribute Student student, Model model) {
        studentService.saveStudent(student);  // Lưu lại thông tin sinh viên đã chỉnh sửa
        model.addAttribute("message", "Cập nhật sinh viên thành công!");
        return "redirect:/admin/manage-students";  // Quay lại trang quản lý sinh viên
    }


}
