package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="project_hub_db.Boards")
public class Board {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;

    // @OneToMany
    // private List<User> users;

    @OneToMany(mappedBy="board")
    @ToString.Exclude
    private List<ListModel> lists;

    // private User createdBy;
    // private Date createdAt;

    public Board() { }

    // CREATE
    public static Board toBoard(com.alexrgordon.projecthub.api.model.Board board, Integer userId) {
        Board mapped = new Board();
        // User userFK = new User();
        // userFK.setId(userId);
        // mapped.setUser(userFK);
        mapped.setId(board.getId());
        mapped.setName(board.getName());
        return mapped;
    }

    // UPDATE 
    public static Board toBoard(com.alexrgordon.projecthub.api.model.Board board) {
        Board mapped = new Board();
        // User userFK = new User();
        // userFK.setId(board.getUser().getId());
        // mapped.setUser(userFK);
        mapped.setId(board.getId());
        mapped.setName(board.getName());
        return mapped;
    }

}
