package com.themaestrocode.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Student_table",
        uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address")) // to change the default student table name
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence"
    )
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
