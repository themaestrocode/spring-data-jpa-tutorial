package com.themaestrocode.spring.data.jpa.tutorial.repository;

import com.themaestrocode.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //using JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailAddress);

    //using JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    //native query
    @Query(value = "SELECT * FROM student_table WHERE email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailAddress);

    //native query with named parameter
    @Query(value = "SELECT * FROM student_table WHERE email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailAddress);

    @Modifying
    @Transactional
    @Query(value = "UPDATE student_table SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
