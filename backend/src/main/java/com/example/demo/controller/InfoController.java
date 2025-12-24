package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InfoController {
    @GetMapping("/info")
    public String getInfo() {
        String studentInfo = System.getenv("STUDENT_INFO");
        return studentInfo != null ? studentInfo : "2340231214-张得伟 (从环境变量读取失败)";
    }
    // 可选：添加一个根路径访问
    @GetMapping("/")
    public String home() {
        return "DevOps自动化部署项目已运行。请访问 /info 查看学生信息。";
    }
}
