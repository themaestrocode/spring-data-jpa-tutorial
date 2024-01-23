package com.themaestrocode.spring.data.jpa.tutorial.repository;

import com.themaestrocode.spring.data.jpa.tutorial.entity.Course;
import com.themaestrocode.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    private Course courseAssemblyLang = Course.builder()
            .title("Assembly Language Fundamentals 1")
            .credit(8)
            .build();

    private Course courseCpp = Course.builder()
            .title("C++ for Beginners")
            .credit(5)
            .build();

    private Course courseGoLang = Course.builder()
            .title("Learn Go Language Volume 1")
            .credit(3)
            .build();

    private Teacher teacher = Teacher.builder()
            .firstName("Olusola")
            .lastName("Ajayi")
            //.courses(List.of(courseAssemblyLang, courseCpp, courseGoLang))
            .build();


    @Test
    public void saveTeacher() {
        teacherRepository.save(teacher);
        System.out.println("\nNew teacher: " + teacher + "\n");
    }
}