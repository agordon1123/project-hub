package com.alexrgordon.projecthub.dal.dao.model;

import lombok.Data;

// creating a base user class for development purposes
// todo: create auth middleware
@Data
public class User {

    public User() { }

    private String firstName;
    private String lastName;
    private String username;
    // private String password;

}
