package com.themaestrocode.spring.data.jpa.tutorial.repository;

import com.themaestrocode.spring.data.jpa.tutorial.entity.Course;
import com.themaestrocode.spring.data.jpa.tutorial.entity.Guardian;
import com.themaestrocode.spring.data.jpa.tutorial.entity.Student;
import com.themaestrocode.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Teacher teacher = Teacher.builder()
            .firstName("magdalene")
            .lastName("mary")
            .build();

    private Student student = Student.builder()
            .emailId("vicctorosi@gmail.com")
            .firstName("victor")
            .lastName("oshimen")
            .guardian(new Guardian("mr. oshimen", "oshimenfather@gmail,com", "09234567876"))
            .build();

    @Test
    public void printCourses() {
        List<Course> allCourses = courseRepository.findAll();
        System.out.println("\nAll courses available: " + allCourses + "\n");
    }

    @Test
    public void saveCourseWithTeacher() {
        Course course = Course.builder()
                .title("Data structure and Algorithm")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
        System.out.println("\nCourse: " + course + "\n");
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 3);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("\nTotal pages: " + totalPages);
        System.out.println("\nTotal elements: " + totalElements);
        System.out.println("\nCourses page 0: " + courses + "\n");
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 3, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("\nCourses sorted by title: " + courses + "\n");
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("1", firstPageTenRecords).getContent();

        System.out.println("\ncourses with first 10records containing '1': " + courses + "\n");
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Course course = Course.builder()
                .title("Java for everyone")
                .credit(4)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
        System.out.println("\nCourse added: " + course + "\n");
    }
}