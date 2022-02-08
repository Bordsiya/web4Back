package com.example.web4.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "LOGIN"))
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column (name = "ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "LOGIN", nullable = false)
    private String login;

    @Column (name = "PASSWORD", nullable = false)
    private String password;

    public UserEntity(String login, String password){
        this.login = login;
        this.password = password;
    }

}
