package com.Ha.Anh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {



    @GetMapping
    public String studentPage() {
        return "student"; // Trang chính dành cho Student
    }

    // Thêm phương thức cho trang quản lý điểm
    @GetMapping("/point-management")
    public String pointManagementPage() {
        return "point_management"; // Trang Quản lý điểm
    }


}
