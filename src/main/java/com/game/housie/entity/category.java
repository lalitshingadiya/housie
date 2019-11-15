package com.game.housie.entity;

import javax.persistence.*;

@Entity()
@Table(name="category")
public class category
{
    @Id
    @Column(name="uid",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int cId;

    @Column(name="type",nullable = false)
    String categoryType;

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }
}
