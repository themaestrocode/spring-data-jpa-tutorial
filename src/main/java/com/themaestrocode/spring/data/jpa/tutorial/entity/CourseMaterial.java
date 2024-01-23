package com.themaestrocode.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@Table(name = "course_material_table",
        uniqueConstraints = @UniqueConstraint(name = "url_unique", columnNames = "url"))
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "courseMaterial_sequence", sequenceName = "courseMaterial_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterial_sequence")
    private Long courseMaterialId;
    private String url;

    //FetchType refers to whether the course will be retrieved when retrieving a course material from the DB.
    //in the case of LAZY, the course data will not be fetched.
    //CascadeType.ALL means that we can save a course directly when saving a course material.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
