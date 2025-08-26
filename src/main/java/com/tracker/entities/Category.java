package com.tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    private Integer categoryId;
    private String categoryName;

    /*@Column("user_id")
    @ManyToOne
    @JoinColumn("user_id")
    private User user;*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
