package com.themaestrocode.spring.data.jpa.tutorial.repository;

import com.themaestrocode.spring.data.jpa.tutorial.entity.Guardian;
import com.themaestrocode.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("victorsoderu@gmail.com")
                .firstName("victor")
                .lastName("soderu")
                //.guardianName("mr. soderu")
                //.guardianEmail("soderu@outlook.com")
                //.guardianMobile("09123456787")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Student student = Student.builder()
                .emailId("victoriaajayi@gmail.com")
                .firstName("victoria")
                .lastName("ajayi")
                .guardian(new Guardian("mr. Ajayi", "ajayibolade@outlook.com", "08050763891"))
                .build();

        studentRepository.save(student);
        System.out.println("\nStudent details: " + student + "\n");
    }

    @Test
    public void fetchALlStudent() {
        List<Student> stdudentList = studentRepository.findAll();
        System.out.println("Student: " + stdudentList);
    }

    @Test
    public void findStudentByFirstName() {
        String firstName = "victor";

        List<Student> studentsWithMatchingFirstName = studentRepository.findByFirstName(firstName);
        System.out.println("Students with matching first name: " + studentsWithMatchingFirstName);
    }

    @Test
    public void findStudentsByMatchingName() {
        String name = "vic";

        List<Student> studentsWithNameMatchingText = studentRepository.findByFirstNameContaining(name);
        System.out.println("\nStudents with name containing: " + studentsWithNameMatchingText + "\n");
    }

    @Test
    public void findByLastNameNotNull() {
        List<Student> studentsWithLastName = studentRepository.findByLastNameNotNull();
        System.out.println("\nStudents with last name: " + studentsWithLastName + "\n");
    }

    @Test
    public void findByGuardianName() {
        String guardianName = "mr. soderu";

        List<Student> studentWithTheGuardianName = studentRepository.findByGuardianName(guardianName);
        System.out.println("\nStudent with the guardian name: " + studentWithTheGuardianName + "\n");
    }

    @Test
    public void getStudentByEmailAddress() {
        String email = "victorsoderu@gmail.com";

        Student student = studentRepository.getStudentByEmailAddress(email);
        System.out.println("\nStudent with the provided email: " + student + "\n");
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String email = "victorsoderu@gmail.com";

        System.out.println("The first name: " + studentRepository.getStudentFirstNameByEmailAddress(email));
    }

    @Test
    public void getStudentByEmailAddressNative() {
        String email = "victorsoderu@gmail.com";

        Student student = studentRepository.getStudentByEmailAddressNative(email);
        System.out.println("student fetched by native query: " + student + "\n");
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        String email = "victorsoderu@gmail.com";

        Student student = studentRepository.getStudentByEmailAddressNative(email);
        System.out.println("student fetched by native query named param: " + student + "\n");
    }

    @Test
    public void updateStudentNameByEmailId() {
        String firstName = "abimbola", email = "victorsoderu@gmail.com";

        studentRepository.updateStudentNameByEmailId(firstName, email);
    }
}