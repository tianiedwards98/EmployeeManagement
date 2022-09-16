package com.edwards.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email_id")
    private String emailId;

    public Employee( String firstname, String lastname, String emailId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
    }
}
