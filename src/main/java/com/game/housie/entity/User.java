package com.game.housie.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;

    private String roles;


    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    @Column(name = "empcode")
    private int empcode;


    @Column(name = "firstname")
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "lastname")
    private String lastname;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
