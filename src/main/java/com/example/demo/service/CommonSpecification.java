package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class CommonSpecification {
    public static Specification<Student> buildLikeSpecification(String value, String field){
        return (root, query, builder) -> builder.like(root.get(field), "%" + value + "%");
    }

    public static Specification<Student> buildEqualSpecification(String value, String field){
        return (root, query , builder) -> builder.equal(root.get(field), value);
    }
}
