package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student_;
import com.example.demo.filter.StudentFilter;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class StudentSpecification {
    private static final StudentFilter filter =new StudentFilter();

    public static Specification<Student> buildCombineQuerySpecification(String value, String fieldConditions){
        Specification<Student> conditions = Specification.where(null);
        if (fieldConditions.equals(filter.getName())){
            conditions = CommonSpecification.buildLikeSpecification(value, fieldConditions);
        }
        return conditions;
    }

    public static Specification<Student> isCurrentTimeLessThanOrEqualsFoundedDate(LocalDate activeDate){
        return ((root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.lessThanOrEqualTo(root.get(Student_.FOUNDED_DATE).as(LocalDate.class),activeDate));
    }
    public static Specification<Student> isCurrentTimeGreaterOrEqualsEndDate(LocalDate activeDate){
        return ((root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(root.get(Student_.END_DATE).as(LocalDate.class),activeDate));
    }
}
