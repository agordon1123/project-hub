package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// creating a base user class for development purposes until auth layer set up
@Data
@Entity 
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Username")
    private String username;

    // private List<Board> boards;

    public User() { }

    private static User toUser(com.alexrgordon.projecthub.api.model.User user) {
        User mapped = new User();
        mapped.setFirstName(user.getFirstName());
        mapped.setLastName(user.getLastName());
        mapped.setUsername(user.getUsername());
        return mapped;
    }

}
