package com.mlm.stdApp.model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotBlank
    private String lastName;
    @NotEmpty
    private int roomNumber;
    @NotEmpty
    private int accessCardNumber;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, int roomNumber, int accessCardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.accessCardNumber = accessCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAccessCardNumber() {
        return accessCardNumber;
    }

    public void setAccessCardNumber(int accessCardNumber) {
        this.accessCardNumber = accessCardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
