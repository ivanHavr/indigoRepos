package com.findigo.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;

@Entity
@Table(name = "users", schema = "findigo_main")
@Data
@Slf4j
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;
}
