package org.example.service;

import org.example.domain.mysql.StudentDetail;
import org.example.repository.mysql.StudentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public StudentDetailRepository studentDetailsRepository;

    public StudentService(StudentDetailRepository studentDetailsRepository) {
        this.studentDetailsRepository = studentDetailsRepository;
    }

    public List<StudentDetail> fetchAllStudent() {
     return studentDetailsRepository.findAll();
    }

}
