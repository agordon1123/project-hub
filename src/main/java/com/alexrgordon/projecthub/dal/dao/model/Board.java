package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="project_hub_db.Boards")
public class Board {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;
    // @OneToMany
    // @MappedBy("users")
    // private List<User> users;
    // @OneToMany
    // @MappedBy("users")
    // private List<ListModel> lists;
    // private User createdBy;
    // private Date createdAt;

    public Board() { }

    public static Board toBoard(com.alexrgordon.projecthub.api.model.Board board) {
        Board mapped = new Board();
        mapped.setName(board.getName());
        return mapped;
    }

}
