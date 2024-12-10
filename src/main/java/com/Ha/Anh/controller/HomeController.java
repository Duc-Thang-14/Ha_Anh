package com.Ha.Anh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Trả về trang đăng nhập
    }

    @GetMapping("/default")
    public String defaultPage() {
        return "redirect:/defaultHandler"; // Điều hướng đến handler phù hợp
    }
}
