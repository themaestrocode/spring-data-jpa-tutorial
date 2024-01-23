package com.themaestrocode.spring.data.jpa.tutorial.repository;

import com.themaestrocode.spring.data.jpa.tutorial.entity.Course;
import com.themaestrocode.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    private Course course = Course.builder()
            .title("Python for AI")
            .credit(3 )
            .build();

    private CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("www.themaestrocode.com/python")
            .course(course)
            .build();

    @Test
    public void saveCourseMaterial() {
        CourseMaterial newCourseMaterial = courseMaterialRepository.save(courseMaterial);
        System.out.println("Course: " + newCourseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> listOfCourseMaterials = courseMaterialRepository.findAll();
        System.out.println("All course materials: " + listOfCourseMaterials);
    }
}