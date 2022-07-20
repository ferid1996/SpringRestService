package com.example.demoSpring.entity;


import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{

    @Id
    @SequenceGenerator(name ="user_seq_gen",sequenceName = "user_gen",initialValue = 10,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name = "id")
    private Long id;


    @Column(name = "name",length = 100)
    private String fistname;

    @Column(name = "surname",length = 100)
    private String lastname;
}
