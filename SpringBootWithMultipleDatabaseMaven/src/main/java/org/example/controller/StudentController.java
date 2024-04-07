package org.example.controller;

import org.example.domain.mysql.StudentDetail;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public List<StudentDetail> fetchAllStudents() {
        return studentService.fetchAllStudent();
    }
}
