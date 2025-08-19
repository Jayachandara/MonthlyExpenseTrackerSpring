package com.tracker.entities;

import jakarta.persistence.*;

import java.util.Date;


/*CREATE TABLE users (
        user_id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(100),
email VARCHAR(100) UNIQUE,
password_hash TEXT,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);*/

//plain pojo
@Entity
@Table(name="users")
public class User {

    private Integer userID;
    private String username;
    private String password;
    private Integer age;
    private String email;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password_hash")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
