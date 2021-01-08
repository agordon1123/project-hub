package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import com.alexrgordon.projecthub.dal.dao.model.Board;

// creating a base user class for development purposes until auth layer set up
@Data
@Entity 
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Username")
    private String username;

    @JoinTable(
        name = "UserBoards",
        joinColumns = @JoinColumn(
            name = "UserId",
            referencedColumnName = "Id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "BoardId",
            referencedColumnName = "Id"
        )
    )
    @OneToMany
    @ToString.Exclude
    private List<Board> boards;

    public User() { }

    // CREATE 
    private static User toUser(com.alexrgordon.projecthub.api.model.User user) {
        User mapped = new User();
        if (user.getId() != null) { // UPDATE
            mapped.setId(user.getId());
        }
        mapped.setFirstName(user.getFirstName());
        mapped.setLastName(user.getLastName());
        mapped.setUsername(user.getUsername());
        return mapped;
    }

}
