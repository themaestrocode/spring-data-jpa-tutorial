package com.themaestrocode.spring.data.jpa.tutorial.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
// override these attributes to define how they should be saved directly in the DB
@AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
                    @AttributeOverride(name = "email", column = @Column(name = "guardian_email")),
                    @AttributeOverride(name = "mobile", column = @Column(name = "guardian_phone_no"))})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
