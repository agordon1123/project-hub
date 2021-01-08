package com.alexrgordon.projecthub.api.model;

import lombok.Data;

@Data
public class User {

    public User() { }

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;

}
