package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        String currentDate ="4";
        LocalDate localDate = LocalDate.parse(currentDate);
        Specification<Student> conditions =Specification.where((StudentSpecification.isCurrentTimeGreaterOrEqualsEndDate(localDate)))
                                                        .and(StudentSpecification.isCurrentTimeLessThanOrEqualsFoundedDate(localDate))
                                                        .and(StudentSpecification.buildCombineQuerySpecification("a","name"));
        return studentRepository.findAll(conditions);
    }
}
