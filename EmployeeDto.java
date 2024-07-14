package com.boostmytool.bestemp;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;


public class EmployeeDto {
    @NotEmpty(message = "The name is required")
    private String name;

    @NotEmpty(message ="The name is required")
    private String city;

    @NotEmpty(message ="Then name is required")
    private String designation;

    @Min(0)
    private double salary;

    @Size(min = 10, message ="The about should be at least 10 characters")
    @Size(max = 2000, message ="The about cannot exceed 2000 characters")
    private String about;

    private MultipartFile imageFile ;

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

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }


    
}
