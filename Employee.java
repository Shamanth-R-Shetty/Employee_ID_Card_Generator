package com.boostmytool.bestemp;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id;

    private String name;
    private String city;
    private String designation;
    private double salary;

    @Column(columnDefinition = "TEXT")
    private String about;
    private Date joinedAt;
    private String imageFileName;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public Date getJoinedAt() {
        return joinedAt;
    }
    public void setJoinedAt(Date joinedAt) {
        this.joinedAt = joinedAt;
    }
    public String getImageFileName() {
        return imageFileName;
    }
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }


}
